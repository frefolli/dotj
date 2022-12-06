package system.dumper;

import system.beans.Bean;
import system.json.JsonBeanDumper;
import system.yaml.CannotDumpToYamlFileException;
import system.yaml.CannotDumpToYamlStringException;
import system.yaml.YamlBeanDumper;

public abstract class BeanDumper {
	private YamlBeanDumper yamlDumper = null;
	private JsonBeanDumper jsonDumper = null;
	private Class<?> beanClass = null;
	
	protected BeanDumper(Class<?> beanClass) {
		this.beanClass = beanClass;
		this.yamlDumper = YamlBeanDumper.getInstance();
		this.jsonDumper = JsonBeanDumper.getInstance();
	}
	
	public String dumpToString(Bean bean) throws CannotDumpBeanToStringException {
		try {
			return this.yamlDumper.dumpToString(bean);
		} catch (CannotDumpToYamlStringException e) {
			throw new CannotDumpBeanToStringException(bean);
		}
	}
	
	public void dumpToFile(Bean bean, String path) throws CannotDumpBeanToFileException {
		try {
			this.yamlDumper.dumpToFile(bean, path);
		} catch (CannotDumpToYamlFileException e) {
			throw new CannotDumpBeanToFileException(bean, path);
		}
	}
}
