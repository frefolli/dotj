package system.terminal;

public class CannotCopyDirectoryException extends Exception {

	public CannotCopyDirectoryException(String directory, String destination) {
		super(String.format("cannot copy directory %s to %s", directory, destination));
	}

}
