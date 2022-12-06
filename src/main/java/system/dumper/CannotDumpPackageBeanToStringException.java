package system.dumper;

import system.beans.Bean;

public class CannotDumpPackageBeanToStringException extends CannotDumpBeanToStringException {

	public CannotDumpPackageBeanToStringException(Bean bean) {
		super(bean);
	}

}
