package system.beans;

import java.util.List;
import java.util.Map;

public class PackageBean extends Bean {
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
	public void validate() {
		// TODO Auto-generated method stub

	}

	public PackageMetadataBean getMetadata() {
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

	public void setMetadata(PackageMetadataBean metadata) {
		// TODO Auto-generated method stub
	}

	public void setDependencies(List<String> dependencies) {
		// TODO Auto-generated method stub
	}

	public void setSoftwares(List<String> softwares) {
		// TODO Auto-generated method stub
	}

	public void setFiles(Map<String, String> files) {
		// TODO Auto-generated method stub
	}

	public void setInstall(List<String> install) {
		// TODO Auto-generated method stub
	}

	public void setUninstall(List<String> uninstall) {
		// TODO Auto-generated method stub
	}
}
