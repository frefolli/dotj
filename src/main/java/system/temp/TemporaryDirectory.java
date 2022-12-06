package system.temp;

import system.terminal.CannotDeleteDirectoryException;

public class TemporaryDirectory extends Temporary {
	protected TemporaryDirectory(String path) {
		super(path);
	}

	@Override
	public void clean() throws CannotCleanTemporaryDirectoryException {
		try {
		system.terminal.Terminal.getInstance().deleteDirectory(this.path);
		} catch(CannotDeleteDirectoryException e) {
			throw new CannotCleanTemporaryDirectoryException();
		}
	}
}