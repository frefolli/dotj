package system.dumper;

import system.beans.Bean;

public class CannotDumpBeanToFileException extends Exception {

	public CannotDumpBeanToFileException(Bean bean, String path) {
		super(String.format("cannot parse bean %s to file %s", bean.toString(), path));
	}

}
