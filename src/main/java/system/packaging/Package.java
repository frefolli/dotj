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
		String ss = String.format("(package :metadata %s", metadata.toString());
		
		if (this.dependencies != null && this.dependencies.size() > 0)
			ss += " :dependencies " + this.dependencies.toString();
		
		if (this.softwares != null && this.softwares.size() > 0)
			ss += " :softwares " + this.softwares.toString();
		
		if (this.files != null && this.files.size() > 0)
			ss += " :files " + this.files.toString();
		
		if (this.install != null && this.install.size() > 0)
			ss += " :install " + this.install.toString();
		
		if (this.uninstall != null && this.uninstall.size() > 0)
			ss += " :uninstall " + this.uninstall.toString();
		
		return ss + ")";
	}
}
