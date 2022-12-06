package system.parser;

public class CannotParseBeanFromFileException extends Exception {

	public CannotParseBeanFromFileException(String path) {
		super(String.format("cannot parse bean from file %s", path));
	}

}
