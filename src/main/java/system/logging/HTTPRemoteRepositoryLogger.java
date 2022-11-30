package system.logging;

import system.repository.HTTPRemoteRepository;

public class HTTPRemoteRepositoryLogger extends ClassLogger {
	private static HTTPRemoteRepositoryLogger instance = null;

	private HTTPRemoteRepositoryLogger() {
		super(HTTPRemoteRepository.class);
	}
	
	public static HTTPRemoteRepositoryLogger getInstance() {
		if (HTTPRemoteRepositoryLogger.instance == null)
			HTTPRemoteRepositoryLogger.instance = new HTTPRemoteRepositoryLogger();
		return HTTPRemoteRepositoryLogger.instance;
	}
}