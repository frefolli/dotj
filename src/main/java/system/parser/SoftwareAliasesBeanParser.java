package system.parser;

import system.beans.SoftwareAliasesBean;

public class SoftwareAliasesBeanParser extends BeanParser {
	private static SoftwareAliasesBeanParser instance = null;
	
	public static SoftwareAliasesBeanParser getInstance() {
		if (SoftwareAliasesBeanParser.instance == null)
			SoftwareAliasesBeanParser.instance = new SoftwareAliasesBeanParser();
		return SoftwareAliasesBeanParser.instance;
	}
	
	private SoftwareAliasesBeanParser() {
		super(SoftwareAliasesBean.class);
	}
	
	public SoftwareAliasesBean parseFromString(String text) throws CannotParseSoftwareAliasesBeanFromStringException {
		try {
			return SoftwareAliasesBean.class.cast(super.parseFromString(text));
		} catch (CannotParseBeanFromStringException e) {
			throw new CannotParseSoftwareAliasesBeanFromStringException(text);
		}
	}
	
	public SoftwareAliasesBean parseFromFile(String path) throws CannotParseSoftwareAliasesBeanFromFileException {
		try {
			return SoftwareAliasesBean.class.cast(super.parseFromFile(path));
		} catch (CannotParseBeanFromFileException e) {
			throw new CannotParseSoftwareAliasesBeanFromFileException(path);
		}
	}
}
