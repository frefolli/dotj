package system.dumper;

import system.beans.RepositoryBean;

public class RepositoryBeanDumper extends BeanDumper {
	private static RepositoryBeanDumper instance = null;
	
	public static RepositoryBeanDumper getInstance() {
		if (RepositoryBeanDumper.instance == null)
			RepositoryBeanDumper.instance = new RepositoryBeanDumper();
		return RepositoryBeanDumper.instance;
	}
	
	private RepositoryBeanDumper() {
		super(RepositoryBean.class);
	}
	
	public String dumpToString(RepositoryBean repository) throws CannotDumpRepositoryBeanToStringException {
		try {
			return super.dumpToString(repository);
		} catch (CannotDumpBeanToStringException e) {
			throw new CannotDumpRepositoryBeanToStringException(repository);
		}
	}
	
	public void dumpToFile(RepositoryBean repository, String path) throws CannotDumpRepositoryBeanToFileException {
		try {
			super.dumpToFile(repository, path);
		} catch (CannotDumpBeanToFileException e) {
			throw new CannotDumpRepositoryBeanToFileException(repository, path);
		}
	}
}
