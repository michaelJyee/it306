package BuildingConstructionReporter;
/*
 * @author Michael Yee
 * @author Albert Wei
 * @author Thu Tran
 * 
 * IT 306 - 001
 *
 * This is the data definition class for LivingRoom.
 * It will store the specific information for LivingRoom type of Room.
 * such as room cost, sofa, and television.
 * This class have a getTotalCost() method to calculate the total based on does it have a sofa and television.
 * This class have a toString() method to output the LivingRoom information.
 * */

public class LivingRoom extends Room{
	//Declare Constants for min and max cost
	public static final double MIN_COST = 100;
	public static final double MAX_COST = 200;
	//Declare the instance variables
	private double roomCost;
	private boolean sofa;
	private boolean television;
	
	//Constructor
	public LivingRoom() {
		super();
	}
	
	/**
   	*Returns cost Of Room
    *returns: Double
  **/
	public double getRoomCost( ) { return roomCost; }
	
	/**
   	*Returns is there a sofa in a LivingRoom
    *returns: boolean
  **/
	public boolean isSofa() {
		return sofa;
	}
	/**
   	*Returns is there a television in a LivingRoom
    *returns: boolean
  **/
	public boolean isTelevision()
	{
		return television;
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
   	*Sets the value(true or false) of a sofa
    *@param sofa: boolean
    *returns: void
  **/
	public void setSofa(boolean sofa) {
		this.sofa = sofa;
	}
	/**
   	*Sets the value(true or false) of a television
    *@param television: boolean
    *returns: void
  **/
	public void setTelevision(boolean television) {
		this.television = television;
	}
	
	/**
   	*Returns the total cost of a LivingRoom
    *returns: Double
  **/
	public double getTotalCost()
	{
		double totalCost = 0;
		if(this.sofa == true)
		{
			totalCost += 50;
		}
		if(this.television == true)
		{
			totalCost += 100;
		}
		
		return totalCost;
	}

	@Override
	/**
   	*Returns a string representation of a LivingRoom
    *returns: String
  **/
	public String toString() {
		return "LivingRoom [roomCost=" + roomCost + ", sofa=" + sofa + ", television=" + television + "]";
	}
	
	
}
