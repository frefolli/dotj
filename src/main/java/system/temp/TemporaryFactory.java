package system.temp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class TemporaryFactory {
	private static FileAttribute<Set<PosixFilePermission>> craftFileAttribute() {
		return PosixFilePermissions.asFileAttribute(PosixFilePermissions.fromString("-rwx------"));
	}
	
	public static TemporaryFile newFile() throws CannotCreateTemporaryFileException {
		try {
			FileAttribute<Set<PosixFilePermission>> attr = TemporaryFactory.craftFileAttribute();
			Path path = Files.createTempFile("dotj", "tmp", attr);
			return new TemporaryFile(path.toString());
		} catch (IOException e) {
			throw new CannotCreateTemporaryFileException();
		}
	}

	public static TemporaryDirectory newDirectory() throws CannotCreateTemporaryDirectoryException {
		try {
			FileAttribute<Set<PosixFilePermission>> attr = TemporaryFactory.craftFileAttribute();
			Path path = Files.createTempDirectory("dotj", attr);
			return new TemporaryDirectory(path.toString());
		} catch(IOException e) {
			throw new CannotCreateTemporaryDirectoryException();
		}
	}
}