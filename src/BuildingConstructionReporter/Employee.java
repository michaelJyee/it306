package BuildingConstructionReporter;
/*
 * @author Michael Yee
 * @author Albert Wei
 * @author Thu Tran
 * 
 * IT 306 - 001
 *
 * This is the data definition class for Employee.
 * It will store the common information for every type of Employee.
 * such as first and last name, employee id, and age.
 * This class will also have a toString() method to output the Employee information.
 * */

public abstract class Employee {
	
	//Declare Constant for min age
	public static final double MIN_AGE = 0;
	//Declare the instance variables
	private String firstName;
	private String lastName;
	private int employeeId;
	private int age;
	private static int numOfEmployees = 0;
	
	//Constructor
	public Employee() {
		numOfEmployees++;
    this.setId(numOfEmployees);
	}
	
	/**
   	*Returns the first name Of Employee
    *returns: String
  **/
	public String getFirstName() { return firstName; }
	/**
   	*Returns the last name of Employee
    *returns: String
  **/
	public String getLastName() { return lastName; }
	
  /**
   	*Returns the id of Employee
    *returns: e
  **/
	public int getId() { return employeeId; }
	/**
   	*Returns the age of Employee
    *returns: Integer
  **/
	public int getAge() { return age; }
	/**
   	*Returns the total number of Employees
    *returns: Integer
  **/
	public int getTotalNumOfEmployees() { return numOfEmployees; }
	
	/**
   	*Sets First Name Validates parameter is not null and blank
    *@param firstName: String
    *returns: void
  **/
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.equals("")) {
			throw new IllegalArgumentException("First Name Cannot be Blank");
		}
		this.firstName = firstName;
	}
	/**
   	*Sets Last Name Validates parameter is not null and blank
    *@param lastName: String
    *returns: void
  **/
	public void setLastName(String lastName) {
		if (lastName == null || lastName.equals("")) {
			throw new IllegalArgumentException("Last Name Cannot be Blank");
		}
		this.lastName = lastName;
	}
	/**
   	*Sets id Validates parameter is not null and blank
    *@param id: int
    *returns: void
  **/
	private void setId(int employeeId) {
		this.employeeId = employeeId;
	}
	/**
   	*Sets age Validates parameter is greater than MIN_AGE
    *@param age: int
    *returns: void
  **/
	public void setAge(int age) {
		if (age <= MIN_AGE) {
			throw new IllegalArgumentException("Age must be greater than MIN_AGE");
		}
		this.age = age;
	}
	
	/**
   	*Returns a string representation of a Employee
    *returns: String
  **/
	public String toString()
	{
		String out ="";
		out += "ID: " +this.getId()+ "\nEmployee Name: " + getFirstName() +" "+ getLastName() + "\n" + 
			   "Employee Age: " + getAge()+ "\n";
		return out;
	}
}
