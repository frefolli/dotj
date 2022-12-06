package system.parser;

public class CannotParseRepositoryBeanFromFileException extends Exception {

	public CannotParseRepositoryBeanFromFileException(String path) {
		super(String.format("canot parse bean from file %s", path));
	}

}
