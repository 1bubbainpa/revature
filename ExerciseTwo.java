/**
 * Creates an array that contains the entire alphabet
 * @author Michael Ord
 * Created for Revature Fall 2021
 */
public class ExerciseTwo 
{
	public static void main(String[] args) 
	{
		char[] array = getAlphabetArray();
	}
	
	/**
	 * 
	 * @return An array containing the entire alphabet
	 */
	public static char[] getAlphabetArray()
	{
		char[] alpha = new char[26];
		char letter = 'a';
		int counter = 0;
				 
		do 
		{
			alpha[counter] = letter;
			letter++;
			counter++;
		} while (counter < 26);

		return alpha;	
	}
}
