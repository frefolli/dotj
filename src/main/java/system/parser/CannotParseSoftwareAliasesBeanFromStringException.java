package system.parser;

public class CannotParseSoftwareAliasesBeanFromStringException extends Exception {

	public CannotParseSoftwareAliasesBeanFromStringException(String text) {
		super(String.format("canot parse bean from string \"%s\"", text));
	}

}
