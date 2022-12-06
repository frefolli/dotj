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
		
		softwareAliases.save(file.getPath());
		softwareAliases.load(file.getPath());
		
		try {
			file.clean();
		} catch (CannotCleanTemporaryFileException e) {
			fail("should be able to clean the temporary file");
		}
	}
}
