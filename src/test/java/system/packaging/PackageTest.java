package system.packaging;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class PackageTest {
	@Test
	public void test() {
		String name = "";
		String author = "";
		String date = "";
		String version = "";
		PackageMetadata metadata = new PackageMetadata(name, author, date, version);
		List<String> dependencies = new ArrayList<String>();
		List<String> softwares = new ArrayList<String>();
		Map<String, String> files = new TreeMap<String, String>();
		List<String> install = new ArrayList<String>();
		List<String> uninstall = new ArrayList<String>();
		Package package_ = new Package(metadata, dependencies, softwares, files, install, uninstall);
		
		assertEquals(metadata, package_.equals(package_));
		assertEquals(dependencies, package_.getDependencies());
		assertEquals(softwares, package_.getSoftwares());
		assertEquals(files, package_.getFiles());
		assertEquals(install, package_.getInstall());
		assertEquals(uninstall, package_.getUninstall());
	}
}
