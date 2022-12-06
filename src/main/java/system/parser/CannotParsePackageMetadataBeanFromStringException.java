package system.parser;

public class CannotParsePackageMetadataBeanFromStringException extends Exception {

	public CannotParsePackageMetadataBeanFromStringException(String text) {
		super(String.format("canot parse bean from string \"%s\"", text));
	}

}
