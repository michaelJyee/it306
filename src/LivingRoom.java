
public class LivingRoom extends Room{
	public static final double MIN_COST = 100;
	public static final double MAX_COST = 200;
	private double roomCost;
	
	public LivingRoom() {
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
