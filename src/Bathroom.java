
public class Bathroom extends Room{
	public static final double MIN_COST = 400;
	public static final double MAX_COST = 500;
	private double roomCost;
	private boolean bathtub;
	
	public Bathroom() {
		super();
	}
	
	public double getRoomCost( ) { return roomCost; }
	
	public void setRoomCost(double roomCost ) {
		if (roomCost < MIN_COST || roomCost > MAX_COST) {
			throw new IllegalArgumentException("Room cost must be between " + MIN_COST + " and " + MAX_COST);
		}
		this.roomCost = roomCost;
	}
}
