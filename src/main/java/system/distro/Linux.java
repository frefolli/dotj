package system.distro;

public abstract class Linux {
	protected PackageManager packageManager = null;
	
	protected Linux(PackageManager packageManager) {
		this.packageManager = packageManager;
	}
}
