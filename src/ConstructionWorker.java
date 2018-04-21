
public class ConstructionWorker<e> extends Employee<e> {
	public static final double MIN_SALARY = 0;
	public static final double MAX_SALARY = 1000;
	private double salary;
	
	public ConstructionWorker() {
		super();
	}

	public double getSalary() { return salary; }
	
	public void setSalary(double salary) {
		if (salary < MIN_SALARY || salary > MAX_SALARY) {
			throw new IllegalArgumentException("Salary must be between " + MIN_SALARY + " and " + MAX_SALARY);
		}
		this.salary = salary;
	}
	
	public String toString()
	{
		String out ="";
		out += "Employee Type: Construction Worker\n" + super.toString() + "Employee Salary:" + getSalary() + "\n";
		return out;
	}
}
