package system.repository;

import java.util.List;
import system.packaging.Package;

public class Repository {
	LocalRepository localRepository = null;
	RemoteRepository remoteRepository = null;
	
	public Repository(LocalRepository localRepository, RemoteRepository remoteRepository) {
		// TODO
	}
	
	public List<Package> searchPackages(String name) {
		// TODO
		return null;
	}
	
	public List<Package> searchPackagesLocally(String name) {
		// TODO
		return null;
	}
	
	public Package getPackage(String name) {
		// TODO
		return null;
	}
	
	public void cleanCache() {
		// TODO
	}
}