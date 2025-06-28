public class Airplane {
    private  int ID;
    private String orientation;
    private String destination;
    private int from;
    private int to;
    private int totalCost;
    Airplane_states state;
    private boolean Destination_indicator;
    private char[] path = new char[60];
    private Airplane_states airplane_states;
    //Task task;
   // private LocalDateTime start;
   // private LocalDateTime end;

    
   public Airplane( String orientation, String destination, String from, String to, int totalCost, int reachDestination,
                    char[] path, int ID)
    {
        ++ID;
    	this.setID(ID);
        this.orientation = orientation;
         this.destination = destination;
        this.setFrom(from);
        this.setTo(to);
        this.setTotalCost(totalCost);
        this.setReachDestination(reachDestination);
        this.path = path;
        //this.start = start;
       // this.end = end;
    }
	
	public Airplane() {
		// TODO Auto-generated constructor stub
	}

	
	public String getorientation()
	{
		setStateToApproach();
		return orientation;
	}
	public String getdestination()
	{
		return destination;
	}
	public void move(String id)
	{
		
		System.out.println("Airplane with" + id+ "is moving .")	;
		
	}
	public void hold(String id)

	{
		setStateToHold();
		System.out.println("Airplane with" + id+ "is holding")	;
		
	}
	public void depart()
	{
		setStateToTakeoff();
	}
	public void park(String id , String taxii) {
		System.out.println("Airplane with" + id+ "is parking on taxiway" +taxii)	;
		
		
	}
	public void land(String id, String runway)
	{
		System.out.println("Airplane with" + id+ "is landing")	;
	}
public void exit()
{
	
}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}

	public boolean getReachDestination() {
		return Destination_indicator;
	}

	public void setReachDestination(boolean  reachDestination) {
		this.Destination_indicator = reachDestination;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean isDestination_indicator() {
		return Destination_indicator;
	}

	public void setDestination_indicator(boolean destination_indicator) {
		Destination_indicator = destination_indicator;
	}

	public void receiveTask(Task task) {
		// TODO Auto-generated method stub
		
	}
	public synchronized void setStateToApproach() {
		     state= Airplane_states.Approach;
		 
		 }
		 public synchronized void setStateToLand() {
		 state = Airplane_states.Land;
		 }
		 public synchronized void setStateToTaxi() {
		 state = Airplane_states.Taxii;
		 }
		 public synchronized void setStateToTakeoff() {
		 state=Airplane_states.Takeoff;
		 }
		 public synchronized void setStateToHold() {
			 state=Airplane_states.Hold;
		 }
		 public synchronized void setStateToAirphase() {
			 state=Airplane_states.Airphase;
		 }
};
