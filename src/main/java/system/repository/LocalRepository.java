package system.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import system.logging.LocalRepositoryLogger;
import system.packaging.Package;

public class LocalRepository extends Repository {
	private String path;
	private Map<String, Package> packages = null;
	private LocalRepositoryLogger logger = null;

	public LocalRepository(String path) {
		this.path = path;
		this.logger = LocalRepositoryLogger.getInstance();
		this.packages = new TreeMap<String, Package>();
	}

	public List<String> getListOfPackages() {
		return new ArrayList<String>(this.packages.keySet());
	}

	public Package getPackage(String packageName) throws PackageNotFoundException {
		if (this.packages.containsKey(packageName)) {
			return this.packages.get(packageName);
		} else {
			throw new PackageNotFoundException(packageName);
		}
	}
	
	public void addPackage(Package thePackage) throws PackageAlreadyInRepositoryException {
		if (this.packages.containsKey(thePackage.getMetadata().getName())) {
			throw new PackageAlreadyInRepositoryException(thePackage.getMetadata().getName());
		} else {
			this.packages.put(thePackage.getMetadata().getName(), thePackage);
		}
	}
	
	public void removePackage(String packageName) throws PackageNotFoundException {
		if (this.packages.containsKey(packageName)) {
			this.packages.remove(packageName);
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
}