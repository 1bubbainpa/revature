/**
 * Prints out Odd Numbers from 1-10
 * @author Michael Ord
 * Created for Revature Fall 2021
 */
public class ExerciseOne 
{

	public static void main(String[] args) 
	{
		int x = 1;
		do
		{
			if(x % 2 == 1)
			{
				System.out.print(x + " ");
			}
			x++;
		} while (x < 10);

	}

}
