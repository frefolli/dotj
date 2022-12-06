package system.yaml;

public class CannotParseYamlFromFileException extends Exception {

	public CannotParseYamlFromFileException(String path) {
		super(String.format("cannot parse yaml file %s", path));
	}

}
