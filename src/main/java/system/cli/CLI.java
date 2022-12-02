package system.cli;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import system.beans.RepositoryIndex;
import system.beans.GenericPackageIndex;
import java.io.File;

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

        CLI.readYamlFile(result.getString("package"), GenericPackageIndex.class);
        CLI.readYamlFile(result.getString("repository"), RepositoryIndex.class);
   }

    @Deprecated
    private static void readYamlFile(String filepath, Class<?> theClass) {
        if (filepath != null) {
            system.yaml.Parser yamlParser = new system.yaml.Parser(theClass);
            System.out.println(yamlParser.readFromFile(filepath).toString());
        }
     }
    
    private static ArgumentParser buildNewArgumentParser(String softwareName) {
        return ArgumentParsers.newFor(softwareName).build();
    }
    
    private static ArgumentParser addArguments(ArgumentParser argumentParser) {
    	argumentParser.addArgument("-r", "--repository").help("yaml debug repository");
    	argumentParser.addArgument("-p", "--package").help("yaml debug package");
    	return argumentParser;
    }
}
