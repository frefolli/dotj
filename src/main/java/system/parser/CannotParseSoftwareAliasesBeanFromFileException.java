package system.parser;

public class CannotParseSoftwareAliasesBeanFromFileException extends Exception {

	public CannotParseSoftwareAliasesBeanFromFileException(String path) {
		super(String.format("canot parse bean from file %s", path));
	}

}
