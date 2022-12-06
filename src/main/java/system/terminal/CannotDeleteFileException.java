package system.terminal;

public class CannotDeleteFileException extends Exception {

	public CannotDeleteFileException(String file) {
		super(String.format("cannot delete file %s", file));
	}

}
