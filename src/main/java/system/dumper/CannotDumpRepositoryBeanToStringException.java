package system.dumper;

import system.beans.Bean;

public class CannotDumpRepositoryBeanToStringException extends CannotDumpBeanToStringException {

	public CannotDumpRepositoryBeanToStringException(Bean bean) {
		super(bean);
	}

}
