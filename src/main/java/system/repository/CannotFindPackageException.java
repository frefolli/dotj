package system.repository;

public class CannotFindPackageException extends Exception {

	public CannotFindPackageException(String name) {
		super(String.format("cannot find package", name));
	}

}
