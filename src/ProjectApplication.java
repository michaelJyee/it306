import javax.swing.JOptionPane;
import java.util.*;


public class ProjectApplication {
	public static void main(String[] args) {
		String buildingName = getBuildingName();
		System.out.println("getBuildingName --> " + buildingName);

		addEmployees();

		//TODO collect eployees


	}

	public static String getBuildingName(){
		String buildingName;
		boolean invalid = true;
		
		do {
			buildingName = JOptionPane.showInputDialog("Enter Building Name");
			if (buildingName == null || buildingName.equals("")) {
				JOptionPane.showMessageDialog(null, "Building Name cannot be blank");
			} else {
				invalid = false;
			}
		} while (invalid);

		return buildingName;
	}


	public static void addEmployees(){
		ArrayList<Employee> list = new ArrayList<Employee>();
		Boolean sent = false;
		String response = "";
		
		do{
			response = JOptionPane.showInputDialog(null, "Would you like to add more employees?");

			if(response == "Y"){
				System.out.println("Y");
				sent = false;
			}
			else{
				System.out.println("F");
				sent = true;
			}

		}while(!sent);

	}

	
	public static int enterNumEmployees() {
		int totalEmployees = 0;
		boolean invalid = true;
		try {
			do {
				totalEmployees = Integer.parseInt(JOptionPane.showInputDialog("Enter Number of Employees: "));
				if (totalEmployees <= 0) {
					JOptionPane.showMessageDialog(null, "Number of Employee must be greater than 0");
				} else {
					invalid = false;
				}
			} while(invalid);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Number of Employee Must be a number");
		}


		return totalEmployees;
	}
	public static void employeeType(Employee<Integer>[] employees,int x) {
		String[] choices = {"Manager","Construction Worker"};
		String input = (String) JOptionPane.showInputDialog(null, "Choose type","Choice type of Employee", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
		switch(input) {
			case "Manager": 
				employees[x] = new Manager<Integer>();
				break;
			case "Construction Worker":
				employees[x] = new ConstructionWorker<Integer>();
				break;
			default: break;
		}
	}
	public static void employeeRate() {
		
	}
	public static void employeeData() {
		
	}
	public static void roomData() {
		
	}
}
