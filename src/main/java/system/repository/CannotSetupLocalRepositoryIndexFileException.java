package system.repository;

public class CannotSetupLocalRepositoryIndexFileException extends Exception {

	public CannotSetupLocalRepositoryIndexFileException(String indexFilePath) {
		super(String.format("cannot setup local repository index file %s", indexFilePath));
	}

}
