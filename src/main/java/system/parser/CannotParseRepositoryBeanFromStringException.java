package system.parser;

public class CannotParseRepositoryBeanFromStringException extends Exception {

	public CannotParseRepositoryBeanFromStringException(String text) {
		super(String.format("canot parse bean from string \"%s\"", text));
	}

}
