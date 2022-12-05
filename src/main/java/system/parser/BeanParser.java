package system.parser;

import system.json.JsonBeanParser;
import system.yaml.YamlBeanParser;
import system.beans.Bean;

public abstract class BeanParser {
	private YamlBeanParser yamlParser = null;
	private JsonBeanParser jsonParser = null;
	private Class<?> beanClass = null;
	
	protected BeanParser(Class<?> beanClass) {
		// TODO
	}
	
	public Bean parseFromString(String text) {
		// TODO
		return null;
	}
	
	public Bean parseFromFile(String path) {
		// TODO
		return null;
	}

}
