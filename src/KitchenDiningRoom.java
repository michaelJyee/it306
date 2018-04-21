import java.util.Arrays;

public class KitchenDiningRoom extends Room{
	public static final double MIN_COST = 100;
	public static final double MAX_COST = 200;
	private boolean woodfloors;
	private String[] stoveTypes = new String[]{"electric", "gas"};
	private String stoveType;
	private boolean island;
	private double roomCost;
	
	public KitchenDiningRoom() {
		super();
	}
	
	public boolean isWoodfloors() {
		return woodfloors;
	}

	public String[] getStoveTypes() {
		return stoveTypes;
	}
	
	public String getStoveType() {
		return stoveType;
	}

	public boolean isIsland() {
		return island;
	}

	public double getRoomCost( ) { return roomCost; }
	

	public void setWoodfloors(boolean woodfloors) {
		this.woodfloors = woodfloors;
	}

	public void setStoveTypes(String[] stoveTypes) {
		this.stoveTypes = stoveTypes;
	}
	

	public void setStoveType(String stoveType) {
		this.stoveType = stoveType;
	}

	public void setIsland(boolean island) {
		this.island = island;
	}

	public void setRoomCost(double roomCost ) {
		if (roomCost < MIN_COST || roomCost > MAX_COST) {
			throw new IllegalArgumentException("Room cost must be between " + MIN_COST + " and " + MAX_COST);
		}
		this.roomCost = roomCost;
	}
	
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
	public String toString() {
		return "KitchenDiningRoom [woodfloors=" + woodfloors + ", stoveTypes=" + Arrays.toString(stoveTypes)
				+ ", stoveType=" + stoveType + ", island=" + island + ", roomCost=" + roomCost + "]";
	}
	
	
}
