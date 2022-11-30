package system.packaging;

public class SoftwareAlreadyInPackageException extends Exception {
	public SoftwareAlreadyInPackageException(String software) {
		super(String.format("software \"%s\" already in package", software));
	}
}
