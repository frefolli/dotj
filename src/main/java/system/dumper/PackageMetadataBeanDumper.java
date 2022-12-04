package system.dumper;

import system.beans.PackageMetadataBean;

public class PackageMetadataBeanDumper extends BeanDumper {
	private static PackageMetadataBeanDumper instance = null;
	
	public static PackageMetadataBeanDumper getInstance() {
		// TODO
		return null;
	}
	
	private PackageMetadataBeanDumper() {
		super(PackageMetadataBean.class);
		// TODO
	}
	
	public String dumpToString(Object object) {
		// TODO
		return null;
	}
	
	public void dumpToFile(Object object, String path) {
		// TODO
	}
}
