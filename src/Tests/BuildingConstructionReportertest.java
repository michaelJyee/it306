package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import BuildingConstructionReporter.ConstructionWorker;
import BuildingConstructionReporter.Employee;
import BuildingConstructionReporter.Manager;
import BuildingConstructionReporter.Room;
import junit.framework.Assert;

public class BuildingConstructionReportertest {

	ArrayList<Employee> list = new ArrayList<Employee>();
	ArrayList<Room> roomList = null;
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() {
		Employee e1 = new Manager();
		e1.setFirstName("Michael");
		e1.setLastName("Yee");
		e1.setAge(25);
		((Manager) e1).setSalary(500);

		Employee e2 = new ConstructionWorker();
		e2.setFirstName("John");
		e2.setLastName("Smith");
		e2.setAge(30);
		((ConstructionWorker) e2).setSalary(190);
		
		//Custom toString Validation
		Assert.assertTrue(e1.toString().trim().equals("Employee Type: Manager\n" + "Employee Name: MichaelYee\n" + "Employee Age: 25\n" + "Employee Salary:500.0"));
		Assert.assertEquals(e2.toString().trim(),"Employee Type: Construction Worker\n" + "Employee Name: JohnSmith\n" + "Employee Age: 30\n" + "Employee Salary:190.0");
		
		
	}

}
