package system.dumper;

import system.beans.Bean;

public class CannotDumpPackageBeanToFileException extends CannotDumpBeanToFileException {

	public CannotDumpPackageBeanToFileException(Bean bean, String path) {
		super(bean, path);
	}

}
