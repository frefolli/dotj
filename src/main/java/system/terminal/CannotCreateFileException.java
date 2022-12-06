package system.terminal;

public class CannotCreateFileException extends Exception {

	public CannotCreateFileException(String file) {
		super(String.format("cannot create file %s", file));
	}

}
