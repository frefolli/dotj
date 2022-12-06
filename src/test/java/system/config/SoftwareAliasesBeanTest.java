package system.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import system.beans.SoftwareAliasesBean;
import system.dumper.CannotDumpSoftwareAliasesBeanToFileException;
import system.dumper.CannotDumpSoftwareAliasesBeanToStringException;
import system.dumper.SoftwareAliasesBeanDumper;
import system.parser.CannotParseSoftwareAliasesBeanFromFileException;
import system.parser.CannotParseSoftwareAliasesBeanFromStringException;
import system.parser.SoftwareAliasesBeanParser;
import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class SoftwareAliasesBeanTest {
	public SoftwareAliasesBean craftBean() {
		Map<String, String> aliases = new TreeMap<String, String>();
		SoftwareAliasesBean bean = new SoftwareAliasesBean();
		bean.setAliases(aliases);
		
		return bean;
	}
	
	@Test
	public void testString() {
		SoftwareAliasesBeanParser parser = SoftwareAliasesBeanParser.getInstance();
		SoftwareAliasesBeanDumper dumper = SoftwareAliasesBeanDumper.getInstance();
		
		SoftwareAliasesBean bean = this.craftBean();
		
		String text = null;
		try {
			text = dumper.dumpToString(bean);
		} catch (CannotDumpSoftwareAliasesBeanToStringException e) {
			fail("should be able to dump to string");
		}
		
		SoftwareAliasesBean other = null;
		try {
			other = parser.parseFromString(text);
		} catch (CannotParseSoftwareAliasesBeanFromStringException e) {
			fail("should be able to load from string");
		}
		
		assertEquals(bean, other);
	}
	
	@Test
	public void testFile() {
		TemporaryDirectory env = null;
		try {
			env = TemporaryFactory.newDirectory();
		} catch (CannotCreateTemporaryDirectoryException e) {
			fail("should be able to create an env");
		}

		SoftwareAliasesBeanParser parser = SoftwareAliasesBeanParser.getInstance();
		SoftwareAliasesBeanDumper dumper = SoftwareAliasesBeanDumper.getInstance();
		
		SoftwareAliasesBean bean = this.craftBean();
		String path = Path.of(env.getPath(), "file.yml").toString();
		try {
			dumper.dumpToFile(bean, path);
		} catch (CannotDumpSoftwareAliasesBeanToFileException e) {
			fail("should be able to dump to file");
		}
		
		SoftwareAliasesBean other = null;
		try {
			other = parser.parseFromFile(path);
		} catch (CannotParseSoftwareAliasesBeanFromFileException e) {
			fail("should be able to load from file");
		}
		
		assertEquals(bean, other);
		
		try {
			env.clean();
		} catch (CannotCleanTemporaryDirectoryException e) {
			fail("should be able to clean the env");
		}
	}
}