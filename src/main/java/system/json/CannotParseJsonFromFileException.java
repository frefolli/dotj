package system.json;

public class CannotParseJsonFromFileException extends Exception {

	public CannotParseJsonFromFileException(String path) {
		super(String.format("cannot parse json file %s", path));
	}

}
