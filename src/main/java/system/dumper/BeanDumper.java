package system.dumper;

import system.json.JsonBeanDumper;
import system.yaml.YamlBeanDumper;

public abstract class BeanDumper {
	private YamlBeanDumper yamlDumper = null;
	private JsonBeanDumper jsonDumper = null;
	private Class<?> beanClass = null;
	
	protected BeanDumper(Class<?> beanClass) {
		// TODO
	}
	
	public String dumpToString(Object object) {
		// TODO
		return null;
	}
	
	public void dumpToFile(Object object, String path) {
		// TODO
	}
}
