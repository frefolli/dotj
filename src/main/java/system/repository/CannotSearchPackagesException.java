package system.repository;

public class CannotSearchPackagesException extends Exception {

	public CannotSearchPackagesException(String url, String name) {
		super(String.format("cannot search packages named \"%s\" from url %s", name, url));
	}

}
