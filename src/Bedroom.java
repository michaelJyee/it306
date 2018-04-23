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
	public static final double MIN_COST = 200;
	public static final double MAX_COST = 300;
	private double roomCost;
	private boolean matress;
	private boolean nightstand;
	private boolean pillow;
	
	public Bedroom() {
		super();
	}

	public double getRoomCost( ) { return roomCost; }
	
	public boolean isMatress() {
		return matress;
	}

	public boolean isNightstand() {
		return nightstand;
	}

	public boolean isPillow() {
		return pillow;
	}
	
	public void setRoomCost(double roomCost ) {
		if (roomCost < MIN_COST || roomCost > MAX_COST) {
			throw new IllegalArgumentException("Room cost must be between " + MIN_COST + " and " + MAX_COST);
		}
		this.roomCost = roomCost;
	}

	public void setMatress(boolean matress) {
		this.matress = matress;
	}

	public void setNightstand(boolean nightstand) {
		this.nightstand = nightstand;
	}

	public void setPillow(boolean pillow) {
		this.pillow = pillow;
	}

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
	public String toString() {
		return "Bedroom [roomCost=" + roomCost + ", matress=" + matress + ", nightstand=" + nightstand + ", pillow="
				+ pillow + "]";
	}
	
	
}
