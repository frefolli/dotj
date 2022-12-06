package system.terminal;

public class CannotMoveDirectoryException extends Exception {

	public CannotMoveDirectoryException(String directory, String destination) {
		super(String.format("cannot move directory %s to %s", directory, destination));
	}

}
