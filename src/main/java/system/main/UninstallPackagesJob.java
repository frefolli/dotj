package system.main;

import java.util.List;

public class UninstallPackagesJob extends Job {
	private List<String> packages = null;
	
	public UninstallPackagesJob(List<String> packages) {
		this.packages = packages;
	}

	@Override
	public void run() {
		// TODO
	}

}
