package system.repository;

public class PackageAlreadyInRepositoryException extends Exception {
	public PackageAlreadyInRepositoryException(String packageName) {
		super(String.format("package \"%s\" already in repository", packageName));
	}
}
