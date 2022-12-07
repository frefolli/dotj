package system.main;

import java.util.List;

import system.packaging.Package;
import system.repository.CannotOpenLocalRepository;
import system.repository.CannotSearchPackagesException;
import system.repository.LocalRepository;
import system.repository.RemoteRepositoryFactory;
import system.repository.Repository;

public class SearchPackageJob extends Job {
	private String name = null;
	
	public SearchPackageJob(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		Repository repository;
		try {
			repository = Repository.getInstance();
			List<Package> packages = repository.searchPackages(name);
			for (Package package_ : packages) {
				System.out.println(package_.toString());
			}
		} catch (CannotOpenLocalRepository e) {
			e.printStackTrace();
			System.exit(1);
		} catch (CannotSearchPackagesException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
