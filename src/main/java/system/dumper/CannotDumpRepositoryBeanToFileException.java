package system.dumper;

import system.beans.Bean;

public class CannotDumpRepositoryBeanToFileException extends CannotDumpBeanToFileException {

	public CannotDumpRepositoryBeanToFileException(Bean bean, String path) {
		super(bean, path);
	}

}
