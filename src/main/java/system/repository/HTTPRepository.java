package system.repository;

import java.util.List;
import system.packaging.Package;

public class HTTPRepository extends RemoteRepository {
	public HTTPRepository(String url) {
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