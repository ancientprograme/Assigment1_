
public class WeakPasswordException extends Exception {

	/**
	 * thrown if input is between 6-9 characters and is vaild.
	 */
	private static final long serialVersionUID = -1882406726741274678L;

	public WeakPasswordException() {
		super("Passwords is weak- less than 10 characters");
	}
}
