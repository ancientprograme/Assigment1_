
public class LengthException extends Exception{

	/**
	 * Thrown is input is less than 6 characters
	 */
	private static final long serialVersionUID = 6067355039683548689L;

	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}
