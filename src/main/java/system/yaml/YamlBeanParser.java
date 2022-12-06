package system.yaml;

import system.beans.Bean;

public class YamlBeanParser {
	private static YamlBeanParser instance = null;
	private YamlObjectMapper yamlObjectMapper = null;
	
	public static YamlBeanParser getInstance() {
		if (YamlBeanParser.instance == null)
			YamlBeanParser.instance = new YamlBeanParser();
		return YamlBeanParser.instance;
	}
	
	public YamlBeanParser() {
		this.yamlObjectMapper = new YamlObjectMapper();
	}

	public Bean parseFromString(String text, Class<?> beanClass) throws CannotParseYamlStringException {
		return this.yamlObjectMapper.parseFromString(text, beanClass);
	}

	public Bean parseFromFile(String text, Class<?> beanClass) throws CannotParseYamlFileException {
		return this.yamlObjectMapper.parseFromFile(text, beanClass);
	}
}
