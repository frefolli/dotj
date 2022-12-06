package system.parser;

import system.beans.RepositoryBean;

public class RepositoryBeanParser extends BeanParser {
	private static RepositoryBeanParser instance = null;
	
	public static RepositoryBeanParser getInstance() {
		if (RepositoryBeanParser.instance == null)
			RepositoryBeanParser.instance = new RepositoryBeanParser();
		return RepositoryBeanParser.instance;
	}
	
	private RepositoryBeanParser() {
		super(RepositoryBean.class);
	}
	
	public RepositoryBean parseFromString(String text) throws CannotParseRepositoryBeanFromStringException {
		try {
			return RepositoryBean.class.cast(super.parseFromString(text));
		} catch(CannotParseBeanFromStringException e) {
			throw new CannotParseRepositoryBeanFromStringException(text);
		}
	}
	
	public RepositoryBean parseFromFile(String path) throws CannotParseRepositoryBeanFromFileException {
		try {
			return RepositoryBean.class.cast(super.parseFromFile(path));
		} catch(CannotParseBeanFromFileException e) {
			throw new CannotParseRepositoryBeanFromFileException(path);
		}
	}
}
