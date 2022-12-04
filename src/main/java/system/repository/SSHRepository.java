package system.repository;

import java.util.List;
import system.packaging.Package;

public class SSHRepository extends RemoteRepository {
	public SSHRepository(String url) {
		super(url);
		// TODO
	}

	@Override
	public List<Package> searchPackages(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Package getPackage(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}