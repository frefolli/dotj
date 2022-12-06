package system.parser;

public class CannotParseBeanFromFileException extends Exception {

	public CannotParseBeanFromFileException(String path) {
		super(String.format("canot parse bean from file %s", path));
	}

}
