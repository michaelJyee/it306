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

public abstract class Employee<e> {
	private String firstName;
	private String lastName;
	private e employeeId;
	private int age;
	private static int numOfEmployees = 0;
	
	public Employee() {
		numOfEmployees++;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public e getId() { return employeeId; }
	public int getAge() { return age; }
	public int getTotalNumOfEmployees() { return numOfEmployees; }
	
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.equals("")) {
			throw new IllegalArgumentException("First Name Cannot be Blank");
		}
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.equals("")) {
			throw new IllegalArgumentException("Last Name Cannot be Blank");
		}
		this.lastName = lastName;
	}
	public void setId(e employeeId) {
		this.employeeId = employeeId;
	}
	public void setAge(int age) {
		if (age <= 0) {
			throw new IllegalArgumentException("Age must be greater than 0");
		}
		this.age = age;
	}
	
	public String toString()
	{
		String out ="";
		out += "Employee Name: " + getFirstName() + getLastName() + "\n" + 
			   "Employee Age: " + getAge()+ "\n";
		return out;
	}
}
