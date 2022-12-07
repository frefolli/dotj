package system.repository;

public class CannotSaveLocalRepositoryIndexFileException extends Exception {

	public CannotSaveLocalRepositoryIndexFileException(String indexFilePath) {
		super(String.format("cannot save local repository index file %s", indexFilePath));
	}

}
