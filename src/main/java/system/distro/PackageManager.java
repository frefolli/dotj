package system.distro;

public abstract class PackageManager {
	public abstract String getSoftwareAlias(String software);
	public abstract void installSoftware(String softwareAlias);
	public abstract void uninstallSoftware(String softwareAlias);
}