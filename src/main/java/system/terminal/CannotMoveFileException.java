package system.terminal;

public class CannotMoveFileException extends Exception {

	public CannotMoveFileException(String file, String destination) {
		super(String.format("cannot move file %s to %s", file, destination));
	}

}
