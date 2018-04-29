package BuildingConstructionReporter;
/*
 * @author Michael Yee
 * @author Albert Wei
 * @author Thu Tran
 * 
 * IT 306 - 001
 *
 * This is the data definition class for Manager.
 * It will store the specific information for Manager type of employee.
 * such as salary.
 * This class will also have a toString() method to output the Manager information.
 * */

public class Manager extends Employee {
	//Declare Constants for min and max salary
	public static final double MIN_SALARY = 0;
	public static final double MAX_SALARY = 2000;
	//Declare the instance variable
	private double salary;
	
	//Constructor
	public Manager() {
		super();
	}
	/**
   	*Returns Salary Of Manager
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
   	*Returns a string representation of a Manager
    *returns: String
  **/
	public String toString()
	{
		String out ="";
		out += "Employee Type: Manager\n" + super.toString()+ "Employee Salary:" + getSalary() + "\n";
		return out;
	}
}
