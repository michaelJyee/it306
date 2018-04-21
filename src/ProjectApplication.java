import javax.swing.JOptionPane;
import java.util.*;


public class ProjectApplication {
	public static void main(String[] args) {
		String buildingName = getBuildingName();
		System.out.println("getBuildingName --> " + buildingName);

		ArrayList<Employee> list = new ArrayList<Employee>();
		
		addEmployees(list);
		 printEmployeeReport(list);

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


	public static void addEmployees(ArrayList<Employee> list){
		//ArrayList<Employee> list = new ArrayList<Employee>();
		
		String prompt = "Would you like to add more employees?";
		String firstName ="Enter the First Name: ";
		String LastName ="Enter the Last Name: ";
		String age = "Enter the age: ";
		String salary = "Enter salary: ";
		
		String employeetype ="Which type of employee you would like to enter?/n manager/construction worker";
		
		
		do{
				String[] choices = {"Manager","Construction Worker"};
				String type = (String) JOptionPane.showInputDialog(null, "Choose employee type","Choice type of Employee", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);
				//String type1 = JOptionPane.showInputDialog(employeetype);
				//String type2 = JOptionPane.showInputDialog(employeetype);
				if(type.equals("Manager"))
				{
					Employee e1 = new Manager();
					if(e1 instanceof Manager)
					{
						System.out.println("Manager");
						e1.setFirstName(JOptionPane.showInputDialog(firstName));
						e1.setLastName(JOptionPane.showInputDialog(LastName));
						e1.setAge(Integer.parseInt(JOptionPane.showInputDialog(age)));
						((Manager) e1).setSalary(Double.parseDouble(JOptionPane.showInputDialog(salary)));
						
						JOptionPane.showMessageDialog(null, e1.toString()); 
						
						list.add(e1);
					}
				}
				else
				{
					Employee e2 = new ConstructionWorker();
					if(e2 instanceof ConstructionWorker)
					{
						System.out.println("Constuct Worker");
						e2.setFirstName(JOptionPane.showInputDialog(firstName));
						e2.setLastName(JOptionPane.showInputDialog(LastName));
						e2.setAge(Integer.parseInt(JOptionPane.showInputDialog(age)));
						((ConstructionWorker) e2).setSalary(Double.parseDouble(JOptionPane.showInputDialog(salary)));
						
						list.add(e2);
					}
				}
		}while(JOptionPane.showConfirmDialog(null,prompt, "Add Another employee?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		
	}

	public static double getTotalSalaries(ArrayList<Employee> list)
	{
		double totalSalary = 0;
		
		for(int i=0; i < list.size(); i++)
		{ 
			if(list.get(i) instanceof Manager)
			{
				totalSalary += ((Manager) list.get(i)).getSalary();
			}
			else
			{
				totalSalary += ((ConstructionWorker) list.get(i)).getSalary();
			}
		}
		return totalSalary;
		
	}
	
	public static void printEmployeeReport(ArrayList<Employee> list)
	{
		String out ="Employees Report\n";
		
		for(int i=0; i < list.size(); i++)
		{
			if(list.get(i) instanceof Manager)
			{
				out += ((Manager) list.get(i)).toString()+"\n";
			}
			else
			{
				out += ((ConstructionWorker) list.get(i)).toString()+"\n";
			}
		}
		
		out+= "Employees Total Salaries: " + getTotalSalaries(list);
		
		JOptionPane.showMessageDialog(null, out);
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
