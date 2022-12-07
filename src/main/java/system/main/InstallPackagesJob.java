package system.main;

import java.util.Queue;
import java.util.TreeMap;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import system.packaging.Package;
import system.repository.CannotFindPackageException;
import system.repository.CannotOpenLocalRepository;
import system.repository.Repository;

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
		} catch (CannotOpenLocalRepository e) {
			e.printStackTrace();
			System.exit(1);
		} catch (CannotFindPackageException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}