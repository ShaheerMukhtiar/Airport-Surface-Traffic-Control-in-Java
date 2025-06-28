package Task_queue;

import java.util.Scanner;

public class Task {
    protected String primary_label;
    protected String secondary_label;
    protected int priority_data;
    protected long process_time;
    protected long execution_time;
    protected int AirplaneID;

   // private Link_object link = new Link_object();
    private Scanner input=new Scanner(System.in);
    public Task() {
    }

    public Task(String label1, String label2) {
        primary_label = label1;
        secondary_label = label2;
        process_time = calculateProcessTime(label2);
        execution_time = 0;
        AirplaneID = 0;

      //  link.setTaxiwayID(getTaxiWayIDFromUser());
     //   link.setTaxiwayID(getRunWayIDFromUser());
      //  link.setGateID(getGateIDFromUser());
    }

    // Getters
    public String getPrimaryLabel() {
        return primary_label;
    }

    public String getSecondaryLabel() {
        return secondary_label;
    }

    public void setExecutionTime(long x) {
        this.execution_time = x;
    }

    public long getExecutionTime() {
        return this.execution_time;
    }

    public long calculateProcessTime(String L2) {
    	
    	 if ("Land_an_Airplane_Task".equals(L2)) {
    		this.priority_data=1;
    	   return 5;
       }
    	 else if ("Exit_a_Link_Task".equals(L2)) {
    		 this.priority_data=2;
    		 return 10;
    	   
       }
    	 else if ("Enter_a_Link_Task".equals(L2)) {
      	   this.priority_data=2;
      	   return 10;
         }
    	 else if ("Receive_an_Object_Task".equals(L2)) {
      	   this.priority_data=2;
      	   return 10;
         }
    	 else if ("Release_an_Object_Task".equals(L2)) {
      	   this.priority_data=3;
      	   return 10;
         }
    	 else if ("Close_This_Link_Task".equals(L2)) {
      	   this.priority_data=2;
      	   return 5;
         }
    	 else if ("Open_This_Link_Task".equals(L2)) {
      	   this.priority_data=2;
      	   return 5;
         }
    	 else if ("Move_an_Airplane".equals(L2)) {
        	   this.priority_data=3;
        	   return 10;
         }
    	 else if ("Hold_an_Airplane_in_Position".equals(L2)) {
        	   this.priority_data=1;
        	   return 5;
         }
    	 else if ("Park_an_Airplane.".equals(L2)) {
        	   this.priority_data=3;
        	   return 15;
         }
    	 else {
    		 System.out.println("Invalid Label!");
    	 }
    	 return 0;
       
    }

    // Getter and setter for Link ID
    public int getTaxiWayIDFromUser() {
        System.out.print("\nEnter Taxiway ID: ");
        return input.nextInt();
    }

    public int getRunWayIDFromUser() {
        System.out.print("\nEnter Runway ID: ");
        return input.nextInt();
    }

    
	public int getGateIDFromUser() {
        System.out.print("\nEnter Gate ID: ");
        return input.nextInt();
    }

    public int getAirplaneIDFromUser() {
        System.out.print("\nEnter Plane ID: ");
        return input.nextInt();
    }
}
