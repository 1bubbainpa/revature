import java.util.Scanner;

/**
 * The user guesses between a random number between 0 and 100 using the Scanner Class
 * @author Michael Ord, Created for Revature
 *
 */
public class GuesserMain {

	//Scanner Class
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args)
	{
		//secretNumber - Random number between 0 and 100
		//solved - tracks to see if user got the correct number
		int secretNumber = GenerateNumber();
		boolean solved = false;		
		System.out.print("Guess a number between 0 and 100 \n");
		
		while(!solved)
		{
			int guess = scan.nextInt();
			if(guess == secretNumber)
			{
				System.out.println("Correct!");
				solved = true;
			}
			else if(guess > secretNumber)
			{
				System.out.println("Too High");
			}
			else if(guess < secretNumber)
			{
				System.out.println("Too Low");
			}
		}
	}
	
	//Returns an integer between 0 and 100
	private static int GenerateNumber() 
	{
		return (int) (Math.random() * 100);
	}
}