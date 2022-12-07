package system.repository;

public class CannotOpenLocalRepository extends Exception {

	public CannotOpenLocalRepository(String path) {
		super(String.format("cannot open local repository %s", path));
	}

}
