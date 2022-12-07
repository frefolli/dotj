package system.repository;

public class CannotDownloadRepositoryIndexException extends Exception {

	public CannotDownloadRepositoryIndexException(String url) {
		super(String.format("cannot download repository index from url %s", url));
	}

}
