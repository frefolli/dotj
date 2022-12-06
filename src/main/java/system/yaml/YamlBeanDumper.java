package system.yaml;

import system.beans.Bean;

public class YamlBeanDumper {
	private static YamlBeanDumper instance = null;
	private YamlObjectMapper yamlObjectMapper = null;
	
	public static YamlBeanDumper getInstance() {
		if (YamlBeanDumper.instance == null)
			YamlBeanDumper.instance = new YamlBeanDumper();
		return YamlBeanDumper.instance;
	}
	
	public YamlBeanDumper() {
		this.yamlObjectMapper = YamlObjectMapper.getInstance();
	}
	
	public String dumpToString(Bean bean) throws CannotDumpToYamlStringException {
		return this.yamlObjectMapper.dumpToString(bean);
	}
	
	public void dumpToFile(Bean bean, String path) throws CannotDumpToYamlFileException {
		this.yamlObjectMapper.dumpToFile(bean, path);
	}
}
