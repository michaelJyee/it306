
public class Bathroom extends Room{
	public static final double MIN_COST = 400;
	public static final double MAX_COST = 500;
	private double roomCost;
	private boolean bathtub;
	private boolean showerCurtain;
	

	
	public Bathroom() {
		super();
	}
	
	public double getRoomCost( ) { return roomCost; }
	
	public boolean isBathtub() {
		return bathtub;
	}

	public boolean isShowerCurtain() {
		return showerCurtain;
	}

	public void setRoomCost(double roomCost ) {
		if (roomCost < MIN_COST || roomCost > MAX_COST) {
			throw new IllegalArgumentException("Room cost must be between " + MIN_COST + " and " + MAX_COST);
		}
		this.roomCost = roomCost;
	}
	public void setBathtub(boolean bathtub) {
		this.bathtub = bathtub;
	}
	
	public void setShowerCurtain(boolean showerCurtain) {
		this.showerCurtain = showerCurtain;
	}
	
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
}
