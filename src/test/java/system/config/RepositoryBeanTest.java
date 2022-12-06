package system.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import system.beans.RepositoryBean;
import system.dumper.CannotDumpRepositoryBeanToFileException;
import system.dumper.CannotDumpRepositoryBeanToStringException;
import system.dumper.RepositoryBeanDumper;
import system.parser.CannotParseRepositoryBeanFromFileException;
import system.parser.CannotParseRepositoryBeanFromStringException;
import system.parser.RepositoryBeanParser;
import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class RepositoryBeanTest {
	public RepositoryBean craftBean() {
		List<String> packages = new ArrayList<String>();
		RepositoryBean bean = new RepositoryBean();
		bean.setPackages(packages);
		
		return bean;
	}
	
	@Test
	public void testString() {
		RepositoryBeanParser parser = RepositoryBeanParser.getInstance();
		RepositoryBeanDumper dumper = RepositoryBeanDumper.getInstance();
		
		RepositoryBean bean = this.craftBean();
		String text = null;
		try {
			text = dumper.dumpToString(bean);
		} catch (CannotDumpRepositoryBeanToStringException e) {
			fail("should be able to dump to string");
		}
		
		RepositoryBean other = null;
		try {
			other = parser.parseFromString(text);
		} catch (CannotParseRepositoryBeanFromStringException e) {
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
		
		RepositoryBeanParser parser = RepositoryBeanParser.getInstance();
		RepositoryBeanDumper dumper = RepositoryBeanDumper.getInstance();

		RepositoryBean bean = this.craftBean();
		String path = Path.of(env.getPath(), "file.yml").toString();
		try {
		    dumper.dumpToFile(bean, path);
		} catch (CannotDumpRepositoryBeanToFileException e) {
		    fail("should be able to dump to file");
		}

		RepositoryBean other = null;
		try {
		    other = parser.parseFromFile(path);
		} catch (CannotParseRepositoryBeanFromFileException e) {
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
