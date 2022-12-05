package system.yaml;

import system.beans.Bean;

public class YamlObjectMapper {
	private static YamlObjectMapper instance = null;
	
	public static YamlObjectMapper getInstance() {
		// TODO
		return null;
	}

	public YamlObjectMapper() {
		// TODO Auto-generated constructor stub
	}

	public Bean parseFromString(String text, Class<?> beanClass) {
		// TODO
		return null;
	}

	public Bean parseFromFile(String text, Class<?> beanClass) {
		// TODO
		return null;
	}
	
	public String dumpToString(Bean bean) {
		// TODO
		return null;
	}
	
	public void dumpToFile(Bean bean, String path) {
		// TODO
	}
}
