package com.revatureMichael.banking.app;

import java.util.Scanner;

public class BankingMain 
{
	public static Scanner scan = new Scanner(System.in); //Scanner for the Program
	public static BankReader read = new BankReader(); //New BankReader Program. Only one is needed

	public static void main(String[] args) 
	{
		boolean done = false; //Loop Tracker
		while(!done)
		{
			System.out.println("Enter a number to perform an action");
			System.out.println("1. Login to a Bank Account\n2. Create a new Bank Account\n3. Login to an Employee Account\n4. Exit");
			int act = read.ReadInt(scan);
			if(act == 1)
			{
				LoginCustomer();
			}
			else if(act == 2)
			{
				CreateAccount();
			}
			else if(act == 3)
			{
				LoginEmployee();
			}
			else if(act == 4)
			{
				System.out.println("Goodbye...");
				done = true;
			}
			else
			{
				System.out.println("Error: Invalid Input Received. Try Again");
			}
		}
		System.exit(0);
		
	}

	private static void LoginEmployee() 
	{
		//TBI
		System.out.println("Please enter your first name");
		System.out.println("Please enter your last name");
		System.out.println("Please enter your city of residence");
		System.out.println("Please enter your state abbreviation");
		System.out.println("Please enter your zipcode");
		System.out.println("Please enter your email");
	}

	private static void CreateAccount() 
	{
		//TBI
	}

	private static void LoginCustomer() 
	{
		//TBI
		BankDatabaser in = new BankDatabaser('C');
		/**
		 * Creates and receives potential username and password from the user.
		 */
		StringBuilder user = new StringBuilder();
		System.out.println("Please enter your username:");
		user.append(scan.next());
		
		StringBuilder pass = new StringBuilder();
		System.out.println("Please enter your password:");
		pass.append(scan.next());	
		
		if(in.validateCredentials(user, pass) == false)
		{
			System.out.println("Invalid Credentials");
			System.exit(0);
		}
		else
		{
			System.out.println("Login Successful, " + user);
			boolean isdone = false;
			while(!isdone)
			{
				System.out.println("Your current balance is " + in.getBalance());
				System.out.println("Enter a number to perform an action");
				System.out.println("1. Deposit\n2. Withdraw\n3. Exit");
				int action = 0;
				
				try
				{
					action = scan.nextInt();
				}
				catch(Exception e)
				{
					System.out.println("Invalid Input\n");
					action = 0;
				}
				
				//Note: add try catches to these methods as well.
				if(action == 1)
				{
					System.out.println("How much would you like to Deposit?");
					long deposit = scan.nextLong();
					if(in.deposit(deposit) == true);
					{
						System.out.println("Transaction Successful");
					}
				}
				if(action == 2)
				{
					System.out.println("How much would you like to Withdraw?");
					long withdraw = scan.nextLong();
					if(in.withdraw(withdraw) == true);
					{
						System.out.println("Transaction Successful");
					}
				}
				if(action == 3)
				{
					System.out.println("Logging out " + user + "...");
					isdone = true;
				}
			}
		}
	}
}
