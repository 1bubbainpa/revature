package com.michael.utilities;

/**
 * Proofreads Strings and such to check for bad input.
 * @author Michael Ord
 *
 */
public class ProofReader 
{
	public boolean checkAll(String s)
	{
		if(CheckForInput(s) == false)
		{
			return false;
		}
		if(CheckForbiddenCharacters(s) == false)
		{
			return false;
		}
		if(CheckForNull(s) == false)
		{
			return false;
		}
		return true;
	}
	/**
	 * Check that a String has between inclusively 1 and 30 size length.
	 * @param s String to be checked
	 * @return if the string is between said range.
	 */
	public boolean CheckForInput(String s)
	{
		if(s.length() == 0)
		{
			System.out.println("Error: No input");
			return false;
		}
		if(s.length() > 30)
		{
			System.out.println("Error: Too long");
			return false;
		}
		return true;
	}
	
	/**
	 * Prevents certain characters from appearing in Strings
	 * @param s String to be checked
	 * @return if the string doesn't have any of the "forbode" characters.
	 */
	public boolean CheckForbiddenCharacters(String s)
	{
		String[] forbode = {"!", "#", "$", "%", "^", "&", "*", "/", ",",};
		for(int i = 0; i< forbode.length; i++)
		{
			if(s.contains(forbode[i]))
			{
				System.out.println("Error: Bad Input: " + forbode[i]);
				return false;
			}
		}
		return true;
	}
	
	public boolean CheckForNull(String s)
	{
		if(s.equals(null))
		{
			System.out.println("Error: Null Input");
			return false;
		}
		return true;
	}
}
