package system.dumper;

import system.beans.Bean;

public class CannotDumpBeanToStringException extends Exception {

	public CannotDumpBeanToStringException(Bean bean) {
		super(String.format("cannot parse bean %s from string", bean));
	}

}
