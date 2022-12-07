package system.json;

import system.beans.Bean;

public class JsonBeanParser {
	private static JsonBeanParser instance = null;
	private JsonObjectMapper jsonObjectMapper = null;
	
	public static JsonBeanParser getInstance() {
		if (JsonBeanParser.instance == null)
			JsonBeanParser.instance = new JsonBeanParser();
		return JsonBeanParser.instance;
	}
	
	public JsonBeanParser() {
		this.jsonObjectMapper = JsonObjectMapper.getInstance();
	}

	public Bean parseFromString(String text, Class<?> beanClass) throws CannotParseJsonFromStringException {
		return this.jsonObjectMapper.parseFromString(text, beanClass);
	}

	public Bean parseFromFile(String path, Class<?> beanClass) throws CannotParseJsonFromFileException {
		return this.jsonObjectMapper.parseFromFile(path, beanClass);
	}
}
