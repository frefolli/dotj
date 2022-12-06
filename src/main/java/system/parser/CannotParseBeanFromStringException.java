package system.parser;

public class CannotParseBeanFromStringException extends Exception {

	public CannotParseBeanFromStringException(String text) {
		super(String.format("cannot parse bean from string \"%s\"", text));
	}

}
