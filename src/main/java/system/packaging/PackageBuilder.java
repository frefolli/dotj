package system.packaging;

import java.util.List;
import java.util.Map;

public class PackageBuilder {
	private PackageMetadata metadata = null;
	private List<String> dependencies = null;
	private List<String> softwares = null;
	private Map<String, String> files = null;
	private List<String> install = null;
	private List<String> uninstall = null;
	
	public PackageBuilder() {}
	
	public void setMetadata(PackageMetadata metadata) {
		this.metadata = metadata;
	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}

	public void setSoftwares(List<String> softwares) {
		this.softwares = softwares;
	}

	public void setFiles(Map<String, String> files) {
		this.files = files;
	}

	public void setInstall(List<String> install) {
		this.install = install;
	}

	public void setUninstall(List<String> uninstall) {
		this.uninstall = uninstall;
	}
	
	public Package build() {
		return new Package(metadata, dependencies, softwares, files, install, uninstall);
	}
}
