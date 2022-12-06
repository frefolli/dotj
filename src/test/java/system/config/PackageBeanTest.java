package system.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import system.beans.PackageBean;
import system.beans.PackageMetadataBean;
import system.dumper.CannotDumpPackageBeanToFileException;
import system.dumper.CannotDumpPackageBeanToStringException;
import system.dumper.PackageBeanDumper;
import system.parser.CannotParsePackageBeanFromFileException;
import system.parser.CannotParsePackageBeanFromStringException;
import system.parser.PackageBeanParser;
import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class PackageBeanTest {
	public PackageBean craftBean() {
		PackageMetadataBean metadata = new PackageMetadataBean();
		metadata.setName("1");
		metadata.setAuthor("2");
		metadata.setVersion("3");
		metadata.setDate("4");
		
		List<String> dependencies = new ArrayList<String>();
		List<String> softwares = new ArrayList<String>();
		Map<String, String> files = new TreeMap<String, String>();
		List<String> install = new ArrayList<String>();
		List<String> uninstall = new ArrayList<String>();
		
		PackageBean bean = new PackageBean();
		bean.setMetadata(metadata);
		bean.setDependencies(dependencies);
		bean.setSoftwares(softwares);
		bean.setFiles(files);
		bean.setInstall(install);
		bean.setUninstall(uninstall);
		
		return bean;
	}
	
	@Test
	public void testString() {
		PackageBeanParser parser = PackageBeanParser.getInstance();
		PackageBeanDumper dumper = PackageBeanDumper.getInstance();
		
		PackageBean bean = this.craftBean();
		String text = null;
		try {
			text = dumper.dumpToString(bean);
		} catch (CannotDumpPackageBeanToStringException e) {
			fail("should be able to dump to string");
		}
		
		PackageBean other = null;
		try {
			other = parser.parseFromString(text);
		} catch (CannotParsePackageBeanFromStringException e) {
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
		
		PackageBeanParser parser = PackageBeanParser.getInstance();
		PackageBeanDumper dumper = PackageBeanDumper.getInstance();

		PackageBean bean = this.craftBean();
		String path = Path.of(env.getPath(), "file.yml").toString();
		try {
		    dumper.dumpToFile(bean, path);
		} catch (CannotDumpPackageBeanToFileException e) {
		    fail("should be able to dump to file");
		}

		PackageBean other = null;
		try {
		    other = parser.parseFromFile(path);
		} catch (CannotParsePackageBeanFromFileException e) {
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
