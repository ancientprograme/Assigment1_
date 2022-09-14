
public class UnmatchedException extends Exception {

	/**
	 * thrown if inputs dont match 
	 */
	private static final long serialVersionUID = -5682761951702918203L;

	public UnmatchedException() {
		super("Passwords do not match");
	}
}
