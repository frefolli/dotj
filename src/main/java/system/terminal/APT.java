package system.terminal;

public class APT extends SoftwareManager {
	private static APT instance = null;
	
	public static APT getInstance() {
		if (APT.instance == null)
			APT.instance = new APT();
		return APT.instance;
	}
	
	protected APT() {
		super(new SoftwareAliases(), "apt", "install", "remove", true);
	}
}