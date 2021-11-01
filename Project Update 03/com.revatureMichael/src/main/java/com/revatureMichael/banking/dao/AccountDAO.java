package com.revatureMichael.banking.dao;

import java.util.List;

import com.revatureMichael.banking.models.*;

public interface AccountDAO 
{
	public boolean insertIntoAccount(Account act);
	public Account selectAccountById(Integer id);
	public List<Account> selectAllAccounts();
	public boolean updateAccount(Account acc);
	public boolean deleteAccount(Account acc);
}
