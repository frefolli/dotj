package system.parser;

import system.beans.PackageBean;

public class PackageBeanParser extends BeanParser {
	private static PackageBeanParser instance = null;
	
	public static PackageBeanParser getInstance() {
		if (PackageBeanParser.instance == null)
			PackageBeanParser.instance = new PackageBeanParser();
		return PackageBeanParser.instance;
	}
	
	private PackageBeanParser() {
		super(PackageBean.class);
	}
	
	public PackageBean parseFromString(String text) throws CannotParsePackageBeanFromStringException {
		try {
			return PackageBean.class.cast(super.parseFromString(text));
		} catch (CannotParseBeanFromStringException e) {
			throw new CannotParsePackageBeanFromStringException(text);
		}
	}
	
	public PackageBean parseFromFile(String path) throws CannotParsePackageBeanFromFileException {
		try {
			return PackageBean.class.cast(super.parseFromFile(path));
		} catch (CannotParseBeanFromFileException e) {
			throw new CannotParsePackageBeanFromFileException(path);
		}
	}
}
