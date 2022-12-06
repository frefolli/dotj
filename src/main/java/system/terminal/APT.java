package system.terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public void commitInstall() {
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.installQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			Runtime.getRuntime().exec(String.format("sudo apt install %s", String.join(" ", translatedList)));
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
			Runtime.getRuntime().exec(String.format("sudo apt remove %s", String.join(" ", translatedList)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
