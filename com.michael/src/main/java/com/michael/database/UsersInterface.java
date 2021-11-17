package com.michael.database;

import com.michael.models.Users;

public interface UsersInterface 
{
	public Users selectUserID(Integer id);
	public boolean createNewUser(Integer id, String firstname, String lastname, String email);
	public int FindMaxInt();
	public boolean checkAllEmails(String email);
	public boolean deleteUser(Integer id);
	public boolean ChangeEmail(String email, Users us);
	public String GetFullName(Integer id);
}
