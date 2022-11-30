package system.logging;

import system.repository.LocalRepository;

public class LocalRepositoryLogger extends ClassLogger {
	private static LocalRepositoryLogger instance = null;
	private LocalRepositoryLogger() {
		super(LocalRepository.class);
	}

	public static LocalRepositoryLogger getInstance() {
		if (LocalRepositoryLogger.instance == null)
			LocalRepositoryLogger.instance = new LocalRepositoryLogger();
		return LocalRepositoryLogger.instance;
	}
}
