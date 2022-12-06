package system.terminal;

public class CannotLoadSoftwareAliasesFromFileException extends Exception {

	public CannotLoadSoftwareAliasesFromFileException(String configFilePath) {
		super(String.format("cannot load software aliases from file %s", configFilePath));
	}

}
