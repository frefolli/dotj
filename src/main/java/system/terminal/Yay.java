package system.terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Yay extends SoftwareManager {
	private static Yay instance = null;
	private SoftwareAliases softwareAliases = null;
	
	public static Yay getInstance() {
		if (Yay.instance == null)
			Yay.instance = new Yay();
		return Yay.instance;
	}
	
	protected Yay() {
		this.softwareAliases = new SoftwareAliases();
	}

	@Override
	public void commitInstall() {
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.installQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			Runtime.getRuntime().exec(String.format("yay -Syu %s", String.join(" ", translatedList)));
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
			Runtime.getRuntime().exec(String.format("yay -R %s", String.join(" ", translatedList)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
