package system.parser;

import system.beans.PackageMetadataBean;

public class PackageMetadataBeanParser extends BeanParser {
	private static PackageMetadataBeanParser instance = null;
	
	public static PackageMetadataBeanParser getInstance() {
		if (PackageMetadataBeanParser.instance == null)
			PackageMetadataBeanParser.instance = new PackageMetadataBeanParser();
		return PackageMetadataBeanParser.instance;
	}
	
	private PackageMetadataBeanParser() {
		super(PackageMetadataBean.class);
	}
	
	public PackageMetadataBean parseFromString(String text) throws CannotParsePackageMetadataBeanFromStringException {
		try {
			return PackageMetadataBean.class.cast(super.parseFromString(text));
		} catch (CannotParseBeanFromStringException e) {
			throw new CannotParsePackageMetadataBeanFromStringException(text);
		}
	}
	
	public PackageMetadataBean parseFromFile(String path) throws CannotParsePackageMetadataBeanFromFileException {
		try {
			return PackageMetadataBean.class.cast(super.parseFromFile(path));
		} catch (CannotParseBeanFromFileException e) {
			throw new CannotParsePackageMetadataBeanFromFileException(path);
		}
	}
}
