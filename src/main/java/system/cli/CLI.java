package system.cli;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import system.beans.RepositoryIndex;

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

        String filepath = result.getString("filepath");
        system.yaml.Parser yamlParser = new system.yaml.Parser(RepositoryIndex.class);
        RepositoryIndex repositoryIndex = (RepositoryIndex) yamlParser.readFromFile(filepath);
        System.out.println(repositoryIndex.toString());
    }
    
    private static ArgumentParser buildNewArgumentParser(String softwareName) {
        return ArgumentParsers.newFor(softwareName).build();
    }
    
    private static ArgumentParser addArguments(ArgumentParser argumentParser) {
    	argumentParser.addArgument("filepath").nargs(1).help("yaml debug");
    	return argumentParser;
    }
}