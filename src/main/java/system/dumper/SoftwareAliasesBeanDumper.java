package system.dumper;

import system.beans.SoftwareAliasesBean;

public class SoftwareAliasesBeanDumper extends BeanDumper {
	private static SoftwareAliasesBeanDumper instance = null;
	
	public static SoftwareAliasesBeanDumper getInstance() {
		if (SoftwareAliasesBeanDumper.instance == null)
			SoftwareAliasesBeanDumper.instance = new SoftwareAliasesBeanDumper();
		return SoftwareAliasesBeanDumper.instance;
	}
	
	private SoftwareAliasesBeanDumper() {
		super(SoftwareAliasesBean.class);
	}
	
	public String dumpToString(SoftwareAliasesBean softwareAliases) throws CannotDumpSoftwareAliasesBeanToStringException {
		try {
			return super.dumpToString(softwareAliases);
		} catch (CannotDumpBeanToStringException e) {
			throw new CannotDumpSoftwareAliasesBeanToStringException(softwareAliases);
		}
	}
	
	public void dumpToFile(SoftwareAliasesBean softwareAliases, String path) throws CannotDumpSoftwareAliasesBeanToFileException {
		try {
			super.dumpToFile(softwareAliases, path);
		} catch (CannotDumpBeanToFileException e) {
			throw new CannotDumpSoftwareAliasesBeanToFileException(softwareAliases, path);
		}
	}
}
