import java.util.ArrayList;
import java.util.List;

public class Account 
{
	private long id;
	private String accountType;
	
	public static List<Account> createAccounts(int numAccounts)
	{
		List<Account> accountList = new ArrayList<Account>();
		for(int i = 0; i < numAccounts; i++)
		{
			accountList.add(new Account());
			accountList.get(i).setId(i);
			accountList.get(i).setAccountType("Default");
		}
		return accountList;
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id) 
	{
		this.id = id;
	}

	public String getAccountType() 
	{
		return accountType;
	}

	public void setAccountType(String accountType) 
	{
		this.accountType = accountType;
	}
	
}
