package system.terminal;

public class DNF extends SoftwareManager {
	private static DNF instance = null;
	
	public static DNF getInstance() {
		if (DNF.instance == null)
			DNF.instance = new DNF();
		return DNF.instance;
	}
	
	protected DNF() {
		super(new SoftwareAliases(), "dnf", "install", "remove", true);
	}
}