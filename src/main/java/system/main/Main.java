package system.main;

import java.util.List;

import system.repository.CannotOpenLocalRepository;
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
			List<Package> packages = repository.searchPackages("vim");
			System.out.println(packages.toString());
		} catch (CannotOpenLocalRepository e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}