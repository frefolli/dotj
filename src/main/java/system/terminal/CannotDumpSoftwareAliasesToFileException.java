package system.terminal;

public class CannotDumpSoftwareAliasesToFileException extends Exception {

	public CannotDumpSoftwareAliasesToFileException(String configFilePath) {
		super(String.format("cannot dump software aliases to file %s", configFilePath));
	}

}
