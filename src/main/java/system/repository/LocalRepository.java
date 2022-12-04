package system.repository;

import java.util.List;
import java.util.Map;

import system.packaging.Package;

public class LocalRepository {
	private Map<String, Package> cache = null;
	
	public LocalRepository(String path) {
		// TODO Auto-generated constructor stub
	}
	
	public List<Package> searchPackages(String name) {
		// TODO
		return null;
	}
	
	public Package getPackage(String name) {
		// TODO
		return null;
	}
	
	public void cachePackage(Package freshPackage) {
		// TODO
	}
	
	public void cleanCache() {
		// TODO
	}
}
