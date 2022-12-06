package system.terminal;

public class APT extends SoftwareManager {
	private SoftwareAliases softwareAliases = null;
	private static APT instance = null;
	
	public static APT getInstance() {
		if (APT.instance == null)
			APT.instance = new APT();
		return APT.instance;
	}

	public APT() {
		this.softwareAliases = new SoftwareAliases();
	}

	@Override
	public void installSoftware(String software) {
		// TODO Auto-generated method stub
	}

	@Override
	public void uninstallSoftware(String software) {
		// TODO Auto-generated method stub
	}
}
