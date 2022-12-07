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
		CommandLineInterface cli = new CommandLineInterface();
		cli.parseArgs(args).run();
	}
}