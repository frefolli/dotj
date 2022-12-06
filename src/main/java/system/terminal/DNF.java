package system.terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public void commitInstall() {
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.installQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			Runtime.getRuntime().exec(String.format("sudo dnf install %s", String.join(" ", translatedList)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void commitUninstall() {
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.uninstallQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			Runtime.getRuntime().exec(String.format("sudo dnf remove %s", String.join(" ", translatedList)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
