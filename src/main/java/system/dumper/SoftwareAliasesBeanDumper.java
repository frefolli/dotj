package system.dumper;

import system.beans.SoftwareAliasesBean;

public class SoftwareAliasesBeanDumper extends BeanDumper {
	private static SoftwareAliasesBeanDumper instance = null;
	
	public static SoftwareAliasesBeanDumper getInstance() {
		// TODO
		return null;
	}
	
	private SoftwareAliasesBeanDumper() {
		super(SoftwareAliasesBean.class);
		// TODO
	}
	
	public String dumpToString(SoftwareAliasesBean softwareAliases) {
		// TODO
		return null;
	}
	
	public void dumpToFile(SoftwareAliasesBean softwareAliases, String path) {
		// TODO
	}
}
