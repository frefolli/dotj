package system.parser;

public class CannotParsePackageBeanFromFileException extends CannotParseBeanFromFileException {

	public CannotParsePackageBeanFromFileException(String path) {
		super(String.format("canot parse package bean from file %s", path));
	}

}
