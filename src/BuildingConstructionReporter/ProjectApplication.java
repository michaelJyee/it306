package BuildingConstructionReporter;
/*
 * @author Michael Yee
 * @author Albert Wei
 * @author Thu Tran
 * IT 306 - 001
 * The purpose of this system is to determine the total cost to build a house.
 * It will ask the user to input employees' information based on their type(manager, construction worker)and calculate the total cost.
 * such as employee's first and last name, age and salary.
 * It will ask the user to import a text file that contains room data and calculate the total cost.
 * Upon system termination, the program will output a text file that contains all the information regarding employees and room with the final total cost.
 * File output name is: "Receipt.txt"
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
		LinkedList<Employee> list = new LinkedList<Employee>();
		LinkedList<Room> roomList = null;
		
		//Ask for building name
		String buildingName = getBuildingName();

		//Get Name of building
		String menu = "Project<"+buildingName+">\n1- Add Employee \n2-Select Room File \n3-Print Final Report \n4-Exit";
		while(true){
			int option =-1;
			boolean flag= true;
			do{
				try{
					option =Integer.parseInt(JOptionPane.showInputDialog(menu));
					flag= true;
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter a building name.");
					flag = false;
				}
			}while(!flag);

			switch(option){
				case 1:
				
					try{
						Employee e1 = addEmployee();
						if(e1 != null) list.add(e1);
					}catch(NullPointerException e){
						System.out.println(e);
					}

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
					try {
						writeData(buildingName,roomList,list);
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
	  *Reads a file of room and outputs and LinkedList of Room objects
	  *returns: LinkedList of Room Objects
	**/
	public static LinkedList<Room> readRooms() throws IOException{
		//Select File Path
		JFileChooser chooser = new JFileChooser();
		chooser.showOpenDialog(null);

	  File file = chooser.getSelectedFile();
	  BufferedReader br = new BufferedReader(new FileReader(file));
	  LinkedList<Room> list = new LinkedList<Room>();

	  String st = "";

	  while ((st = br.readLine()) != null) {
			list.add(lineToRoom(st));
	  }
	  return list;
	}

	/**
	  *Parses A String and returns Room Object
	  *returns: Room Object
	**/
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

	 /**
   	*Calculates the all the rooms totals costs
    *@param list: LinkedList of Room objects
    *returns: Double
  **/
	public static double getRoomTotalCost(LinkedList<Room> list){
		if(list == null) return 0;
		double totalSalary = 0;
		for(int i=0; i < list.size(); i++)
		{
			totalSalary += list.get(i).getTotalCost();
		}

		return totalSalary;
	}
	
	/**
   	*Creates a report for room costs
    *@param list: LinkedList of Room objects
    *returns: String
  **/
	public static String printRoomReport(LinkedList<Room> list){
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

	/**
   	*gets the building name from user via JOP
    *returns: String
  **/
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

	/**
   	*creates Employee Object from User via JOP
    *returns: Employee Object
  **/
	public static Employee addEmployee(){
		String prompt = "Choose employee type";
		String firstName ="Enter the First Name: ";
		String LastName ="Enter the Last Name: ";
		String age = "Enter the age: ";
		String salary = "Enter salary: ";

		String[] choices = {"Manager","Construction Worker"};
		
		String type;
		type = (String) JOptionPane.showInputDialog(null, prompt,"Choice type of Employee", JOptionPane.QUESTION_MESSAGE, null, choices,choices[0]);

		if(type == null){
			throw new NullPointerException("Parameter Type cannot be null");
		}
		else if(type.equals("Manager")){
			Employee e1 = new Manager();
			if(e1 instanceof Manager){
				System.out.println("Manager");
				boolean validFirst = false;
				do{
					try{
						e1.setFirstName(JOptionPane.showInputDialog(firstName));
						validFirst = true;
					}
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Manager cannot be added!\n" + e.getMessage());}
				}while(!validFirst);
				
				boolean validLast = false;
				do{
					try{
						e1.setLastName(JOptionPane.showInputDialog(LastName));
						validLast = true;
					}
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Manager cannot be added!\n" + e.getMessage());}
				}while(!validLast);
				
				boolean validAge = false;
				do{
					try{
						e1.setAge(Integer.parseInt(JOptionPane.showInputDialog(age)));
						validAge = true;
					}
		            catch(NumberFormatException e) {
	                     JOptionPane.showMessageDialog(null, "Only enter numbers!");
	            }
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Manager cannot be added!\n" + e.getMessage());}
				}while(!validAge);
				
				boolean validSalary = false;
				do{
					try{
						((Manager) e1).setSalary(Double.parseDouble(JOptionPane.showInputDialog(salary)));
						validSalary = true;
					}
		            catch(NumberFormatException e) {
		                     JOptionPane.showMessageDialog(null, "Only enter numbers!");
		            }
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Manager cannot be added!\n" + e.getMessage());}
				}while(!validSalary);
				
				
				JOptionPane.showMessageDialog(null, e1.toString()); 
				return e1;
			}
		}
		else{
			Employee e2 = new ConstructionWorker();
			if(e2 instanceof ConstructionWorker){
				System.out.println("Constuction Worker");
				boolean validFirst = false;
				do{
					try{
						e2.setFirstName(JOptionPane.showInputDialog(firstName));
						validFirst = true;
					}
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Construction Worker cannot be added!\n" + e.getMessage());}
				}while(!validFirst);
				
				boolean validLast = false;
				do{
					try{
						e2.setLastName(JOptionPane.showInputDialog(LastName));
						validLast = true;
					}
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Construction Worker cannot be added!\n" + e.getMessage());}
				}while(!validLast);
				
				boolean validAge = false;
				do{
					try{
						e2.setAge(Integer.parseInt(JOptionPane.showInputDialog(age)));
						validAge = true;
					}
		            catch(NumberFormatException e) {
	                     JOptionPane.showMessageDialog(null, "Only enter numbers!");
	            }
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Construction Worker cannot be added!\n" + e.getMessage());}
				}while(!validAge);
				
				boolean validSalary = false;
				do{
					try{
						((ConstructionWorker) e2).setSalary(Double.parseDouble(JOptionPane.showInputDialog(salary)));
						validSalary = true;
					}
		            catch(NumberFormatException e) {
		                     JOptionPane.showMessageDialog(null, "Only enter numbers!");
		            }
					catch(IllegalArgumentException e)
					{JOptionPane.showMessageDialog(null,"Construction Worker cannot be added!\n" + e.getMessage());}
				}while(!validSalary);
				
				JOptionPane.showMessageDialog(null, e2.toString()); 
				return e2;
			}
		}

		System.out.println("NULL");
		return null;
	}


	/**
   	*Calculates the all the Employees totals costs
   	*@param list: LinkedList of Employee objects
    *returns: Double
  **/
	public static double getTotalSalaries(LinkedList<Employee> list)
	{
		double totalSalary = 0;
		
		for(int i=0; i < list.size(); i++){ 
			if(list.get(i) instanceof Manager) totalSalary += ((Manager) list.get(i)).getSalary();
			else totalSalary += ((ConstructionWorker) list.get(i)).getSalary();
		}
		return totalSalary;
		
	}
	
	/**
   	*Creates a report for Employee costs
    *@param list: LinkedList of Employee objects
    *returns: String
  **/
	public static String printEmployeeReport(LinkedList<Employee> list){
		String out ="Employees Report******\n";

		for(int i=0; i < list.size(); i++){
			if(list.get(i) instanceof Manager){
				out += ((Manager) list.get(i)).toString()+"\n";
			}
			else{
				out += ((ConstructionWorker) list.get(i)).toString()+"\n";
			}
		}
		out+= "Employees Total Salaries: " + getTotalSalaries(list);
		return out;
	}
	
	/**
   	*
    *@param list: LinkedList of Employee objects
    *returns: String
  **/
	public static void writeData(String buildingName,LinkedList<Room> roomList, LinkedList<Employee> list) throws FileNotFoundException{
		double finalTotalCost = 0;
		finalTotalCost = getRoomTotalCost(roomList) + getTotalSalaries(list);
		String reciept = "Total Housing Cost Reciept**********\n";
		reciept += "Building Name: " + buildingName+"\n";
		reciept += printRoomReport(roomList)+"\n";
		reciept += printEmployeeReport(list)+"\n";
		reciept += "Final Total Cost (including rooms and employees cost): " + finalTotalCost;

		try (PrintWriter out = new PrintWriter("Receipt.txt")) {
		  out.println(reciept);
		}
	}
}
