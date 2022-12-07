package system.json;

import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import system.beans.Bean;

public class JsonObjectMapper {
	private static JsonObjectMapper instance = null;
	private ObjectMapper objectMapper = null;
	
	public static JsonObjectMapper getInstance() {
		if (JsonObjectMapper.instance == null)
			JsonObjectMapper.instance = new JsonObjectMapper();
		return JsonObjectMapper.instance;
	}

	public JsonObjectMapper() {
		this.objectMapper = new ObjectMapper();
	}

	public Bean parseFromString(String text, Class<?> beanClass) throws CannotParseJsonFromStringException {
		try {
			return Bean.class.cast(this.objectMapper.readValue(text, beanClass));
		} catch (Exception e) {
			throw new CannotParseJsonFromStringException(text);
		}
	}

	public Bean parseFromFile(String path, Class<?> beanClass) throws CannotParseJsonFromFileException {
		try {
			return Bean.class.cast(this.objectMapper.readValue(new File(path), beanClass));
		} catch (Exception e) {
			throw new CannotParseJsonFromFileException(path);
		}
	}
	
	public String dumpToString(Bean bean) throws CannotDumpToJsonStringException {
		try {
			return this.objectMapper.writeValueAsString(bean);
		} catch (Exception e) {
			throw new CannotDumpToJsonStringException(bean);
		}
	}
	
	public void dumpToFile(Bean bean, String path) throws CannotDumpToJsonFileException {
		try {
			this.objectMapper.writeValue(new File(path), bean);
		} catch (Exception e) {
			throw new CannotDumpToJsonFileException(bean, path);
		}
	}
}
