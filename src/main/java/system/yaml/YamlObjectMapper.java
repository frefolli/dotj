package system.yaml;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import system.beans.Bean;

public class YamlObjectMapper {
	private static YamlObjectMapper instance = null;
	private ObjectMapper objectMapper = null;
	
	public static YamlObjectMapper getInstance() {
		if (YamlObjectMapper.instance == null)
			YamlObjectMapper.instance = new YamlObjectMapper();
		return YamlObjectMapper.instance;
	}

	public YamlObjectMapper() {
		this.objectMapper = new ObjectMapper(new YAMLFactory());
		this.objectMapper.findAndRegisterModules();
	}

	public Bean parseFromString(String text, Class<?> beanClass) throws CannotParseYamlFromStringException {
		try {
			return Bean.class.cast(this.objectMapper.readValue(text, beanClass));
		} catch (Exception e) {
			throw new CannotParseYamlFromStringException(text);
		}
	}

	public Bean parseFromFile(String path, Class<?> beanClass) throws CannotParseYamlFromFileException {
		try {
			return Bean.class.cast(this.objectMapper.readValue(new File(path), beanClass));
		} catch (Exception e) {
			throw new CannotParseYamlFromFileException(path);
		}
	}
	
	public String dumpToString(Bean bean) throws CannotDumpToYamlStringException {
		try {
			return this.objectMapper.writeValueAsString(bean);
		} catch (Exception e) {
			throw new CannotDumpToYamlStringException(bean);
		}
	}
	
	public void dumpToFile(Bean bean, String path) throws CannotDumpToYamlFileException {
		try {
			this.objectMapper.writeValue(new File(path), bean);
		} catch (Exception e) {
			throw new CannotDumpToYamlFileException(bean, path);
		}
	}
}
