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
		this.metadata = metadata;
		this.dependencies = dependencies;
		this.softwares = softwares;
		this.files = files;
		this.install = install;
		this.uninstall = uninstall;
	}
	
	public PackageMetadata getMetadata() {
		return metadata;
	}
	
	public List<String> getDependencies() {
		return dependencies;
	}
	
	public List<String> getSoftwares() {
		return softwares;
	}
	
	public Map<String, String> getFiles() {
		return files;
	}
	
	public List<String> getInstall() {
		return install;
	}
	
	public List<String> getUninstall() {
		return uninstall;
	}

	@Override
	public String toString() {
		return "(package :metadata" + metadata + " :dependencies" + dependencies + " :softwares" + softwares
				+ ", files=" + files + " :install" + install + " :uninstall" + uninstall + "";
	}
}
