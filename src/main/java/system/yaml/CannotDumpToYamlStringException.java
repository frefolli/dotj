package system.yaml;

import system.beans.Bean;

public class CannotDumpToYamlStringException extends Exception {

	public CannotDumpToYamlStringException(Bean bean) {
		super(String.format("cannot dump %s to yaml string", bean.toString()));
	}

}
