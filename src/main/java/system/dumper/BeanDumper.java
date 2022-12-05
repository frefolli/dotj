package system.dumper;

import system.beans.Bean;
import system.json.JsonBeanDumper;
import system.yaml.YamlBeanDumper;

public abstract class BeanDumper {
	private YamlBeanDumper yamlDumper = null;
	private JsonBeanDumper jsonDumper = null;
	private Class<?> beanClass = null;
	
	protected BeanDumper(Class<?> beanClass) {
		// TODO
	}
	
	public String dumpToString(Bean bean) {
		// TODO
		return null;
	}
	
	public void dumpToFile(Bean bean, String path) {
		// TODO
	}
}
