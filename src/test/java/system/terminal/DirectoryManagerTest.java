package system.terminal;

import static org.junit.Assert.fail;

import java.nio.file.Path;

import org.junit.Test;

import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class DirectoryManagerTest {
	@Test
	public void testDirectory() {
		TemporaryDirectory env = null;
		try {
			env = TemporaryFactory.newDirectory();
		} catch (CannotCreateTemporaryDirectoryException e) {
			fail("should be able to create env temporary directory");
		}
		String directory = Path.of(env.getPath(), "directory1").toString();
		String copyDestination = Path.of(env.getPath(), "directory2").toString();
		String moveDestination = Path.of(env.getPath(), "directory3").toString();
		
		DirectoryManager directoryManager = DirectoryManager.getInstance();
		
		try {
			directoryManager.createDirectory(directory);
		} catch (CannotCreateDirectoryException e) {
			fail("should be able to create directory");
		}
		try {
			directoryManager.copyDirectory(directory, copyDestination);
		} catch (CannotCopyDirectoryException e) {
			fail("should be able to copy directory");
		}
		try {
			directoryManager.moveDirectory(directory, moveDestination);
		} catch (CannotMoveDirectoryException e2) {
			fail("should be able to move directory");
		}
		try {
			directoryManager.deleteDirectory(copyDestination);
		} catch (CannotDeleteDirectoryException e1) {
			fail("should be able to delete directory");
		}
		try {
			directoryManager.deleteDirectory(moveDestination);
		} catch (CannotDeleteDirectoryException e) {
			fail("should be able to delete directory");
		}
		
		try {
			env.clean();
		} catch (CannotCleanTemporaryDirectoryException e) {
			fail("should be able to clean env");
		}
	}
}
