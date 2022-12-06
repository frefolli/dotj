package system.yaml;

public class CannotParseYamlFileException extends Exception {

	public CannotParseYamlFileException(String path) {
		super(String.format("cannot parse yaml file %s", path));
	}

}
