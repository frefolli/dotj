package system.main;

import java.util.List;

import system.packaging.Package;
import system.repository.CannotOpenLocalRepository;
import system.repository.CannotSearchPackagesException;
import system.repository.LocalRepository;
import system.repository.RemoteRepositoryFactory;
import system.repository.Repository;

public class LocalSearchPackageJob extends Job {
	private String name = null;
	
	public LocalSearchPackageJob(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		Repository repository;
		try {
			repository = new Repository(
					new LocalRepository("/tmp/"),
					RemoteRepositoryFactory.newHTTP("https://raw.githubusercontent.com/frefolli/dotfiles/master/repository"));
			List<Package> packages = repository.searchPackagesLocally(name);
			for (Package package_ : packages) {
				System.out.println(package_.toString());
			}
		} catch (CannotOpenLocalRepository e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

}
