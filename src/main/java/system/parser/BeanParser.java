package system.parser;

import system.json.JsonBeanParser;
import system.yaml.YamlBeanParser;

public abstract class BeanParser {
	private YamlBeanParser yamlParser = null;
	private JsonBeanParser jsonParser = null;
	private Class<?> beanClass = null;
	
	protected BeanParser(Class<?> beanClass) {
		// TODO
	}
	
	public Object parseFromString(String text) {
		// TODO
		return null;
	}
	
	public Object parseFromFile(String path) {
		// TODO
		return null;
	}

}
