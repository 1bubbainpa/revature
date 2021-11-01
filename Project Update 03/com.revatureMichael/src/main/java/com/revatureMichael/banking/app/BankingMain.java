package com.revatureMichael.banking.app;

import java.util.Scanner;

public class BankingMain {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		StringBuilder user = new StringBuilder();
		StringBuilder pass = new StringBuilder();
		
		System.out.println("Please enter your username:");
		user.append(scan.next());
		
		System.out.println("Please enter your password:");
		pass.append(scan.next());	
		
		InputTaker in = new InputTaker(user, pass);
		if(in.validateCredentials() == false)
		{
			System.out.println("Invalid Credentials");
			System.exit(0);
		}
		else
		{
			System.out.println("Login Successful, " + user);
			boolean done = false;
			while(!done)
			{
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
					done = true;
				}
			}
		}
		System.out.println("Logging out...");
	}
}
