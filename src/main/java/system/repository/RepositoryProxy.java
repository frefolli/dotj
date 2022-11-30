package system.repository;

import java.util.List;

import system.logging.RepositoryProxyLogger;
import system.packaging.Package;

public class RepositoryProxy extends Repository {
	private LocalRepository localRepository = null;
	private RemoteRepository remoteRepository = null;
	private RepositoryProxyLogger logger = null;

	public RepositoryProxy(
			LocalRepository localRepository,
			RemoteRepository remoteRepository) {
		this.localRepository = localRepository;
		this.remoteRepository = remoteRepository;
		this.logger = RepositoryProxyLogger.getInstance();
	}

	public List<String> getListOfPackages() {
		return this.localRepository.getListOfPackages();
	}

	public Package getPackage(String packageName) throws PackageNotFoundException {
		Package thePackage = null;
		try {
			thePackage = this.localRepository.getPackage(packageName);
		} catch (PackageNotFoundException error) {
			thePackage = this.remoteRepository.getPackage(packageName);
			this.localRepository.addPackage(thePackage);
		}
		return thePackage;
	}
}
