package system.repository;

public class CannotDownloadPackageIndexException extends Exception {

	public CannotDownloadPackageIndexException(String url, String name) {
		super(String.format("cannot download package index of %s from url %s", name, url));
	}

}
