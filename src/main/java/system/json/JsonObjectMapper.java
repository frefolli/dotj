package system.json;

import system.beans.Bean;

public class JsonObjectMapper {
	private static JsonObjectMapper instance = null;
	
	public static JsonObjectMapper getInstance() {
		// TODO
		return null;
	}

	public JsonObjectMapper() {
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