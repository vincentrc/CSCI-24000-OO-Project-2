/*Honor Pledge: I pledge that I have neither given
nor received any help on this assignment**/

public class Employee 
{
	//Attributes
	protected String ID;
	protected String firstname;
	protected String lastname;
	protected String hourlyrate;
	
	
	//Constructor
	Employee()
	{
	}
	
	//Getters
	public String getID()
	{
		return this.ID;
	}
	
	public String
	getfirstname()
	{
		return this.firstname;
	}
	
	public String getlastname()
	{
		return this.lastname;
	}
	
	public String getrate()
	{
		return this.hourlyrate;
	}
	
	
	//Setters
	public void setID(String input)
	{
		this.ID = input;
	}
	
	public void setfirstname(String input)
	{
		this.firstname = input;
	}
	
	public void setlastname(String input)
	{
		this.lastname = input;
	}
	
	public void setrate(String input)
	{
		this.hourlyrate = input;
	}
	
	
}
