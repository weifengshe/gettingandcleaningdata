package edu.gatech.seclass;



/**
 * This is an interface for a simple class that represents a string, defined
 * as a sequence of characters.
 * 
 * @author Rufus
 * 
 */

public class MyString implements MyStringInterface {
	
	// instance variable declaration
	private String str;
	
	/**
	 * Constructor for objects of class MyString
	 */
	
	public MyString()
	{
		// initialise instance variable	
	}
	
	/**
	 * Sets the value of the current string.
	 * 
	 * @param string
	 *            The value to be set
	 */
	public void setString(String string)
	{
		this.str = string;
	}

	/**
	 * Returns the current string
	 * 
	 * @return Current string
	 */
	public String getString()
	{
		return str;
	}

	/**
	 * Returns a string that consists of all the consonants in the current string,
	 * in the same order and with the same case.
	 * ("y" is considered a consonant)
	 * 
	 * @return Consonants in the current string
	 */
	public String getConsonants()
	{
		String consonant = "";
		String strLower = str.toLowerCase();
		for (int i = 0; i < strLower.length(); i++)
		{
			String constantLetter = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
			if (constantLetter.contains(strLower.substring(i, i+1)))
			{
				consonant += str.substring(i, i+1); 
			}			
		}
		return consonant;
	}

	/**
	 * Returns the number of consonants in the current string
	 * ("y" is considered a consonant)
	 * 
	 * @return Number of consonants in the current string
	 */
	public int numberOfConsonants()
	{
		return getConsonants().length();
	}

	/**
	 * Returns the character at position "position" in the string, with 1 being the
	 * first position
	 * 
	 * @param position
	 *            Position of the character to return
	 * @return The character at position "position"
	 * @throws IllegalArgumentException
	 *             If "position" is invalid (e.g., "position" <= 0)
	 * @throws IllegalIndexException
	 *             If the string has less than "position" characters in it
	 */
	public char getCharacter(int position)
			
	{
		if (position < 0)
		{
			throw new IllegalArgumentException();
		}
		else if (position > str.length())
		{
			throw new IllegalIndexException();
		}
		else 
		{
			return str.charAt(position-1);
		}
	}

	/**
	 * Changes the case of the alphabetic characters in the current string,
	 * between startPosition and endPosition (included), with 1 being the first
	 * position:
	 * - lower case characters are replaced with the corresponding upper case characters
	 * - upper case characters are replaced with the corresponding lower case characters
	 * 
	 * @param startPosition
	 *            Position of the first character to consider
	 * @param endPosition
	 *            Position of the last character to consider
	 * @return
	 * @throws IllegalArgumentException
	 *             If either "startPosition" or "endPosition" are invalid (e.g.,
	 *             "startPosition" <= 0, "endPosition" <= 0, "startPosition" > "endPosition")
	 * @throws IllegalIndexException
	 *             If the string has less than "endPosition" characters in it
	 */
	public void flipCaseInSubstring(int startPosition, int endPosition)
	{
		if (startPosition < 1 || endPosition < 1 )
		{
			throw new IllegalArgumentException();
		}
		else if(startPosition > str.length() || endPosition > str.length())
		{
			throw new IllegalIndexException();
		}
		else 
		{
			String strFlipped = str.substring(0, startPosition-1);
			int i;
			for ( i = startPosition-1; i<endPosition; i++)
			{
				char ch = str.charAt(i);
				if (isLowerCase(ch))
				{
					strFlipped += str.substring(i, i+1).toUpperCase();
				}
				else if (isUpperCase(ch))
				{
					strFlipped += str.substring(i, i+1).toLowerCase();
				}
				else
				{
					strFlipped += str.substring(i,i+1);
				}
			}
			strFlipped += str.substring(i);
			str = strFlipped;
		}
		
	}
	
			
	static boolean isLowerCase(char ch) 
	{
	    return ch >= 'a' && ch <= 'z';
	}

	static boolean isUpperCase(char ch) 
	{
	    return ch >= 'A' && ch <= 'Z';
	}
	
}
