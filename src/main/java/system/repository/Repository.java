package system.repository;

import java.util.List;
import system.packaging.Package;
import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

/* This class acts like a Proxy
 * */
public class Repository {
	LocalRepository localRepository = null;
	RemoteRepository remoteRepository = null;
	
	public Repository(LocalRepository localRepository, RemoteRepository remoteRepository) {
		this.localRepository = localRepository;
		this.remoteRepository = remoteRepository;
	}
	
	public List<Package> searchPackages(String name) throws CannotSearchPackagesException {
		return this.remoteRepository.searchPackages(name);
	}
	
	public List<Package> searchPackagesLocally(String name) {
		return this.localRepository.searchPackages(name);
	}
	
	public Package getPackage(String name) throws CannotFindPackageException {
		Package package_ = null;
		try {
			package_ = this.localRepository.getPackage(name);
		} catch (CannotFindPackageException e) {
			TemporaryDirectory env = null;
			try {
				env = TemporaryFactory.newDirectory();
			} catch (CannotCreateTemporaryDirectoryException e1) {
				return null;
			}
			
			try {
				package_ = this.remoteRepository.downloadPackage(name, env.getPath());
			} catch (CannotDownloadPackageException e2) {
				throw new CannotFindPackageException(name);
			}
			
			try {
				this.localRepository.addPackage(package_, String.format("%s/%s", env.getPath(), name));
			} catch (CannotCopyPackageException e1) {
				// TODO
			} catch (CannotAddPackageToLocalRepositoryIndexFileException e1) {
				// TODO
			}
			
			try {
				env.clean();
			} catch (CannotCleanTemporaryDirectoryException e1) {
				return null;
			}
		}
		return package_;
	}
	
	public void cleanCache() throws CannotCleanCacheException {
		this.localRepository.cleanCache();
	}
}