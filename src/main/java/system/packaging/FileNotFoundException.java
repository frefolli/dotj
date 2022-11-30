package system.packaging;

public class FileNotFoundException extends Exception {
	public FileNotFoundException(String fileEntry) {
		super(String.format("file \"%s\" not found in package", fileEntry));
	}
}
