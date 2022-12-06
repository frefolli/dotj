package system.parser;

public class CannotParsePackageBeanFromStringException extends CannotParseBeanFromStringException {

	public CannotParsePackageBeanFromStringException(String text) {
		super(String.format("canot parse package bean from string \"%s\"", text));
	}

}
