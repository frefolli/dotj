package system.repository;

import java.util.ArrayList;
import java.util.List;

import system.logging.LocalRepositoryLogger;
import system.packaging.Package;

public class LocalRepository extends Repository {
	private String path;
	private LocalRepositoryLogger logger = null;

	public LocalRepository(String path) {
		this.path = path;
		this.logger = LocalRepositoryLogger.getInstance();
	}

	public List<String> getListOfPackages() {
		return new ArrayList<String>(this.packages.keySet());
	}

	public Package getPackage(String packageName) throws PackageNotFoundException {
		if (this.packages.containsKey(packageName)) {
			return this.packages.get(packageName);
		}
		throw new PackageNotFoundException(packageName);
	}
	
	public void addPackage(Package thePackage) {
			this.packages.put(thePackage.getMetadata().getName(), thePackage);
	}
	
	public void removePackage(String packageName) throws PackageNotFoundException {
		if (this.packages.containsKey(packageName)) {
			this.packages.remove(packageName);
		} else {
			throw new PackageNotFoundException(packageName);
		}
	}
}