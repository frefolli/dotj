package system.repository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import system.beans.RepositoryIndex;
import system.cli.CLI;
import system.logging.LocalRepositoryLogger;
import system.packaging.Package;

public class LocalRepository extends Repository {
	private String path;
	private Map<String, Package> packageCache = null;
	private List<String> listOfPackages = null;
	private LocalRepositoryLogger logger = null;

	public LocalRepository(String path) {
		this.path = path;
		this.logger = LocalRepositoryLogger.getInstance();
		this.packageCache = new TreeMap<>();
		this.loadListOfPackages();
	}
	
	private void loadListOfPackages() {
        if (this.existsYaml()) {
    		system.yaml.RepositoryIndexParser yamlParser = system.yaml.RepositoryIndexParser.getInstance();
    		system.beans.RepositoryIndex repositoryIndex = yamlParser.readFromFile(String.format("%s/index.yml", path));
    		this.listOfPackages = repositoryIndex.getPackages();
        } else {
        	this.createYaml();
        	this.loadListOfPackages();
        }
	}
	
	private String getIndexPath() {
		return Paths.get(this.path, "index.yml").toString();
	}
	
	private boolean existsYaml() {
		File yamlFile = new File(this.getIndexPath());
		return yamlFile.exists();
	}
	
	private void createYaml() {
		File yamlFile = new File(this.getIndexPath());
		try {
			yamlFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> getListOfPackages() {
		return new ArrayList<>(this.listOfPackages);
	}

	public Package getPackage(String packageName) throws PackageNotFoundException {
		if (this.packageCache.containsKey(packageName)) {
			return this.packageCache.get(packageName);
		} else {
			throw new PackageNotFoundException(packageName);
		}
	}
	
	public void addPackage(Package thePackage) throws PackageAlreadyInRepositoryException {
		if (this.packageCache.containsKey(thePackage.getMetadata().getName())) {
			throw new PackageAlreadyInRepositoryException(thePackage.getMetadata().getName());
		} else {
			this.packageCache.put(thePackage.getMetadata().getName(), thePackage);
		}
	}
	
	public void removePackage(String packageName) throws PackageNotFoundException {
		if (this.packageCache.containsKey(packageName)) {
			this.packageCache.remove(packageName);
		} else {
			throw new PackageNotFoundException(packageName);
		}
	}
	
	public void removePackage(Package thePackage) throws PackageNotFoundException {
		this.removePackage(thePackage.getMetadata().getName());
	}
	
	public String getPath() {
		return this.path;
	}
	
	public String toString() {
		return String.format("(local-repository '(%s))", String.join(" ", this.listOfPackages));
	}
}