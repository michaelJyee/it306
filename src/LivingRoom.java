
public class LivingRoom extends Room{
	public static final double MIN_COST = 100;
	public static final double MAX_COST = 200;
	private double roomCost;
	private boolean sofa;
	private boolean television;
	
	public LivingRoom() {
		super();
	}
	
	public double getRoomCost( ) { return roomCost; }
	
	public boolean isSofa() {
		return sofa;
	}
	
	public boolean isTelevision()
	{
		return television;
	}

	public void setRoomCost(double roomCost ) {
		if (roomCost < MIN_COST || roomCost > MAX_COST) {
			throw new IllegalArgumentException("Room cost must be between " + MIN_COST + " and " + MAX_COST);
		}
		this.roomCost = roomCost;
	}
	
	public void setSofa(boolean sofa) {
		this.sofa = sofa;
	}
	public void setTelevision(boolean television) {
		this.television = television;
	}
	
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
	public String toString() {
		return "LivingRoom [roomCost=" + roomCost + ", sofa=" + sofa + ", television=" + television + "]";
	}
	
	
}
