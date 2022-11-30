package system.packaging;

import java.util.List;

import system.action.Script;

public abstract class Package {
	protected PackageMetadata metadata = null;
	protected List<String> dependencies = null;
	protected Script installScript = null;
	protected Script uninstallScript = null;
	
	public PackageMetadata getMetadata() {
		return this.metadata;
	}
	
	public List<String> getDependencies() {
		return this.dependencies;
	}
	
	public Script getInstallScript() {
		return this.installScript;
	}
	
	public Script getUninstallScript() {
		return this.uninstallScript;
	}
}