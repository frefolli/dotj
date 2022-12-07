package system.main;

import java.util.Queue;
import java.util.TreeMap;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import system.packaging.Package;
import system.repository.CannotFindPackageException;
import system.repository.CannotOpenLocalRepository;
import system.repository.Repository;
import system.terminal.CannotCopyFileException;
import system.terminal.Terminal;

public class InstallPackagesJob extends Job {
	private List<String> packages = null;
	
	public InstallPackagesJob(List<String> packages) {
		this.packages = packages;
	}

	@Override
	public void run() {
		Repository repository = null;
		try {
			repository = Repository.getInstance();
			Queue<String> packageQueue = new ArrayDeque<String>(this.packages);
			Map<String, Package> packagesNeeded = new TreeMap<String, Package>();
			while(! packageQueue.isEmpty()) {
				String packageName = packageQueue.poll();
				if ((!packagesNeeded.containsKey(packageName))) {
					Package package_ = repository.getPackage(packageName);
					packagesNeeded.put(packageName, package_);
					System.out.println("requiring: " + package_.toString());
					for (String dependency : package_.getDependencies()) {
						if ((!packagesNeeded.containsKey(dependency)) &&
								(!packageQueue.contains(dependency)))
							packageQueue.add(dependency);
					}
				}
			}
			for (String packageName : packagesNeeded.keySet())
				this.installPackage(packagesNeeded.get(packageName));
			Terminal.getInstance().commitInstall();
		} catch (CannotOpenLocalRepository e) {
			e.printStackTrace();
			System.exit(1);
		} catch (CannotFindPackageException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private void installPackage(Package package_) {
		for (String software : package_.getSoftwares())
			Terminal.getInstance().installSoftware(software);
		String basedir = null;
		try {
			basedir = Repository.getInstance().getPackagePath(package_.getMetadata().getName());
		} catch (CannotOpenLocalRepository e1) {
			return;
		}
		for (String file : package_.getFiles().keySet())
			try {
				Terminal.getInstance().copyFile(
						Path.of(basedir, file).toString(),
						Path.of(package_.getFiles().get(file)).toString());
			} catch (CannotCopyFileException e) {
				return;
			}
	}
}