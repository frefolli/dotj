package system.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import system.action.Script;
import system.logging.HTTPRemoteRepositoryLogger;
import system.packaging.FilePackage;
import system.packaging.Package;
import system.packaging.PackageMetadata;

public class HTTPRemoteRepository extends RemoteRepository {
	private HTTPRemoteRepositoryLogger logger = null;
	
	public HTTPRemoteRepository(String url) {
		super(url);
		this.logger = HTTPRemoteRepositoryLogger.getInstance();
	}

	public List<String> getListOfPackages() {
		return new ArrayList<>();
	}

	public Package getPackage(String packageName) throws PackageNotFoundException {
		PackageMetadata metadata = new PackageMetadata(packageName, "", "", "");
		List<String> dependencies = new ArrayList<>();
		Script installScript = new Script();
		Script uninstallScript = new Script();
		Map<String, String> files = new TreeMap<>();
		
		return new FilePackage(
				metadata, dependencies, installScript,
				uninstallScript, files);
	}
}
