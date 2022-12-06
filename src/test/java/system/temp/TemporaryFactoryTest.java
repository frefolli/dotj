package system.temp;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertFalse;

import system.temp.TemporaryFactory;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFile;

public class TemporaryFactoryTest {
	@Test
	public void testNewFile() {
		TemporaryFile file = null;
		try {
			file = TemporaryFactory.newFile();
		} catch(CannotCreateTemporaryFileException error) {
			fail("should be able to create a temporary file");
		}
		assertTrue(Files.exists(Path.of(file.getPath())));
		
		try {
			file.clean();
		} catch (CannotCleanTemporaryFileException e) {
			fail("should be able to clean the temporary file");
		}
		
		assertFalse(Files.exists(Path.of(file.getPath())));
	}
	
	@Test
	public void testNewDirectory() {
		TemporaryDirectory directory = null;
		try {
			directory = TemporaryFactory.newDirectory();
		} catch(CannotCreateTemporaryDirectoryException error) {
			fail("should be able to create a temporary directory");
		}
		assertTrue(Files.exists(Path.of(directory.getPath())));
		
		try {
			directory.clean();
		} catch (CannotCleanTemporaryDirectoryException e) {
			fail("should be able to clean the temporary directory");
		}
		
		assertFalse(Files.exists(Path.of(directory.getPath())));
	}
}