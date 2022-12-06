package system.terminal;

import static org.junit.Assert.fail;

import java.nio.file.Path;

import org.junit.Test;

import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class FileManagerTest {
	@Test
	public void testFileManager() {
		TemporaryDirectory env = null;
		try {
			env = TemporaryFactory.newDirectory();
		} catch (CannotCreateTemporaryDirectoryException e) {
			fail("should be able to create env temporary directory");
		}
		String file = Path.of(env.getPath(), "file1").toString();
		String copyDestination = Path.of(env.getPath(), "file2").toString();
		String moveDestination = Path.of(env.getPath(), "file3").toString();
		
		FileManager fileManager = FileManager.getInstance();
		try {
			fileManager.createFile(file);
		} catch (CannotCreateFileException e1) {
			fail("should be able to create file");
		}
		try {
			fileManager.copyFile(file, copyDestination);
		} catch (CannotCopyFileException e1) {
			fail("should be able to copy file");
		}
		try {
			fileManager.moveFile(file, moveDestination);
		} catch (CannotMoveFileException e1) {
			fail("should be able to move file");
		}
		try {
			fileManager.deleteFile(copyDestination);
		} catch (CannotDeleteFileException e2) {
			fail("should be able to delete file");
		}
		try {
			fileManager.deleteFile(moveDestination);
		} catch (CannotDeleteFileException e1) {
			fail("should be able to delete file");
		}
		
		try {
			env.clean();
		} catch (CannotCleanTemporaryDirectoryException e) {
			fail("should be able to clean env");
		}
	}
}
