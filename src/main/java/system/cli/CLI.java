package system.cli;

import java.util.List;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

public class CLI {
    public static void main(String[] args) {
        ArgumentParser parser = ArgumentParsers.newFor("dotj").build();
        parser.addArgument("-f", "--file").nargs("?").help("pull package list from file");
        parser.addArgument("package").nargs("*").help("package to install");
        Namespace ns = null;

        try {
            ns = parser.parseArgs(args);
        } catch(ArgumentParserException error) {
            parser.handleError(error);
            System.exit(1);
        }

        String file = ns.getString("file");
        if (file != null) {
            System.out.println(String.format("pull package list from file: %s", file));
        }

        List<String> packages = ns.<String>getList("package");
        if (packages != null && packages.size() > 0) {
            System.out.println(String.format("package list from args: %s", packages.toString()));
        }
    }
}
