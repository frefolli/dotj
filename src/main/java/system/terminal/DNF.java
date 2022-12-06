package system.terminal;

public class DNF extends SoftwareManager {
	private SoftwareAliases softwareAliases = null;
	private static DNF instance = null;
	
	public static DNF getInstance() {
		if (DNF.instance == null)
			DNF.instance = new DNF();
		return DNF.instance;
	}
	
	protected DNF() {
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
