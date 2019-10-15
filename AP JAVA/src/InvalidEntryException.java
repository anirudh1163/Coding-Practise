
public class InvalidEntryException extends Exception {

	private String message;

	public InvalidEntryException() {
		this.message = "Invalid input. Please try again...\\n";
	}

	public String getMessage() {
		return message;
	}
}
