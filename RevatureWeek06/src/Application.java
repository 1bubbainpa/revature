import java.util.List;

public class Application {
	public static void main(String args[])
	{
		List<Account> al = Account.createAccounts(5);
		al = Account.createAccounts(10);
		for(Account l:al)
		{
			System.out.println(l.getId());
		}
	}

}
