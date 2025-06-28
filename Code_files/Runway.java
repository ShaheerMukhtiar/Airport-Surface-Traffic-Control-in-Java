package Airplane;
public class Runway {
    private  boolean isOpen;
    private boolean isOccupied;
    private String Id;
    

    public Runway() {}
    public Runway(boolean isOpen, boolean isOccupied, String Id) {
        this.isOpen = isOpen;
        this.isOccupied = isOccupied;
        this.Id=Id;
    }


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}
	public void changeLinkstatus()
	{
		if (isOpen==true)
		{
			isOpen=false;
		}
		if (isOpen==false)
		{
			isOpen=true;
		}
	}
	
	public void changeOccupancyStatus()
	{
		if(isOpen==true)
		{
			isOccupied=false;
		}
		isOccupied=true;
	}
	public boolean isOpen()
	{
		return isOpen;
		
	}
}
