package system.cli;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import system.beans.RepositoryIndex;
import system.beans.GenericPackageIndex;
import java.io.File;
import system.repository.LocalRepository;

public class CLI {
    public static void main(String[] args) {
    	ArgumentParser argumentParser = CLI.addArguments(CLI.buildNewArgumentParser("dotj"));
    	
        Namespace result = null;
        try {
        	result = argumentParser.parseArgs(args);
        } catch(ArgumentParserException error) {
        	argumentParser.handleError(error);
            System.exit(1);
        }
        
        LocalRepository localRepository = new LocalRepository(result.getString("repository"));
        System.out.println(localRepository.toString());
   }
    
    private static ArgumentParser buildNewArgumentParser(String softwareName) {
        return ArgumentParsers.newFor(softwareName).build();
    }
    
    private static ArgumentParser addArguments(ArgumentParser argumentParser) {
    	argumentParser.addArgument("-r", "--repository").help("dotj local repository");
    	return argumentParser;
    }
}
