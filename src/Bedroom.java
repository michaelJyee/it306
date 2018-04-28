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
public class Bedroom extends Room{
	//Declare Constants for min and max cost
	public static final double MIN_COST = 200;
	public static final double MAX_COST = 300;
	//Declare the instance variables
	private double roomCost;
	private boolean matress;
	private boolean nightstand;
	private boolean pillow;
	
	//Constructor
	public Bedroom() {
		super();
	}

	/**
   	*Returns cost Of Room
    *returns: Double
  **/
	public double getRoomCost( ) { return roomCost; }
	
	/**
   	*Returns is there a matress in a Bedroom
    *returns: boolean
  **/
	public boolean isMatress() {
		return matress;
	}
	/**
   	*Returns is there a nightstand in a Bedroom
    *returns: boolean
  **/
	public boolean isNightstand() {
		return nightstand;
	}
	/**
   	*Returns is there a pillow in a Bedroom
    *returns: boolean
  **/
	public boolean isPillow() {
		return pillow;
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
   	*Sets the value(true or false) of a matress
    *@param matress: boolean
    *returns: void
  **/
	public void setMatress(boolean matress) {
		this.matress = matress;
	}
	/**
   	*Sets the value(true or false) of a nightstand
    *@param nightstand: boolean
    *returns: void
  **/
	public void setNightstand(boolean nightstand) {
		this.nightstand = nightstand;
	}
	/**
   	*Sets the value(true or false) of a pillow
    *@param pillow: boolean
    *returns: void
  **/
	public void setPillow(boolean pillow) {
		this.pillow = pillow;
	}

	/**
   	*Returns the total cost of a bedroom
    *returns: Double
  **/
	public double getTotalCost()
	{
		double totalCost = 0;
		if(this.matress == true)
		{
			totalCost += 50;
		}
		if(this.nightstand == true)
		{
			totalCost += 150;
		}
		if(this.pillow == true)
		{
			totalCost += 30;
		}
		
		return totalCost;
	}

	@Override
	/**
   	*Returns a string representation of a Bedroom
    *returns: String
  **/
	public String toString() {
		return "Bedroom [roomCost=" + roomCost + ", matress=" + matress + ", nightstand=" + nightstand + ", pillow="
				+ pillow + "]";
	}
	
	
}
