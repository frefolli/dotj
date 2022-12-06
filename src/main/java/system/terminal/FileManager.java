package system.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
	private static FileManager instance = null;
	
	public static FileManager getInstance() {
		if (FileManager.instance == null)
			FileManager.instance = new FileManager();
		return FileManager.instance;
	}
	
	public FileManager() {
		// TODO
	}
	
	public void createFile(String file) throws CannotCreateFileException {
		try {
			Files.createFile(Path.of(file));
		} catch (IOException e) {
			throw new CannotCreateFileException(file);
		}
	}
	
	public void deleteFile(String file) throws CannotDeleteFileException {
		try {
			Files.delete(Path.of(file));
		} catch (IOException e) {
			throw new CannotDeleteFileException(file);
		}
	}
	
	public void copyFile(String file, String destination) throws CannotCopyFileException {
		try {
			Files.copy(Path.of(file), Path.of(destination));
		} catch (IOException e) {
			throw new CannotCopyFileException(file, destination);
		}
	}
	
	public void moveFile(String file, String destination) throws CannotMoveFileException {
		try {
			Files.move(Path.of(file), Path.of(destination));
		} catch (IOException e) {
			throw new CannotMoveFileException(file, destination);
		}
	}
}
