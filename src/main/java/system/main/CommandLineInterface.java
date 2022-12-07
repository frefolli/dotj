package system.main;

import java.util.List;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class CommandLineInterface {
	private ArgumentParser parser = null;
	public CommandLineInterface() {
		this.parser = ArgumentParsers.newFor("dotj").build()
                .defaultHelp(true)
                .description("simple and stupid package manager");
		parser.addArgument("-i", "--install").nargs("+").help("");
		parser.addArgument("-r", "--remove").nargs("+").help("");
		parser.addArgument("-s", "--search").nargs(1).help("");
		parser.addArgument("-S", "--search-locally").nargs(1).help("");
		parser.addArgument("-u", "--update").help("");
	}
	
	public JobQueue parseArgs(String [] args) {
		JobQueue jobQueue = new JobQueue();
		Namespace result = null;
		try {
			result = parser.parseArgs(args);
			
			List<String> install = result.getList("install");
			if (install != null)
				jobQueue.addJob(new InstallPackagesJob(install));
			
			List<String> remove = result.getList("remove");
			if (remove != null)
				jobQueue.addJob(new UninstallPackagesJob(remove));
			
			List<String> search = result.getList("search");
			if (search != null)
				jobQueue.addJob(new SearchPackageJob(search.get(0)));

			List<String> localSearch = result.getList("localSearch");
			if (localSearch != null)
				jobQueue.addJob(new LocalSearchPackageJob(localSearch.get(0)));
		} catch (ArgumentParserException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return jobQueue;
	}
}
