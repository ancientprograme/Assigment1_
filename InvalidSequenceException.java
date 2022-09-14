
public class InvalidSequenceException extends Exception {

	/**
	 * thrown if character repasts more than 2 times
	 */
	private static final long serialVersionUID = -715765392266107006L;

	public InvalidSequenceException () {
		super("The password cannot contain more than two of the same character in sequence");
	}
}
