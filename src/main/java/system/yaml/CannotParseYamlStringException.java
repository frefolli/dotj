package system.yaml;

public class CannotParseYamlStringException extends Exception {

	public CannotParseYamlStringException(String text) {
		super(String.format("cannot parse yaml string \"%s\"", text));
	}

}
