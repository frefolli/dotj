package system.terminal;

import static org.junit.Assert.fail;

import java.nio.file.Path;

import org.junit.Test;

import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class TerminalTest {
	@Test
	public void testFile() {
		TemporaryDirectory env = null;
		try {
			env = TemporaryFactory.newDirectory();
		} catch (CannotCreateTemporaryDirectoryException e) {
			fail("should be able to create env temporary directory");
		}
		String file = Path.of(env.getPath(), "file1").toString();
		String copyDestination = Path.of(env.getPath(), "file2").toString();
		String moveDestination = Path.of(env.getPath(), "file3").toString();
		
		Terminal terminal = Terminal.getInstance();
		try {
			terminal.createFile(file);
		} catch (CannotCreateFileException e1) {
			fail("should be able to create file");
		}
		try {
			terminal.copyFile(file, copyDestination);
		} catch (CannotCopyFileException e1) {
			fail("should be able to copy file");
		}
		try {
			terminal.moveFile(file, moveDestination);
		} catch (CannotMoveFileException e1) {
			fail("should be able to move file");
		}
		try {
			terminal.deleteFile(copyDestination);
		} catch (CannotDeleteFileException e2) {
			fail("should be able to delete file");
		}
		try {
			terminal.deleteFile(moveDestination);
		} catch (CannotDeleteFileException e1) {
			fail("should be able to delete file");
		}
		
		try {
			env.clean();
		} catch (CannotCleanTemporaryDirectoryException e) {
			fail("should be able to clean env");
		}
	}

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
		
		Terminal terminal = Terminal.getInstance();
		
		try {
			terminal.createDirectory(directory);
		} catch (CannotCreateDirectoryException e) {
			fail("should be able to create directory");
		}
		try {
			terminal.copyDirectory(directory, copyDestination);
		} catch (CannotCopyDirectoryException e) {
			fail("should be able to copy directory");
		}
		try {
			terminal.moveDirectory(directory, moveDestination);
		} catch (CannotMoveDirectoryException e2) {
			fail("should be able to move directory");
		}
		try {
			terminal.deleteDirectory(copyDestination);
		} catch (CannotDeleteDirectoryException e1) {
			fail("should be able to delete directory");
		}
		try {
			terminal.deleteDirectory(moveDestination);
		} catch (CannotDeleteDirectoryException e) {
			fail("should be able to delete directory");
		}
		
		try {
			env.clean();
		} catch (CannotCleanTemporaryDirectoryException e) {
			fail("should be able to clean env");
		}
	}
	
	@Test
	public void testSoftware() {
		// TODO
	}
}
