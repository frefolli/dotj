package system.terminal;

public class CannotCreateDirectoryException extends Exception {

	public CannotCreateDirectoryException(String directory) {
		super(String.format("cannot create directory %s", directory));
	}

}
