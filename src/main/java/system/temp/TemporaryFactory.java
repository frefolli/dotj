package system.temp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemporaryFactory {
	public static TemporaryFile newFile() throws CannotCreateTemporaryFileException {
		try {
			// TODO: set file permission
			Path path = Files.createTempFile("dotj", "tmp");
			return new TemporaryFile(path.toString());
		} catch (IOException e) {
			throw new CannotCreateTemporaryFileException();
		}
	}

	public static TemporaryDirectory newDirectory() throws CannotCreateTemporaryDirectoryException {
		try {
			// TODO: set directory permission
			Path path = Files.createTempDirectory("dotj");
			return new TemporaryDirectory(path.toString());
		} catch(IOException e) {
			throw new CannotCreateTemporaryDirectoryException();
		}
	}
}