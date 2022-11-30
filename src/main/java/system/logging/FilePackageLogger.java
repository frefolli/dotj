package system.logging;

import system.packaging.FilePackage;

public class FilePackageLogger extends ClassLogger {
	private static FilePackageLogger instance = null;

	private FilePackageLogger() {
		super(FilePackage.class);
	}
	
	public static FilePackageLogger getInstance() {
		if (FilePackageLogger.instance == null)
			FilePackageLogger.instance = new FilePackageLogger();
		return FilePackageLogger.instance;
	}
}