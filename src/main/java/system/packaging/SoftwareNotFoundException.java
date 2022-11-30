package system.packaging;

public class SoftwareNotFoundException extends Exception {
	public SoftwareNotFoundException(String software) {
		super(String.format("software \"%s\" not found in package", software));
	}
}
