package system.repository;

import java.util.List;

import system.packaging.Package;

public abstract class RemoteRepository {
	protected String url = null;
	
	public RemoteRepository(String url) {
		// TODO
	}
	
	public String getURL() {
		// TODO
		return null;
	}
	
	public abstract List<Package> searchPackages(String name);
	public abstract Package getPackage(String name);
}