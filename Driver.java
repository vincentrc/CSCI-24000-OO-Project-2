/*Honor Pledge: I pledge that I have neither given
nor received any help on this assignment**/

import java.io.*;
import java.util.*;
import java.lang.*;

public class Driver 
{
	public static void main(String [] args)
	{
		//Declarations
		String line;
		String choice1, choice2;
		int ordercheck = 0, counter = 0, hours=0;
		int x, y, rateint;
		float paycheck;
		Scanner sc = new Scanner(System.in);
		Employee[] list = new Employee[6];
		
		//Declaring classes for each employee type
		Employee PM, P, T, ST;
	
		
		
		//Resets the screen to look neater
		System.out.print("\033[H\033[2J");
		System.out.flush();
		
		
		//Loop for first menu
		while(true)
		{
			//Main menu display
			System.out.print("\n1. Load Employees (Frome File)\n"
					+ "2. Exit Program\nEnter Your Selection: ");
			
			choice1 = sc.nextLine();
			
			//Logic for choice 1 (most of the program)
			if(choice1.equals("1"))
			{
				
				try
				{
					//Opens stream to file, reader and buffered reader
					InputStream in = new FileInputStream("employees.txt");
					InputStreamReader reader = new InputStreamReader(in);
					BufferedReader buffreader = new BufferedReader(reader);
					
					//Skips the first line of the text file
					line = buffreader.readLine();
					line = buffreader.readLine();
					
					
					while(line != null)
					{
						//Declares a splitter for line splitting by commas
						String[] splitter = line.split(",");
						
						//Logic for Pharmacy Manager
						if(splitter[0].equals("1"))
						{
							//Creates a new instance of PharmacyManager with Employee reference 
							PM = new PharmacyManager();
							
							//Enters information into class
							PM.setID(splitter[1]);
							PM.setfirstname(splitter[2]);
							PM.setlastname(splitter[3]);
							
							//Stores in the array 
							list[counter] = PM;
						}
						
						//Logic for Pharmacist
						else if(splitter[0].equals("2"))
						{
							//Creates a new instance of Pharmacist with Employee reference 
							P = new Pharmacist();
							
							//Enters information into class
							P.setID(splitter[1]);
							P.setfirstname(splitter[2]);
							P.setlastname(splitter[3]);
							
							//Stores in the array 
							list[counter] = P;
						}
						
						//Log for Technician
						else if(splitter[0].equals("3"))
						{
							//Creates a new instance of Technician with Employee reference 
							T = new Technician();
							
							//Enters information into class
							T.setID(splitter[1]);
							T.setfirstname(splitter[2]);
							T.setlastname(splitter[3]);
							
							//Stores in the array 
							list[counter] = T;
						}
						
						//Logic for Senior Technician
						else if(splitter[0].equals("4"))
						{
							//Creates a new instance of Senior Technician with Employee reference
							ST = new SeniorTechnician();
							
							//Enters information into class
							ST.setID(splitter[1]);
							ST.setfirstname(splitter[2]);
							ST.setlastname(splitter[3]);
							
							//Stores in the array 
							list[counter] = ST;
						}
						
						
						//Increments counter and line
						counter++;
						line = buffreader.readLine();
					}
					
					//Closes stream
					buffreader.close();
					
				}
				catch(IOException ex)
				{
					//Resets the screen to look neater
					System.out.print("\033[H\033[2J");
					System.out.flush();
					
					System.err.println(ex);
					System.out.println("\nExiting Program...\n\n");
					sc.close();
					System.exit(0);
				}
				
				//Resets the screen to look neater
				System.out.print("\033[H\033[2J");
				System.out.flush();
				System.out.println("Loaded!");

	
				//Loop for second menu
				while(true)
				{
					//Main menu display
					System.out.print("\n1. Print Employee Information"
							+ "\n2. Enter Hours Worked"
							+ "\n3. Calculate Paychecks"
							+ "\n4. Exit Program"
							+ "\nEnter Your Selection: "); 	
					
					choice2 = sc.nextLine();
					
					//Logic for choice 1
					if(choice2.equals("1"))
					{
						//Resets the screen to look neater
						System.out.print("\033[H\033[2J");
						System.out.flush();
						
						
						//This will loop through the array and print for each element
						for(x=counter-1;x>=0;x--)
						{
							
							System.out.format("ID: %8s   Name: %-15s   Rate:"
									+ " %2s\n", list[x].getID(), list[x].getfirstname()
									+ " " + list[x].getlastname(), list[x].getrate());
						}
					}
					
					//Logic for choice 2
					else if(choice2.equals("2"))
					{
						//Resets the screen to look neater
						System.out.print("\033[H\033[2J");
						System.out.flush();
						
						System.out.print("Please enter the hours worked: ");
						
						try
						{
							hours = sc.nextInt();
							sc.nextLine();
							
						}
						
						//In case a non integer is entered
						catch(Exception e)
						{
							//Resets the screen to look neater
							System.out.print("\033[H\033[2J");
							System.out.flush();
							
							System.err.println(e);
							System.out.println("\nExiting Program...\n\n");
							sc.close();
							System.exit(0);
						}
						
						//Used to make sure hours worked is entered before pay is calculated
						ordercheck = 1;
						
						//Resets the screen to look neater
						System.out.print("\033[H\033[2J");
						System.out.flush();
					}
					
					//Logic for choice 3
					else if(choice2.equals("3"))
					{
						
						//Resets the screen to look neater
						System.out.print("\033[H\033[2J");
						System.out.flush();
						
						//If hours worked was entered
						if(ordercheck == 1)
						{
							//Prints check amount for every employee
							for(y=counter-1;y>=0;y--)
							{
								//Puts rate in integer form
								rateint = Integer.parseInt(list[y].getrate());
								
								paycheck = rateint*hours;
								
								System.out.format("ID: %8s   Check Amount: %-8.1f\n",
								list[y].getID(), paycheck);
							}
						}
						
						//If hours worked was not entered
						else
						{
							System.out.println("Please enter hours worked first!");
						}
						
					}
					
					//Logic for choice 4
					else if(choice2.equals("4"))
					{
						//Resets the screen to look neater
						System.out.print("\033[H\033[2J");
						System.out.flush();
						
						System.out.println("\nGood Bye!\n");
						sc.close();
						System.exit(0);
					}
					
					//For incorrect input
					else
					{
						//Resets the screen to look neater
						System.out.print("\033[H\033[2J");
						System.out.flush();
						
						System.out.println("Invalid entry, please try again:");
					}
					
				}
			}
			
			
			//Logic for choice 2
			else if(choice1.equals("2"))
			{
				//Resets the screen to look neater
				System.out.print("\033[H\033[2J");
				System.out.flush();
				
				System.out.println("\nGood Bye!\n");
				sc.close();
				System.exit(0);		
			}
			
			
			//Logic for invalid entries
			else
			{
				//Resets the screen to look neater
				System.out.print("\033[H\033[2J");
				System.out.flush();
				
				System.out.println("Invalid entry, please try again:");
				continue;
			}
		}
	}
}
