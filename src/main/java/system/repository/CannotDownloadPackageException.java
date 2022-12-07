package system.repository;

public class CannotDownloadPackageException extends Exception {

	public CannotDownloadPackageException(String url, String name) {
		super(String.format("cannot download package of %s from url %s", name, url));
	}

}
