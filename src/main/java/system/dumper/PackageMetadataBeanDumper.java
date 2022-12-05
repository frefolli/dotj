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
	
	public String dumpToString(PackageMetadataBean metadata) {
		// TODO
		return null;
	}
	
	public void dumpToFile(PackageMetadataBean metadata, String path) {
		// TODO
	}
}
