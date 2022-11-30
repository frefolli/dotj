package system.repository;

import java.util.List;
import java.util.Map;
import system.packaging.Package;

public abstract class Repository {
	protected Map<String, Package> packages = null;
	
	public abstract List<String> getListOfPackages();
	public abstract Package getPackage(String packageName) throws PackageNotFoundException;
}