package com.michael.database;

import java.util.List;

import com.michael.models.Account;

public interface AccountInterface 
{
	public Account selectAccountID(Integer id);
	public boolean createNewAccount(Integer id, Integer fk_user, String username, String passcode);
	public boolean checkAllUsernames(String username);
	public int FindMaxInt();
	public Account StandardLogin(String username, String password);
	public boolean DeleteAccount(Integer id);
	public boolean ChangeUsername(String username, Account acc);
	public List<Account> SelectAll();
	public List<Integer> SelectAllUnapproved();
	public boolean ApproveAccount(Integer id);
}
