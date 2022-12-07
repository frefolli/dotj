package system.beans;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import system.packaging.Package;

/**
 * this class also act as a Builder
 * */
public class PackageBean implements Bean {
	private PackageMetadataBean metadata = null;
	private List<String> dependencies = null;
	private List<String> softwares = null;
	private Map<String, String> files = null;
	private List<String> install = null;
	private List<String> uninstall = null;
	
	public PackageBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate() throws InvalidPackageBeanException {
		// TODO Auto-generated method stub

	}

	public PackageMetadataBean getMetadata() {
		// TODO Auto-generated method stub
		return this.metadata;
	}

	public List<String> getDependencies() {
		// TODO Auto-generated method stub
		return this.dependencies;
	}

	public List<String> getSoftwares() {
		// TODO Auto-generated method stub
		return this.softwares;
	}

	public Map<String, String> getFiles() {
		// TODO Auto-generated method stub
		return this.files;
	}

	public List<String> getInstall() {
		// TODO Auto-generated method stub
		return this.install;
	}

	public List<String> getUninstall() {
		// TODO Auto-generated method stub
		return this.uninstall;
	}

	public void setMetadata(PackageMetadataBean metadata) {
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

	@Override
	public int hashCode() {
		return Objects.hash(dependencies, files, install, metadata, softwares, uninstall);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PackageBean)) {
			return false;
		}
		PackageBean other = (PackageBean) obj;
		return Objects.equals(dependencies, other.dependencies) && Objects.equals(files, other.files)
				&& Objects.equals(install, other.install) && Objects.equals(metadata, other.metadata)
				&& Objects.equals(softwares, other.softwares) && Objects.equals(uninstall, other.uninstall);
	}
	
	public Package build() {
		return new Package(metadata.build(), dependencies, softwares, files, install, uninstall);
	}
}
