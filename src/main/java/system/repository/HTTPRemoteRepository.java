package system.repository;

import java.util.List;

import system.logging.HTTPRemoteRepositoryLogger;
import system.packaging.Package;

public class HTTPRemoteRepository extends RemoteRepository {
	private HTTPRemoteRepositoryLogger logger = null;
	
	public HTTPRemoteRepository(String url) {
		super(url);
		this.logger = HTTPRemoteRepositoryLogger.getInstance();
	}

	public List<String> getListOfPackages() {
		// TODO Auto-generated method stub
		return null;
	}

	public Package getPackage(String packageName) throws PackageNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
}
