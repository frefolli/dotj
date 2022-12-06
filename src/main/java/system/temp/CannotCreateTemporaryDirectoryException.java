package system.temp;

public class CannotCreateTemporaryDirectoryException extends Exception {
	public CannotCreateTemporaryDirectoryException() {
		super("cannot create a temporary directory");
	}
}
