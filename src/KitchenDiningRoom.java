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

import java.util.Arrays;

public class KitchenDiningRoom extends Room{
	//Declare Constants for min and max cost
	public static final double MIN_COST = 100;
	public static final double MAX_COST = 200;
	//Declare the instance variables
	private boolean woodfloors;
	private String[] stoveTypes = new String[]{"electric", "gas"};
	private String stoveType;
	private boolean island;
	private double roomCost;
	
	//Constructor
	public KitchenDiningRoom() {
		super();
	}
	
	/**
   	*Returns cost Of Room
    *returns: Double
  **/
	public double getRoomCost( ) { return roomCost; }
	/**
   	*Returns is there a wood floor in a KitchenDiningRoom
    *returns: boolean
  **/
	public boolean isWoodfloors() {
		return woodfloors;
	}
	/**
   	*Returns all the stove types in a KitchenDiningRoom
    *returns: String[]
  **/
	public String[] getStoveTypes() {
		return stoveTypes;
	}
	/**
   	*Returns the stove type in a KitchenDiningRoom
    *returns: String
  **/
	public String getStoveType() {
		return stoveType;
	}
	/**
   	*Returns is there a island in a KitchenDiningRoom
    *returns: boolean
  **/
	public boolean isIsland() {
		return island;
	}

	
	/**
   	*Sets the value(true or false) of a woodfloor
    *@param woodfloors: boolean
    *returns: void
  **/
	public void setWoodfloors(boolean woodfloors) {
		this.woodfloors = woodfloors;
	}
	/**
   	*Sets the values of all stovetypes
    *@param stoveTypes: String[]
    *returns: void
  **/
	public void setStoveTypes(String[] stoveTypes) {
		this.stoveTypes = stoveTypes;
	}
	
	/**
   	*Sets the values of one stovetype
    *@param stoveTypes: String
    *returns: void
  **/
	public void setStoveType(String stoveType) {
		this.stoveType = stoveType;
	}
	/**
   	*Sets the value(true or false) of a island
    *@param island: boolean
    *returns: void
  **/
	public void setIsland(boolean island) {
		this.island = island;
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
   	*Returns the total cost of a KitchenDiningRoom
    *returns: Double
  **/
	public double getTotalCost()
	{
		double totalCost = 0;
		if(this.woodfloors == true)
		{
			totalCost += 50;
		}
		if(stoveType.equals(stoveTypes[0]))
		{
			totalCost += 200;
		}
		else
		{
			totalCost += 150;
		}
		if(this.island == true)
		{
			totalCost += 100;
		}
		
		return totalCost;
	}

	@Override
	/**
   	*Returns a string representation of a KitchenDiningRoom
    *returns: String
  **/
	public String toString() {
		return "KitchenDiningRoom [woodfloors=" + woodfloors + ", stoveTypes=" + Arrays.toString(stoveTypes)
				+ ", stoveType=" + stoveType + ", island=" + island + ", roomCost=" + roomCost + "]";
	}
	
	
}
