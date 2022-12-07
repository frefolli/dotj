package system.json;

import system.beans.Bean;

public class CannotDumpToJsonStringException extends Exception {

	public CannotDumpToJsonStringException(Bean bean) {
		super(String.format("cannot dump %s to json string", bean.toString()));
	}

}
