import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	
	/**
	 * @author Azariyas T
	 */
	
	/**
	 * checks if the two inputs match each other exactly, if different throws unmatchedexception
	 * @param password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 * 
	 * 
	 */
	public static void comparePasswords(String password, String passwordConfirm)throws UnmatchedException {
		if((password.equals(passwordConfirm))== false)
			throw new UnmatchedException();
	}
	/**
	 *  checks if inputs are the same throws exception if different
	 * @param passwordString
	 * @param passwordAString
	 * @return a true if the two inputs match exactly
	 */
	public static boolean comparePasswordsWithReturn(String passwordString, String passwordAString) {
		if((passwordString.equals(passwordAString)))
				return true;
		return false;
	}

	/**
	 * check if input meets the password requirements other wise throw corresponding exception
	 * @param string
	 * @return true if all requirements are meet to be a valid password or throws an exception
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isValidPassword(String string) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException 
	{	
		if (isValidLength(string)  && hasUpperAlpha(string)&& hasLowerAlpha(string)  && hasDigit(string)
				&& hasSpecialChar(string) && NoSameCharInSequence(string)) 
			return true;
		else
		return false;
	}

	/**
	 *  checks is password has no more than 2 repeating char in a row
	 * @param pasword
	 * @return true if NO MORE than 2 repeating characters in a row
	 * @throws InvalidSequenceException
	 */
	public static boolean NoSameCharInSequence(String pasword)throws InvalidSequenceException {
		Pattern pattern =Pattern.compile("^.*(.)\\1\\1.*$");
		Matcher matcher =pattern.matcher(pasword);
		if(matcher.find()) {
			throw new InvalidSequenceException();
		}
		else {
			return true;
		}
	}

	/**
	 * checks if password has a special character
	 * @param string
	 * @return true if it has a special character in string
	 * @throws NoSpecialCharacterException
	 */
	public static boolean hasSpecialChar(String string)throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(string);
		if(matcher.find()) {
			return true;
		}
		throw new NoSpecialCharacterException();
	}

	/**
	 *  checks if password has a digit
	 * @param password
	 * @return true if string has a number character, false otherwise
	 * @throws NoDigitException
	 */
	public static boolean hasDigit(String password)throws NoDigitException {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(password);

		if (matcher.find()) {
			return true;
	}
		throw new NoDigitException();
	}

	/**
	 * checks if password has a uppercase letter
	 * @param string
	 * @return true if string as a upper case character
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha(String string)throws NoUpperAlphaException {
		Pattern pattern = Pattern.compile("[A-Z]");
		Matcher matcher = pattern.matcher(string);

		if (matcher.find()) {
			return true;
		}
		throw new NoUpperAlphaException();
	}
	public static boolean hasLowerAlpha(String string) throws NoLowerAlphaException {
		Pattern pattern = Pattern.compile("[a-z]");
		Matcher matcher = pattern.matcher(string);

		if (matcher.find()) {
			return true;
		}
		throw new NoLowerAlphaException();
	}

	/**
	 * checks if password is longer than 6 characters
	 * @param password
	 * @return true if length of password is greater than 6
	 * @throws LengthException
	 */
	public static boolean isValidLength(String password)throws LengthException {
		if (password.length() < 6) {
			throw new LengthException();
		}
		return true;
		
	}

	/**
	 * takes a list of passwords, checks if they meet the passwords requirements 
	 * displays invalid passwords with the exception that invalidates them EXCLUDEING weak password
	 * @param passwordsArray
	 * @return the list of invalid passwords with there exception
	 */
	// method code taken from github sumutoni
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwordsArray) {
		ArrayList<String>passwords=new ArrayList<String>();
		String invdpass=null;
		for (int i=0;i<passwordsArray.size();i++) {	
			try {
				invdpass=passwordsArray.get(i);
				if(!isValidPassword(invdpass)) {
					invdpass=invdpass+"";
				}
			}
			catch(Exception e) {
				passwords.add(invdpass+" -> "+e.getMessage());
			}
		}
		
		return passwords;	
	}

	/**
	 * checks if password is less than 10 character when  valid password
	 * @param passwordString
	 * @return false if is valid password and is greater than 9 characters long	
	 * @throws WeakPasswordException
	 * @throws LengthException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws NoDigitException
	 * @throws NoSpecialCharacterException
	 * @throws InvalidSequenceException
	 */
	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		if(isValidPassword(passwordString)&& (passwordString.length()>9))
			return false;
		 throw new WeakPasswordException();
	}
}
