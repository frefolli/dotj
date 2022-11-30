package system.packaging;

import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import system.action.Script;
import system.logging.FilePackageLogger;

public class FilePackage extends Package {
	private Map<String, String> files = null;
	private FilePackageLogger logger = null;

	public FilePackage(
			PackageMetadata metadata,
			List<String> dependencies,
			Script installScript,
			Script uninstallScript,
			Map<String, String> files) {
		this.metadata = metadata;
		this.dependencies = dependencies;
		this.installScript = installScript;
		this.uninstallScript = uninstallScript;
		this.files = files;
		this.logger  = FilePackageLogger.getInstance();
	}

	public Map<String, String> getFiles() {
		return new TreeMap<String, String>(this.files);
	}
	
	public String getFile(String fileEntry) throws FileNotFoundException {
		if (this.files.containsKey(fileEntry)) {
			return this.files.get(fileEntry);
		} else {
			throw new FileNotFoundException(fileEntry);
		}
	}
	
	public void addFile(String fileEntry, String fileDestination) throws FileAlreadyInPackageException {
		if (this.files.containsKey(fileEntry)) {
			throw new FileAlreadyInPackageException(fileEntry);
		} else {
			this.files.put(fileEntry, fileDestination);
		}
	}
	
	public void removeFile(String fileEntry) throws FileNotFoundException {
		if (this.files.containsKey(fileEntry)) {
			this.files.remove(fileEntry);
		} else {
			throw new FileNotFoundException(fileEntry);
		}
	}
}
