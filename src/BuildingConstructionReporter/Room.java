package BuildingConstructionReporter;
/*
 * @author Michael Yee
 * @author Albert Wei
 * @author Thu Tran
 * 
 * IT 306 - 001
 *
 * This is the data definition class for Room.
 * It will store the common information for every type of Room.
 * such as room name, room height, and room width.
 * Also it have a static counter to track the the total number of rooms.
 * This class have a toString() method to output the Room information.
 * This class have a abstract getTotalCost() method due to each type of the room has different cost.
 * */

public abstract class Room {
	//Declare Constants for min height and width
	public static final double MIN_HEIGHT = 0;
	public static final double MIN_WIDTH = 0;
	
	//Declare the instance variables
	private String roomName;
	private double roomHeight;
	private double roomWidth;
	private static int totalNumOfRooms = 0;
	
	//Constructor
	public Room() {
		totalNumOfRooms++;
	}
	
	/**
   	*Returns the name Of Room
    *returns: String
  **/
	public String getRoomName() { return roomName; }
	/**
   	*Returns the height Of Room
    *returns: Double
  **/
	public double getRoomHeight( ) { return roomHeight; }
	/**
   	*Returns the width Of Room
    *returns: Double
  **/
	public double getRoomWidth() { return roomWidth; }
	/**
   	*Returns the total numbers Of Room
    *returns: Integer
  **/
	public int getTotalNumOfRooms() { return totalNumOfRooms; }
	
	/**
   	*Sets Room Name Validates parameter is not null and blank
    *@param roomName: String
    *returns: void
  **/
	public void setRoomName(String roomName) {
		if (roomName == null || roomName.equals("")) {
			throw new IllegalArgumentException("Room Name Cannot be Blank");
		}
		this.roomName = roomName;
	}
	/**
   	*Sets Room Height Validates parameter is greater than MIN_HEIGHT
    *@param roomHeight: double
    *returns: void
  **/
	public void setRoomHeight(double roomHeight) {
		if (roomHeight <= MIN_HEIGHT) {
			throw new IllegalArgumentException("Room Height must be greater than 0");
		}
		this.roomHeight = roomHeight;
	}
	/**
   	*Sets Room Width Validates parameter is greater than MIN_WIDTH
    *@param roomWidth: double
    *returns: void
  **/
	public void setRoomWidth(double roomWidth) {
		if (roomWidth <= MIN_WIDTH) {
			throw new IllegalArgumentException("Room Width must be greater than 0");
		}
		this.roomWidth = roomWidth;
	}
	
	//Abstract method 
	public abstract double getTotalCost();
}
