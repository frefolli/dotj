package system.temp;

import system.terminal.CannotDeleteFileException;

public class TemporaryFile extends Temporary {
	public TemporaryFile(String path) {
		super(path);
	}

	@Override
	public void clean() throws CannotCleanTemporaryFileException {
		try {
			system.terminal.Terminal.getInstance().deleteFile(this.path);
		} catch(CannotDeleteFileException e) {
			throw new CannotCleanTemporaryFileException();
		}
	}
}
