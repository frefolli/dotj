package system.parser;

import system.json.JsonBeanParser;
import system.yaml.CannotParseYamlFromFileException;
import system.yaml.CannotParseYamlFromStringException;
import system.yaml.YamlBeanParser;
import system.beans.Bean;

public abstract class BeanParser {
	private YamlBeanParser yamlParser = null;
	private JsonBeanParser jsonParser = null;
	private Class<?> beanClass = null;
	
	protected BeanParser(Class<?> beanClass) {
		this.jsonParser = JsonBeanParser.getInstance();
		this.yamlParser = YamlBeanParser.getInstance();
		this.beanClass = beanClass;
	}
	
	public Bean parseFromString(String text) throws CannotParseBeanFromStringException {
		try {
			return this.yamlParser.parseFromString(text, this.beanClass);
		} catch (CannotParseYamlFromStringException e) {
			throw new CannotParseBeanFromStringException(text);
		}
	}
	
	public Bean parseFromFile(String path) throws CannotParseBeanFromFileException {
		try {
			return this.yamlParser.parseFromFile(path, beanClass);
		} catch (CannotParseYamlFromFileException e) {
			throw new CannotParseBeanFromFileException(path);
		}
	}
}