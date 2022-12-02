package system.yaml;
import system.beans.GenericPackageIndex;

public class GenericPackageIndexParser extends Parser {
	private static GenericPackageIndexParser instance = null;
	
	private GenericPackageIndexParser() {
		super(GenericPackageIndex.class);
	}
	
	@Override
	public GenericPackageIndex readFromFile(String filepath) {
		return GenericPackageIndex.class.cast(super.readFromFile(filepath));
	}
	
	@Override
	public GenericPackageIndex readFromString(String string) {
		return GenericPackageIndex.class.cast(super.readFromString(string));
	}
	
	public static GenericPackageIndexParser getInstance() {
		if (GenericPackageIndexParser.instance == null)
			GenericPackageIndexParser.instance = new GenericPackageIndexParser();
		return GenericPackageIndexParser.instance;
	}
}