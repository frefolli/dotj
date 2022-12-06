package system.dumper;

import system.beans.PackageMetadataBean;

public class PackageMetadataBeanDumper extends BeanDumper {
	private static PackageMetadataBeanDumper instance = null;
	
	public static PackageMetadataBeanDumper getInstance() {
		if (PackageMetadataBeanDumper.instance == null)
			PackageMetadataBeanDumper.instance = new PackageMetadataBeanDumper();
		return PackageMetadataBeanDumper.instance;
	}
	
	private PackageMetadataBeanDumper() {
		super(PackageMetadataBean.class);
	}
	
	public String dumpToString(PackageMetadataBean metadata) throws CannotDumpPackageMetadataBeanToStringException {
		try {
			return super.dumpToString(metadata);
		} catch (CannotDumpBeanToStringException e) {
			throw new CannotDumpPackageMetadataBeanToStringException(metadata);
		}
	}
	
	public void dumpToFile(PackageMetadataBean metadata, String path) throws CannotDumpPackageMetadataBeanToFileException {
		try {
			super.dumpToFile(metadata, path);
		} catch (CannotDumpBeanToFileException e) {
			throw new CannotDumpPackageMetadataBeanToFileException(metadata, path);
		}
	}
}
