package Airplane;

import java.util.ArrayList;
import java.util.List;

public class Airplane_List_Class extends Airplane implements Runnable {
    private ArrayList<Airplane> airplanes;
    private Traffic_Network control;

    public Airplane_List_Class() {
        this.airplanes = new ArrayList<>();
    }

    public void createAirplane() {
        Airplane airplane = new Airplane();
        
        airplanes.add(airplane);
    }
    public void addAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }
    public void removeAirplane(int id) {
        for (int i = 0; i < airplanes.size(); i++) {
            if (airplanes.get(i).getID() == id) {
                airplanes.remove(i);
                break;
            }
        }
    }
    public void sendTask(Task task) {
    	
    	switch(task.getSecondaryLabel())
    	{
    	case LAND:
    		if(control.getR1().isOpen()==true||control.getR2().isOpen())
    		{
    			if(control.getR1().isOpen()==true)
    			{
    			
    			land(task.getId(),"R1");
    			control.getR1().changeLinkstatus();
        	    break;
    			}
    			if(control.getR2().isOpen()==true)
    			{
    			
    			land(task.getId(),"R1");
    			control.getR2().changeLinkstatus();
        	    break;
    			}
    			
    		}
    		break;
    	
    	   
		
		case DEPART:
			depart();
			break;
		//case ENTER_LINK:
			//break;
		//case EXIT_LINK:
			//break;
		
		case HOLD:
			hold(task.getId());
			break;
		case MOVE:
			move(task.getId());
			break;
		case PARK:
			if(control.getT1().isopen()==true||control.getT2().isopen())
    		{
    			if(control.getT1().isopen()==true)
    			{
    			
    			park(task.getId() ,"T1");
    			control.getT1().changeLinkstatus();
        	    break;
    			}
    			if(control.getT2().isopen()==true)
    			{
    			
    			park(task.getId(),"T2");
    			control.getT2().changeLinkstatus();
        	    break;
    			}
    			
    		}
			break;
    		
    	}		
    }
    public Airplane getTargetAirplane(int id)
    {
    	
    	 for (int i = 0; i < airplanes.size(); i++) {
             if (airplanes.get(i).getID() == id) {
            	 return airplanes.get(i);
             }
         }
		return null;
     }

	@Override
	public void run() {
		
	}    
}
