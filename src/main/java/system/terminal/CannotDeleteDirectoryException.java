package system.terminal;

public class CannotDeleteDirectoryException extends Exception {

	public CannotDeleteDirectoryException(String directory) {
		super(String.format("cannot delete directory %s", directory));
	}

}
