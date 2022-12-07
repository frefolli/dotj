package system.repository;

import java.util.List;

import system.packaging.Package;

public abstract class RemoteRepository {
	protected String url = null;
	
	public RemoteRepository(String url) {
		this.url = url;
	}
	
	public String getURL() {
		return this.url;
	}
	
	public abstract List<Package> searchPackages(String name);
	public abstract Package downloadPackage(String name, String downloadDirectory);
}