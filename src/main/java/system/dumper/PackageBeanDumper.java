package system.dumper;

import system.beans.PackageBean;

public class PackageBeanDumper extends BeanDumper {
	private static PackageBeanDumper instance = null;
	
	public static PackageBeanDumper getInstance() {
		// TODO
		return null;
	}
	
	private PackageBeanDumper() {
		super(PackageBean.class);
		// TODO
	}
	
	public String dumpToString(PackageBean package_) {
		// TODO
		return null;
	}
	
	public void dumpToFile(PackageBean package_, String path) {
		// TODO
	}
}
