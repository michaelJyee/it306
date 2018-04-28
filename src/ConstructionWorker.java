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

public class ConstructionWorker<e> extends Employee<e> {
	public static final double MIN_SALARY = 0;
	public static final double MAX_SALARY = 1000;
	private double salary;
	
	public ConstructionWorker() {
		super();
	}

	/**
   	*Returns Salary Of Construction Worker
    *returns: Double
  **/
	public double getSalary() { return salary; }
	

	/**
   	*Sets Salary Validates parameter is within MIN_SALARY AND MAX_SALARY
    *@param salary: double
    *returns: void
  **/
	public void setSalary(double salary) {
		if (salary < MIN_SALARY || salary > MAX_SALARY) {
			throw new IllegalArgumentException("Salary must be between " + MIN_SALARY + " and " + MAX_SALARY);
		}
		this.salary = salary;
	}
	
	/**
   	*Returns String Value Of Construction Worker
    *returns: String
  **/
	public String toString()
	{
		String out ="";
		out += "Employee Type: Construction Worker\n" + super.toString() + "Employee Salary:" + getSalary() + "\n";
		return out;
	}
}
