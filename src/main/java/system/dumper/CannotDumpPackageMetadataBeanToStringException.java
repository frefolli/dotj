package system.dumper;

import system.beans.Bean;

public class CannotDumpPackageMetadataBeanToStringException extends CannotDumpBeanToStringException {

	public CannotDumpPackageMetadataBeanToStringException(Bean bean) {
		super(bean);
	}

}
