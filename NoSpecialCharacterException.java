
public class NoSpecialCharacterException extends Exception {

	/**
	 * thrown if input doesnt contain A specail character
	 */
	private static final long serialVersionUID = -423730658233424650L;

	public   NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
}
