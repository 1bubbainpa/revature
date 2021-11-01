package com.revatureMichael.banking.app;

import java.util.List;

import com.revatureMichael.banking.dao.AccountDAO;
import com.revatureMichael.banking.dao.AccountDAOImpl;
import com.revatureMichael.banking.models.Account;

public class Simulator {

	public static void main(String[] args) 
	{
		//Select Specific
		AccountDAO adao = new AccountDAOImpl();
		Account e = adao.selectAccountById(1);
		System.out.println("Select Specific: " + e);
		
		//Select All
		//List<Employee> eList = edao.selectAllEmployees();
		//for (Employee emp : eList)
		//{
		//	System.out.println(emp);
		//}
		
		//Insert Account
		Account add = new Account(3, 50, false);
		if(adao.insertIntoAccount(add))
		{
			System.out.println("Insert Success!");
		}
		
		//Delete Account
		if(adao.deleteAccount(add));
		{
			System.out.println("Delete Success!");
		}
		
		//Update Account
		Account upd = new Account(1, 200, true);
		if(adao.updateAccount(upd))
		{
			System.out.println("Update Success!");
		}
	}

}
