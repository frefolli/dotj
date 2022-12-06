package system.parser;

public class CannotParseBeanFromStringException extends Exception {

	public CannotParseBeanFromStringException(String text) {
		super(String.format("canot parse bean from string \"%s\"", text));
	}

}
