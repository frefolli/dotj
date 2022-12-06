package system.dumper;

import system.beans.PackageBean;

public class PackageBeanDumper extends BeanDumper {
	private static PackageBeanDumper instance = null;
	
	public static PackageBeanDumper getInstance() {
		if (PackageBeanDumper.instance == null)
				PackageBeanDumper.instance = new PackageBeanDumper();
		return PackageBeanDumper.instance;
	}
	
	private PackageBeanDumper() {
		super(PackageBean.class);
	}
	
	public String dumpToString(PackageBean package_) throws CannotDumpPackageBeanToStringException {
		try {
			return super.dumpToString(package_);
		} catch (CannotDumpBeanToStringException e) {
			throw new CannotDumpPackageBeanToStringException(package_);
		}
	}
	
	public void dumpToFile(PackageBean package_, String path) throws CannotDumpPackageBeanToFileException {
		try {
			super.dumpToFile(package_, path);
		} catch (CannotDumpBeanToFileException e) {
			throw new CannotDumpPackageBeanToFileException(package_, path);
		}
	}
}
