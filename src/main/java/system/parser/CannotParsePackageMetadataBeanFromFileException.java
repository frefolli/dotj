package system.parser;

public class CannotParsePackageMetadataBeanFromFileException extends Exception {

	public CannotParsePackageMetadataBeanFromFileException(String path) {
		super(String.format("canot parse bean from file %s", path));
	}

}
