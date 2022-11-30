package system.logging;

import system.repository.RepositoryProxy;

public class RepositoryProxyLogger extends ClassLogger {
	private static RepositoryProxyLogger instance = null;

	private RepositoryProxyLogger() {
		super(RepositoryProxy.class);
	}

	public static RepositoryProxyLogger getInstance() {
		if (RepositoryProxyLogger.instance == null)
			RepositoryProxyLogger.instance  = new RepositoryProxyLogger();
		return RepositoryProxyLogger.instance;
	}
}
