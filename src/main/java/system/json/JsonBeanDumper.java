package system.json;

import system.beans.Bean;

public class JsonBeanDumper {
	private static JsonBeanDumper instance = null;
	private JsonObjectMapper jsonObjectMapper = null;
	
	public static JsonBeanDumper getInstance() {
		if (JsonBeanDumper.instance == null)
			JsonBeanDumper.instance = new JsonBeanDumper();
		return JsonBeanDumper.instance;
	}
	
	public JsonBeanDumper() {
		this.jsonObjectMapper = JsonObjectMapper.getInstance();
	}
	
	public String dumpToString(Bean bean) throws CannotDumpToJsonStringException {
		return this.jsonObjectMapper.dumpToString(bean);
	}
	
	public void dumpToFile(Bean bean, String path) throws CannotDumpToJsonFileException {
		this.jsonObjectMapper.dumpToFile(bean, path);
	}
}
