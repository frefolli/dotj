package system.yaml;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class ObjectMapperWrapper {
	public static ObjectMapperWrapper instance = null;
	private ObjectMapper objectMapper = null;
	
	private ObjectMapperWrapper() {
		this.objectMapper = new ObjectMapper(new YAMLFactory());
		this.objectMapper.findAndRegisterModules();
	}
	
	public Object loadFromString(String string, Class<?> theClass) {
		try {
			return this.objectMapper.readValue(string, theClass);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Object loadFromFile(String filepath, Class<?> theClass) {
		return this.loadFromFile(new File(filepath), theClass);
	}
	
	public Object loadFromFile(File fileObject, Class<?> theClass) {
		try {
			return this.objectMapper.readValue(fileObject, theClass);
		} catch (Exception e) {
			return null;
		}
	}

	public static ObjectMapperWrapper getInstance() {
		if (ObjectMapperWrapper.instance == null)
			ObjectMapperWrapper.instance = new ObjectMapperWrapper();
		return ObjectMapperWrapper.instance;
	}
}