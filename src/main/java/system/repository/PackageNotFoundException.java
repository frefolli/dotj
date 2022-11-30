package system.repository;

public class PackageNotFoundException extends Exception {
	public PackageNotFoundException(String packageName) {
		super(String.format("package \"%s\" is not in repository", packageName));
	}

}
