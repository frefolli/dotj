package system.yaml;

public class Parser {
	private ObjectMapperWrapper objectMapper = null;
	private Class<?> theClass = null;
	
	public Parser(Class<?> theClass) {
		this.objectMapper = ObjectMapperWrapper.getInstance();
		this.theClass = theClass;
	}
	
	public Object readFromFile(String filepath) {
		return this.objectMapper.loadFromFile(filepath, theClass);
	}
	
	public Object readFromString(String string) {
		return this.objectMapper.loadFromString(string, theClass);
	}
	
	public Object dumpToString(Object object) {
		// TODO
		return null;
	}
	
	public Object dumpToFile(Object object, String filepath) {
		// TODO
		return null;
	}
}