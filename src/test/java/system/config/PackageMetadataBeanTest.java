package system.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.nio.file.Path;

import org.junit.Test;

import system.beans.PackageMetadataBean;
import system.dumper.CannotDumpPackageMetadataBeanToFileException;
import system.dumper.CannotDumpPackageMetadataBeanToStringException;
import system.dumper.PackageMetadataBeanDumper;
import system.parser.CannotParsePackageMetadataBeanFromFileException;
import system.parser.CannotParsePackageMetadataBeanFromStringException;
import system.parser.PackageMetadataBeanParser;
import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class PackageMetadataBeanTest {
	public PackageMetadataBean craftBean() {
		PackageMetadataBean bean = new PackageMetadataBean();
		bean.setName("1");
		bean.setAuthor("2");
		bean.setVersion("3");
		bean.setDate("4");
		
		return bean;
	}
	
	@Test
	public void testString() {
		PackageMetadataBeanParser parser = PackageMetadataBeanParser.getInstance();
		PackageMetadataBeanDumper dumper = PackageMetadataBeanDumper.getInstance();
		
		PackageMetadataBean bean = this.craftBean();
		
		String text = null;
		try {
			text = dumper.dumpToString(bean);
		} catch (CannotDumpPackageMetadataBeanToStringException e) {
			fail("should be able to dump to string");
		}
		
		PackageMetadataBean other = null;
		try {
			other = parser.parseFromString(text);
		} catch (CannotParsePackageMetadataBeanFromStringException e) {
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
		
		PackageMetadataBeanParser parser = PackageMetadataBeanParser.getInstance();
		PackageMetadataBeanDumper dumper = PackageMetadataBeanDumper.getInstance();

		PackageMetadataBean bean = this.craftBean();
		String path = Path.of(env.getPath(), "file.yml").toString();
		try {
		    dumper.dumpToFile(bean, path);
		} catch (CannotDumpPackageMetadataBeanToFileException e) {
		    fail("should be able to dump to file");
		}

		PackageMetadataBean other = null;
		try {
		    other = parser.parseFromFile(path);
		} catch (CannotParsePackageMetadataBeanFromFileException e) {
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
