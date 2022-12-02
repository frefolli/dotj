package system.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import system.action.Script;
import system.packaging.FilePackage;
import system.packaging.PackageMetadata;
import system.packaging.Package;

public class LocalRepositoryTest {
	public LocalRepository craftSampleLocalRepository() {
		LocalRepository localRepository = new LocalRepository(".");
		return localRepository;
	}
	
	@Test
	public void testConstructor() {
		LocalRepository localRepository = this.craftSampleLocalRepository();
		assertEquals(".", localRepository.getPath());
		assertEquals(0, localRepository.getListOfPackages().size());
	}
	
	Package craftSamplePackage() {
		PackageMetadata metadata = new PackageMetadata("package", "", "", "");
		List<String> dependencies = new ArrayList<String>();
		Script installScript = new Script();
		Script uninstallScript = new Script();
		Map<String, String> files = new TreeMap<String, String>();
		
		FilePackage filePackage = new FilePackage(
				metadata, dependencies, installScript,
				uninstallScript, files);
		return filePackage;
	}

@Test
	public void testGet() {
		LocalRepository localRepository = this.craftSampleLocalRepository();
		Package samplePackage = this.craftSamplePackage();
		try {
			localRepository.getPackage(samplePackage.getMetadata().getName());
			fail("should not be able to get package");
		} catch (PackageNotFoundException e) {}
		
		try {
			localRepository.addPackage(samplePackage);
		} catch (PackageAlreadyInRepositoryException e1) {
			fail("should be able to add package");
		}
		
		try {
			localRepository.getPackage(samplePackage.getMetadata().getName());
		} catch (PackageNotFoundException e) {
			fail("should not be able to get package");
		}
	}
	
	@Test
	public void testAdd() {
		LocalRepository localRepository = this.craftSampleLocalRepository();
		Package samplePackage = this.craftSamplePackage();
		try {
			localRepository.addPackage(samplePackage);
		} catch (PackageAlreadyInRepositoryException e1) {
			fail("should be able to add package");
		}
		
		try {
			localRepository.addPackage(samplePackage);
			fail("should not be able to add package");
		} catch (PackageAlreadyInRepositoryException e) {}
	}
	
	@Test
	public void testRemove() {
		LocalRepository localRepository = this.craftSampleLocalRepository();
		Package samplePackage = this.craftSamplePackage();
		try {
			localRepository.addPackage(samplePackage);
		} catch (PackageAlreadyInRepositoryException e1) {
			fail("should be able to add package");
		}
		
		try {
			localRepository.removePackage(samplePackage);
		} catch (PackageNotFoundException e) {
			fail("should be able to remove package");
		}
		
		try {
			localRepository.removePackage(samplePackage);
			fail("should not be able to remove package");
		} catch (PackageNotFoundException e) {}
	}
}
