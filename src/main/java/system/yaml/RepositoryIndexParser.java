package system.yaml;
import system.beans.RepositoryIndex;

public class RepositoryIndexParser extends Parser {
	private static RepositoryIndexParser instance = null;
	
	private RepositoryIndexParser() {
		super(RepositoryIndex.class);
	}
	
	@Override
	public RepositoryIndex readFromFile(String filepath) {
		return RepositoryIndex.class.cast(super.readFromFile(filepath));
	}
	
	@Override
	public RepositoryIndex readFromString(String string) {
		return RepositoryIndex.class.cast(super.readFromString(string));
	}
	
	public static RepositoryIndexParser getInstance() {
		if (RepositoryIndexParser.instance == null)
			RepositoryIndexParser.instance = new RepositoryIndexParser();
		return RepositoryIndexParser.instance;
	}
}
