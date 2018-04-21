
public abstract class Room {
	private String roomName;
	private double roomHeight;
	private double roomWidth;
	private static int totalNumOfRooms = 0;
	
	public Room() {
		totalNumOfRooms++;
	}
	
	public String getRoomName() { return roomName; }
	public double getRoomHeight( ) { return roomHeight; }
	public double getRoomWidth() { return roomWidth; }
	public int getTotalNumOfRooms() { return totalNumOfRooms; }
	
	public void setRoomName(String roomName) {
		if (roomName == null || roomName.equals("")) {
			throw new IllegalArgumentException("Room Name Cannot be Blank");
		}
		this.roomName = roomName;
	}
	
	public void setRoomHeight(double roomHeight) {
		if (roomHeight <= 0) {
			throw new IllegalArgumentException("Room Height must be greater than 0");
		}
		this.roomHeight = roomHeight;
	}
	public void setRoomWidth(double roomWidth) {
		if (roomWidth <= 0) {
			throw new IllegalArgumentException("Room Width must be greater than 0");
		}
		this.roomWidth = roomWidth;
	}
	
	public abstract double getTotalCost();
}
