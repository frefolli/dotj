package system.json;

public class CannotParseJsonFromStringException extends Exception {

	public CannotParseJsonFromStringException(String text) {
		super(String.format("cannot parse json string \"%s\"", text));
	}

}
