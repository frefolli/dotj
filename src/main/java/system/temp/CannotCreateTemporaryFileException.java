package system.temp;

public class CannotCreateTemporaryFileException extends Exception {
	public CannotCreateTemporaryFileException() {
		super("cannot create a temporary file");
	}
}
