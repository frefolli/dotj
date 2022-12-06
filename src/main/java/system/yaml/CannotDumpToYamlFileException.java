package system.yaml;

import system.beans.Bean;

public class CannotDumpToYamlFileException extends Exception {

	public CannotDumpToYamlFileException(Bean bean, String path) {
		super(String.format("cannot dump %s to yaml file %s", bean.toString(), path));
	}

}
