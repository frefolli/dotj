package system.dumper;

import system.beans.RepositoryBean;

public class RepositoryBeanDumper extends BeanDumper {
	private static RepositoryBeanDumper instance = null;
	
	public static RepositoryBeanDumper getInstance() {
		// TODO
		return null;
	}
	
	private RepositoryBeanDumper() {
		super(RepositoryBean.class);
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
