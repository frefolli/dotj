package system.packaging;

import java.util.ArrayList;
import java.util.List;
import system.action.Script;
import system.logging.SoftwarePackageLogger;

public class SoftwarePackage extends Package {
	private List<String> softwares = null;
	private SoftwarePackageLogger logger = null;

	public SoftwarePackage(
			PackageMetadata metadata,
			List<String> dependencies,
			Script installScript,
			Script uninstallScript,
			List<String> softwares) {
		this.metadata = metadata;
		this.dependencies = dependencies;
		this.installScript = installScript;
		this.uninstallScript = uninstallScript;
		this.softwares = softwares;
		this.logger = SoftwarePackageLogger.getInstance();
	}

	@Override
	public PackageMetadata getMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Script getInstallScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Script getUninstallScript() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> getListOfSoftwares() {
		return new ArrayList<String>(this.softwares);
	}
}
