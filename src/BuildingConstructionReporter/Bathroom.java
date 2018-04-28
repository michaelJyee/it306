package BuildingConstructionReporter;
/*
 * Michael Yee
 * Albert Wei
 * Thu Tran
 * IT 306 - 001
 * 4-21-2018
 *
 *
 * Project - PHASE IV:Preliminary System Implementation
 * */
public class Bathroom extends Room{
	//Declare Constants for min and max cost
	public static final double MIN_COST = 400;
	public static final double MAX_COST = 500;
	//Declare the instance variable
	private double roomCost;
	private boolean bathtub;
	private boolean showerCurtain;
	

	//Constructor
	public Bathroom() {
		super();
	}
	/**
   	*Returns cost Of Room
    *returns: Double
  **/
	public double getRoomCost( ) { return roomCost; }
	
	/**
   	*Returns is there a bathtub in a Bathroom
    *returns: boolean
  **/
	public boolean isBathtub() {
		return bathtub;
	}
	/**
   	*Returns is there a shower curtain in a Bathroom
    *returns: boolean
  **/
	public boolean isShowerCurtain() {
		return showerCurtain;
	}
	
	/**
   	*Sets room cost Validates parameter is within MIN_COST AND MAX_COST
    *@param roomCost: double
    *returns: void
  **/
	public void setRoomCost(double roomCost ) {
		if (roomCost < MIN_COST || roomCost > MAX_COST) {
			throw new IllegalArgumentException("Room cost must be between " + MIN_COST + " and " + MAX_COST);
		}
		this.roomCost = roomCost;
	}
	/**
   	*Sets the value(true or false) of a bathtub
    *@param bathtub: boolean
    *returns: void
  **/
	public void setBathtub(boolean bathtub) {
		this.bathtub = bathtub;
	}
	/**
   	*Sets the value (true or false) of a showerCurtain
    *@param showerCurtain: boolean
    *returns: void
  **/
	public void setShowerCurtain(boolean showerCurtain) {
		this.showerCurtain = showerCurtain;
	}
	
	/**
   	*Returns the total cost of a bathroom
    *returns: Double
  **/
	public double getTotalCost()
	{
		double totalCost = 0;
		if(this.bathtub == true)
		{
			totalCost += 50;
		}
		if(this.showerCurtain == true)
		{
			totalCost += 100;
		}
		
		return totalCost;
	}
	
	@Override
	/**
   	*Returns a string representation of a Bathroom
    *returns: String
  **/
	public String toString() {
		return "Bathroom [roomCost=" + roomCost + ", bathtub=" + bathtub + ", showerCurtain=" + showerCurtain + "]";
	}
	
}
