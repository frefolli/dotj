package system.terminal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;

public class DirectoryManager {
	private static DirectoryManager instance = null;
	
	public static DirectoryManager getInstance() {
		if (DirectoryManager.instance == null)
			DirectoryManager.instance = new DirectoryManager();
		return DirectoryManager.instance;
	}
	
	public DirectoryManager() {
		// TODO
	}
	
	public void createDirectory(String directory) throws CannotCreateDirectoryException {
		try {
			Files.createDirectory(Path.of(directory));
		} catch(IOException e) {
			throw new CannotCreateDirectoryException(directory);
		}
	}
	
	/*
	 * this function deletes directory and all its content
	 * */
	public void deleteDirectory(String directory) throws CannotDeleteDirectoryException {
		try {
			FileUtils.deleteDirectory(new File(Path.of(directory).toString()));
		} catch(IOException e) {
			throw new CannotDeleteDirectoryException(directory);
		}
	}
	
	public void copyDirectory(String directory, String destination) throws CannotCopyDirectoryException {
		try {
			Files.copy(Path.of(directory), Path.of(destination));
		} catch(IOException e) {
			throw new CannotCopyDirectoryException(directory, destination);
		}
	}
	
	public void moveDirectory(String directory, String destination) throws CannotMoveDirectoryException {
		try {
			Files.move(Path.of(directory), Path.of(destination));
		} catch(IOException e) {
			throw new CannotMoveDirectoryException(directory, destination);
		}
	}
}