package system.packaging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import system.action.Script;

public class SoftwarePackageTest {

	SoftwarePackage craftSampleSoftwarePackage() {
		PackageMetadata metadata = new PackageMetadata("", "", "", "");
		List<String> dependencies = new ArrayList<String>();
		Script installScript = new Script();
		Script uninstallScript = new Script();
		List<String> softwares = new ArrayList<String>();
		
		SoftwarePackage softwarePackage = new SoftwarePackage(
				metadata, dependencies, installScript,
				uninstallScript, softwares);
		return softwarePackage;
	}
	
	@Test
	public void testConstructor() {
		PackageMetadata metadata = new PackageMetadata("name", "author", "version", "date");
		List<String> dependencies = new ArrayList<String>();
		Script installScript = new Script();
		Script uninstallScript = new Script();
		List<String> softwares = new ArrayList<String>();
		
		SoftwarePackage softwarePackage = new SoftwarePackage(
				metadata, dependencies, installScript,
				uninstallScript, softwares);
		
		assertEquals(softwarePackage.getMetadata(), metadata);
		assertEquals(softwarePackage.getDependencies(), dependencies);
		assertEquals(softwarePackage.getInstallScript(), installScript);
		assertEquals(softwarePackage.getUninstallScript(), uninstallScript);
		assertEquals(softwarePackage.getListOfSoftwares(), softwares);
	}
	
	@Test
	public void testGet() {
		SoftwarePackage softwarePackage = this.craftSampleSoftwarePackage();
		try {
			softwarePackage.append("1");
		} catch (SoftwareAlreadyInPackageException e) {
			fail("should be able to add software to package");
		}
		assertEquals("1", softwarePackage.get(0));
	}
	
	@Test
	public void testAppend() {
		SoftwarePackage softwarePackage = this.craftSampleSoftwarePackage();
		try {
			softwarePackage.append("1");
		} catch (SoftwareAlreadyInPackageException e) {
			fail("should be able to add software to package");
		}
		
		try {
			softwarePackage.append("1");
			fail("should not be able to add software to package");
		} catch (SoftwareAlreadyInPackageException e) {}
	}
	
	@Test
	public void testRemove() {
		SoftwarePackage softwarePackage = this.craftSampleSoftwarePackage();
		try {
			softwarePackage.append("1");
		} catch (SoftwareAlreadyInPackageException e) {
			fail("should be able to add software to package");
		}
		
		try {
			softwarePackage.remove("1");
		} catch (SoftwareNotFoundException e) {
			fail("should be able to remove software to package");
		}
		
		try {
			softwarePackage.remove("1");
			fail("should not be able to remove software to package");
		} catch (SoftwareNotFoundException e) {}
	}
}
