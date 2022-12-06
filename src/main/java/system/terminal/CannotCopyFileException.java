package system.terminal;

public class CannotCopyFileException extends Exception {

	public CannotCopyFileException(String file, String destination) {
		super(String.format("cannot copy file %s to %s", file, destination));
	}

}
