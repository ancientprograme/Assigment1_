
public class NoUpperAlphaException extends Exception {

	/**
	 * thrown if input doesn't contain A UPPER case letter
	 */
	private static final long serialVersionUID = 8049785519647479986L;

	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
}
