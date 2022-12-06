package system.yaml;

public class CannotParseYamlFromStringException extends Exception {

	public CannotParseYamlFromStringException(String text) {
		super(String.format("cannot parse yaml string \"%s\"", text));
	}

}
