package system.repository;

import java.util.List;
import system.packaging.Package;

/* This class acts like a Proxy
 * */
public class Repository {
	LocalRepository localRepository = null;
	RemoteRepository remoteRepository = null;
	
	public Repository(LocalRepository localRepository, RemoteRepository remoteRepository) {
		this.localRepository = localRepository;
		this.remoteRepository = remoteRepository;
	}
	
	public List<Package> searchPackages(String name) {
		return this.remoteRepository.searchPackages(name);
	}
	
	public List<Package> searchPackagesLocally(String name) {
		return this.localRepository.searchPackages(name);
	}
	
	public Package getPackage(String name) {
		Package package_ = null;
		package_ = this.localRepository.getPackage(name);
		return package_;
	}
	
	public void cleanCache() {
		this.localRepository.cleanCache();
	}
}