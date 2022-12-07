package system.main;

import java.util.List;

import system.repository.CannotOpenLocalRepository;
import system.repository.CannotSearchPackagesException;
import system.repository.LocalRepository;
import system.repository.RemoteRepositoryFactory;
import system.repository.Repository;
import system.packaging.Package;

public class Main {
	public static void main(String [] args) {
		Repository repository;
		try {
			repository = new Repository(
					new LocalRepository("/tmp/"),
					RemoteRepositoryFactory.newHTTP("https://raw.githubusercontent.com/frefolli/dotfiles/master/repository"));
			List<Package> packages = repository.searchPackages(args[0]);
			for (Package package_ : packages) {
				System.out.println(package_.toString());
			}
		} catch (CannotOpenLocalRepository e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotSearchPackagesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}