package com.michael.database;

import com.michael.models.Account;
import com.michael.models.Admin;

public interface AdminInterface 
{
	public Admin selectAdminID(Integer id);
	public boolean createNewAdmin(Integer id, String username, String passcode);
	public Admin adminLogin(String user, String pass);
	
}
