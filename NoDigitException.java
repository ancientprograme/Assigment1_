
public class NoDigitException extends Exception {
	/**
	 * Thrown if input doesnt contain A digit 
	 */
	private static final long serialVersionUID = -8662017923570767150L;

	public NoDigitException() {
		super("The password must contain at least one digit");
	}

}
