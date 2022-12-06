package system.dumper;

import system.beans.Bean;

public class CannotDumpSoftwareAliasesBeanToFileException extends CannotDumpBeanToFileException {

	public CannotDumpSoftwareAliasesBeanToFileException(Bean bean, String path) {
		super(bean, path);
	}

}
