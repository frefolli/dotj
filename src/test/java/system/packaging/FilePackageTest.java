package system.packaging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import system.action.Script;

public class FilePackageTest {
	FilePackage craftSampleFilePackage() {
		PackageMetadata metadata = new PackageMetadata("", "", "", "");
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
	public void testConstructor() {
		PackageMetadata metadata = new PackageMetadata("name", "author", "version", "date");
		List<String> dependencies = new ArrayList<String>();
		Script installScript = new Script();
		Script uninstallScript = new Script();
		Map<String, String> files = new TreeMap<String, String>();
		
		FilePackage filePackage = new FilePackage(
				metadata, dependencies, installScript,
				uninstallScript, files);
		
		assertEquals(metadata, filePackage.getMetadata());
		assertEquals(dependencies, filePackage.getDependencies());
		assertEquals(installScript, filePackage.getInstallScript());
		assertEquals(uninstallScript, filePackage.getUninstallScript());
		assertEquals(files, filePackage.getFiles());
	}
	
	@Test
	public void testGetFile() {
		FilePackage filePackage = this.craftSampleFilePackage();
		try {
			filePackage.getFile("random-file");
			fail("should not be able to get file");
		} catch (FileNotFoundException e) {}
		
		try {
			filePackage.addFile("1", "file1");
		} catch (FileAlreadyInPackageException e1) {
			fail("should be able to add file");
		}
		
		try {
			filePackage.getFile("1");
		} catch (FileNotFoundException e) {
			fail("should not be able to get file");
		}
	}
	
	@Test
	public void testAddFile() {
		FilePackage filePackage = this.craftSampleFilePackage();
		try {
			filePackage.addFile("1", "file1");
		} catch (FileAlreadyInPackageException e1) {
			fail("should be able to add file");
		}
		
		try {
			filePackage.addFile("1", "file2");
			fail("should not be able to add file");
		} catch (FileAlreadyInPackageException e) {}
	}
	
	@Test
	public void testRemoveFile() {
		FilePackage filePackage = this.craftSampleFilePackage();
		try {
			filePackage.addFile("1", "file1");
		} catch (FileAlreadyInPackageException e1) {
			fail("should be able to add file");
		}
		
		try {
			filePackage.removeFile("1");
		} catch (FileNotFoundException e) {
			fail("should be able to remove file");
		}
		
		try {
			filePackage.removeFile("1");
			fail("should not be able to remove file");
		} catch (FileNotFoundException e) {}
	}
}
