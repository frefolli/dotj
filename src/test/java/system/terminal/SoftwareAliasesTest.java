package system.terminal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import system.temp.CannotCleanTemporaryFileException;
import system.temp.CannotCreateTemporaryFileException;
import system.temp.TemporaryFactory;
import system.temp.TemporaryFile;

public class SoftwareAliasesTest {
	@Test
	public void testSoftwareAliases() {
		SoftwareAliases softwareAliases = new SoftwareAliases();
		softwareAliases.addAlias("A", "B");
		assertEquals("B", softwareAliases.getAlias("A"));
		softwareAliases.removeAlias("A");
		assertEquals(new ArrayList<String>(), softwareAliases.getListOfAliases());
		
		TemporaryFile file = null;
		try {
			file = TemporaryFactory.newFile();
		} catch (CannotCreateTemporaryFileException e) {
			fail("should be able to create a temporary file");
		}
		
		try {
			softwareAliases.save(file.getPath());
		} catch (CannotDumpSoftwareAliasesToFileException e1) {
			fail("should be able to dump itself");
		}
		try {
			softwareAliases.load(file.getPath());
		} catch (CannotLoadSoftwareAliasesFromFileException e1) {
			fail("should be able to load itself");
		}
		
		try {
			file.clean();
		} catch (CannotCleanTemporaryFileException e) {
			fail("should be able to clean the temporary file");
		}
	}
}
