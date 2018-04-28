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

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class ProjectApplication {
	public static final String[] ROOM_TYPES = {"Kitchen","Bathroom","LivingRoom","BedRoom"};

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		ArrayList<Room> roomList = null;
		
		//Ask for building name
		String buildingName = getBuildingName();

		String menu = "1- Add Employee \n2-Select Room File \n3-Print dependencies \n4-Exit";
		while(true){
			int option =-1;
			boolean flag= true;
			do{
				try{
					option =Integer.parseInt(JOptionPane.showInputDialog(menu));
					flag= true;
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid input.");
					flag = false;
				}
			}while(!flag);
			
			switch(option){
				case 1:
					System.out.println("Add Employee");
					list.add(addEmployee());
					break;
				case 2:
					System.out.println("Select Room File");
					try {
						//Read room data from text file
						JOptionPane.showMessageDialog(null, "Please select a room data file: (rooms.txt)");
					 	roomList = readRooms();
					 } catch (IOException e) {
					 	// TODO Auto-generated catch block
					 	e.printStackTrace();
					 }
					break;
				case 3:
					System.out.println("Print Everything");
					double finalTotalCost = 0;
					finalTotalCost = getRoomTotalCost(roomList) + getTotalSalaries(list);
					String reciept = "Total Housing Cost Reciept**********\n";
					reciept += "Building Name: " + buildingName+"\n";
					reciept += printRoomReport(roomList)+"\n";
					reciept += printEmployeeReport(list)+"\n";
					reciept += "Final Total Cost (including rooms and employees cost): " + finalTotalCost;

					try {
						writeData(reciept);
						JOptionPane.showMessageDialog(null, "Receipt has been printed!");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 4:
					System.exit(0);
			}
		}

	}


	/**
	  *Reads a file of room and outputs and Arraylist of Room objects
	  *returns: Arraylist of Room Objects
	**/
	public static ArrayList<Room> readRooms() throws IOException{
		//Select File Path
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);

	  File file = chooser.getSelectedFile();
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  ArrayList<Room> list = new ArrayList<Room>();

	  String st = "";

	  while ((st = br.readLine()) != null) {
			list.add(lineToRoom(st));
	  }

	  return list;
	}

	public static Room lineToRoom(String data){
		String[] line = data.split(",");
		Room rm = null;

		//Determine Type
		if(line[0].trim().equals(ROOM_TYPES[0].trim())){
			rm = new KitchenDiningRoom();
		}
		else if(line[0].trim().equals(ROOM_TYPES[1].trim())){
			rm = new Bathroom();
		}
		else if(line[0].trim().equals(ROOM_TYPES[2].trim())){
			rm = new LivingRoom();
		}
		else if(line[0].trim().equals(ROOM_TYPES[3].trim())){
			rm = new Bedroom();
		}
		
		//Set Height/Width
		if(rm != null) {
			rm.setRoomName(line[1]);
			rm.setRoomHeight(Double.parseDouble(line[2]));
			rm.setRoomWidth(Double.parseDouble(line[3]));
		}

		if(rm instanceof KitchenDiningRoom){
			((KitchenDiningRoom) rm).setWoodfloors( Boolean.parseBoolean(line[4]) );
			((KitchenDiningRoom) rm).setIsland((Boolean.parseBoolean(line[5])));
			((KitchenDiningRoom) rm).setStoveType(line[6]);
		}
		else if(rm instanceof Bathroom){
			((Bathroom) rm).setBathtub(Boolean.parseBoolean(line[4]));
			((Bathroom) rm).setShowerCurtain((Boolean.parseBoolean(line[5])));
		}
		else if(rm instanceof LivingRoom){
			((LivingRoom) rm).setSofa(Boolean.parseBoolean(line[4]));
			((LivingRoom) rm).setTelevision(Boolean.parseBoolean(line[5]));
		}
		else if(rm instanceof Bedroom){
			((Bedroom) rm).setMatress( Boolean.parseBoolean(line[4]));
			((Bedroom) rm).setNightstand( Boolean.parseBoolean(line[5]));
			((Bedroom) rm).setPillow( Boolean.parseBoolean(line[6]));
		}
		
		return rm;
	}

	public static double getRoomTotalCost(ArrayList<Room> list){
		if(list == null) return 0;
		double totalSalary = 0;
		for(int i=0; i < list.size(); i++)
		{
			totalSalary += list.get(i).getTotalCost();
		}

		return totalSalary;
	}
	
	public static String printRoomReport(ArrayList<Room> list){
		String str = "\nRoom Report******\n";
		if(list == null){
			str += "No Room Data Selected\n";
			str += "Rooms Total Cost: 0.0$\n";
			return str;
		}

		for(int i = 0; i < list.size(); i++){
			str += list.get(i).getRoomName() + " COST: " + list.get(i).getTotalCost()+"\n";
		}

		str+= "Rooms Total Cost: " + getRoomTotalCost(list) +"\n\n";
		
		return str;
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


	public static Employee addEmployee(){
		String prompt = "Would you like to add more employees?";
		String firstName ="Enter the First Name: ";
		String LastName ="Enter the Last Name: ";
		String age = "Enter the age: ";
		String salary = "Enter salary: ";

		String[] choices = {"Manager","Construction Worker"};
		String type = (String) JOptionPane.showInputDialog(null, "Choose employee type","Choice type of Employee", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);

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
				
				return e1;
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
				
				return e2;
			}
		}

		return null;
	}


	// public static void addEmployees(ArrayList<Employee> list){
	// 	//ArrayList<Employee> list = new ArrayList<Employee>();
		
	// 	String prompt = "Would you like to add more employees?";
	// 	String firstName ="Enter the First Name: ";
	// 	String LastName ="Enter the Last Name: ";
	// 	String age = "Enter the age: ";
	// 	String salary = "Enter salary: ";
		
	// 	String employeetype ="Which type of employee you would like to enter?/n manager/construction worker";
		
		
	// 	do{
	// 			String[] choices = {"Manager","Construction Worker"};
	// 			String type = (String) JOptionPane.showInputDialog(null, "Choose employee type","Choice type of Employee", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);

	// 			if(type.equals("Manager"))
	// 			{
	// 				Employee e1 = new Manager();
	// 				if(e1 instanceof Manager)
	// 				{
	// 					System.out.println("Manager");
	// 					e1.setFirstName(JOptionPane.showInputDialog(firstName));
	// 					e1.setLastName(JOptionPane.showInputDialog(LastName));
	// 					e1.setAge(Integer.parseInt(JOptionPane.showInputDialog(age)));
	// 					((Manager) e1).setSalary(Double.parseDouble(JOptionPane.showInputDialog(salary)));
						
	// 					JOptionPane.showMessageDialog(null, e1.toString()); 
						
	// 					list.add(e1);
	// 				}
	// 			}
	// 			else
	// 			{
	// 				Employee e2 = new ConstructionWorker();
	// 				if(e2 instanceof ConstructionWorker)
	// 				{
	// 					System.out.println("Constuct Worker");
	// 					e2.setFirstName(JOptionPane.showInputDialog(firstName));
	// 					e2.setLastName(JOptionPane.showInputDialog(LastName));
	// 					e2.setAge(Integer.parseInt(JOptionPane.showInputDialog(age)));
	// 					((ConstructionWorker) e2).setSalary(Double.parseDouble(JOptionPane.showInputDialog(salary)));
						
	// 					list.add(e2);
	// 				}
	// 			}
	// 	}while(JOptionPane.showConfirmDialog(null,prompt, "Add Another employee?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
		
	// }

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
	
	public static String printEmployeeReport(ArrayList<Employee> list)
	{
		String out ="Employees Report******\n";
		
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
		
		return out;
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

	public static void writeData(String data) throws FileNotFoundException{
		try (PrintWriter out = new PrintWriter("Receipt.txt")) {
		  out.println(data);
		}
	}
}
