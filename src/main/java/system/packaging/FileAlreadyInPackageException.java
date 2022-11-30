package system.packaging;

public class FileAlreadyInPackageException extends Exception {
	public FileAlreadyInPackageException(String fileEntry) {
		super(String.format("file \"%s\" already in package", fileEntry));
	}
}
