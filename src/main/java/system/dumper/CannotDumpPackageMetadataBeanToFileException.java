package system.dumper;

import system.beans.Bean;

public class CannotDumpPackageMetadataBeanToFileException extends CannotDumpBeanToFileException {

	public CannotDumpPackageMetadataBeanToFileException(Bean bean, String path) {
		super(bean, path);
	}

}
