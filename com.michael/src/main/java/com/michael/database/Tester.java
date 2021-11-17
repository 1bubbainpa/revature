package com.michael.database;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.michael.models.Account;
import com.michael.models.Users;

public class Tester 
{

	public static void main(String[] args) 
	{
		UsersImplementation usi = new UsersImplementation();
		AccountImplementation ai = new AccountImplementation();
		AdminImplementation adi = new AdminImplementation();
		ClassImplementation ci = new ClassImplementation();
		usi.createNewUser(usi.FindMaxInt(), "Jay", "Frame", "Inspector21@mail.com");
		//Users u = usi.selectUserID(8);
		//System.out.println(u);
		//usi.FindMaxInt();
		//System.out.println(u);
		//usi.checkAllEmails("mbo1@pct.edu");
		//System.out.println(ai.selectAccountID(9));
		//ai.checkAllUsernames("tester01");
		//ai.createNewAccount(5, 3, "tester01", "secret01");
		//ai.FindMaxInt();
		//System.out.println(ai.StandardLogin("user", "pass"));
		//ai.DeleteAccount(3);
		//usi.deleteUser(3);
		//Account acc = new Account(5, 3, "tester02", "secret01", false, 0);
		//Users u = usi.selectUserID(acc.getFk_users());
		//System.out.println(u);
		//ai.ChangeUsername("tester01", acc);
		//usi.ChangeEmail("sample@gmail.com", usi.selectUserID(loginAccount.getFk_users()));
		//System.out.println(usi.GetFullName(1));
		//adi.createNewAdmin(1, "admin", "adminpass");
		//System.out.println(adi.selectAdminID(1));
		//adi.adminLogin("admin", "adminpass");
		//List<Account> ls = ai.SelectAll();
		//System.out.println(ls.get(0).getUsername());
		//List<Integer> ls = ai.SelectAllUnapproved();
		//System.out.println(ls);
		//System.out.println(ci.selectAll());
		//int max = ci.findMaxInt();
		//System.out.println(ci.createClass(max, 8, "Biology", "2021-12-12", "06:00:00",
				//"Science", "All about Biology", "https://zoom.us/j/99788169290?pwd=c2dIajFSa0szT3RtOUJ6c0g5SzR0Zz09"));
	}

}
