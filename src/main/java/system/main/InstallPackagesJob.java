package system.main;

import java.util.List;

public class InstallPackagesJob extends Job {
	private List<String> packages = null;
	
	public InstallPackagesJob(List<String> packages) {
		this.packages = packages;
	}

	@Override
	public void run() {
		// TODO
	}
}