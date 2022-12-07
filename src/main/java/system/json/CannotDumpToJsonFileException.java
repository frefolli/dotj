package system.json;

import system.beans.Bean;

public class CannotDumpToJsonFileException extends Exception {

	public CannotDumpToJsonFileException(Bean bean, String path) {
		super(String.format("cannot dump %s to json file %s", bean.toString(), path));
	}

}
