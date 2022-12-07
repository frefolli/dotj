package system.terminal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a Unit of Work, at a certain time commit() is called
 * So i only need to register actions and override only commit phases
 * */
public abstract class SoftwareManager {
	private static SoftwareManager instance = null;
	private List<String> installQueue = null;
	private List<String> uninstallQueue = null;
	private SoftwareAliases softwareAliases = null;
	private String executable = null;
	private String installOption = null;
	private String uninstallOption = null;
	private boolean needSudo = false;
	
	public static SoftwareManager getInstance() {
		if (SoftwareManager.instance == null) {
			if (Files.exists(Path.of("/usr/bin/yay"))) {
				SoftwareManager.instance = Yay.getInstance();
			} else if (Files.exists(Path.of("/usr/bin/pacman"))) {
				SoftwareManager.instance = Pacman.getInstance();
			} else if (Files.exists(Path.of("/usr/bin/apt"))) {
				SoftwareManager.instance = APT.getInstance();
			} else if (Files.exists(Path.of("/usr/bin/dnf"))) {
				SoftwareManager.instance = DNF.getInstance();
			}
		}
		return SoftwareManager.instance;
	}
	
	protected SoftwareManager(
			SoftwareAliases softwareAliases,
			String executable,
			String installOption,
			String uninstallOption,
			boolean needSudo) {
		this.installQueue = new ArrayList<String>();
		this.uninstallQueue = new ArrayList<String>();
		
		this.softwareAliases = softwareAliases;
		this.executable = executable;
		this.installOption = installOption;
		this.uninstallOption = uninstallOption;
		this.needSudo = needSudo;
	}
	
	public void installSoftware(String software) {
		this.installQueue.add(software);
	}
	
	public void uninstallSoftware(String software) {
		this.uninstallQueue.add(software);
	}
	
	public void commit() {
		this.commitInstall();
		this.commitUninstall();
	}
	
	private String craftInstallCommand(List<String> translatedList) {
		String command = String.format("%s %s %s",
				this.executable, this.installOption, String.join(" ", translatedList));
		if (this.needSudo)
			command = "sudo " + command;
		return command;
	}
	
	private String craftUninstallCommand(List<String> translatedList) {
		String command = String.format("%s %s %s",
				this.executable, this.installOption, String.join(" ", translatedList));
		if (this.needSudo)
			command = "sudo " + command;
		return command;
	}
	
	public void commitInstall() {
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.installQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			String command = this.craftInstallCommand(translatedList);
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	public void commitUninstall() {
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.uninstallQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			String command = this.craftUninstallCommand(translatedList);
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}