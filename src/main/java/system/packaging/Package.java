package system.packaging;

import java.util.List;
import java.util.Map;

public class Package {
	private PackageMetadata metadata = null;
	private List<String> dependencies = null;
	private List<String> softwares = null;
	private Map<String, String> files = null;
	private List<String> install = null;
	private List<String> uninstall = null;

	public Package(PackageMetadata metadata, List<String> dependencies, List<String> softwares,
			Map<String, String> files, List<String> install, List<String> uninstall) {
		// TODO
	}

	public PackageMetadata getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getDependencies() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getSoftwares() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> getFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getInstall() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUninstall() {
		// TODO Auto-generated method stub
		return null;
	}
}
