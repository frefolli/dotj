package system.logging;

import system.packaging.SoftwarePackage;

public class SoftwarePackageLogger extends ClassLogger {
	private static SoftwarePackageLogger instance = null;

	private SoftwarePackageLogger() {
		super(SoftwarePackage.class);
	}
	
	public static SoftwarePackageLogger getInstance() {
		if (SoftwarePackageLogger.instance == null)
			SoftwarePackageLogger.instance = new SoftwarePackageLogger();
		return SoftwarePackageLogger.instance;
	}
}