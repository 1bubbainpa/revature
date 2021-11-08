package com.revatureMichael.banking.app;

public class BankDatabaser
{
	String username;
	String password;
	char type;
	
	String firstname;
	String lastname;
	String city;
	String state;
	String zipcode;
	String email;
	
	public BankDatabaser(char type) 
	{
		this.type = type; //C for Customer or E for Employee
	}

	public BankDatabaser(String firstname, String lastname, String city, String state, String zipcode, String email)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
	}
	
	public boolean validateCredentials(StringBuilder user, StringBuilder pass)
	{
		if(type == 'C') //If Customer
		{
			System.out.println("Attempting Customer Login...");
			return true;
		}
		if(type == 'E') //If Employee
		{
			System.out.println("Attempting Employee Login...");
			return true;
		}
		return false;
	}

	public boolean deposit(long deposit) 
	{
		//Add Funds, if successful, return true
		return true;
	}
	
	public boolean withdraw(long withdraw) 
	{
		//Return Funds, if successful, return true
		return true;
	}

	//Getters and Setters
	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public int getBalance() 
	{
		return 0;
	}

	public String getFirstname() 
	{
		return firstname;
	}

	public void setFirstname(String firstname) 
	{
		this.firstname = firstname;
	}

	public String getLastname() 
	{
		return lastname;
	}

	public void setLastname(String lastname) 
	{
		this.lastname = lastname;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getState() 
	{
		return state;
	}

	public void setState(String state) 
	{
		this.state = state;
	}

	public String getZipcode() 
	{
		return zipcode;
	}

	public void setZipcode(String zipcode) 
	{
		this.zipcode = zipcode;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	
}
