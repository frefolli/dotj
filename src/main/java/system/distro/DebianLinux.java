package system.distro;

public class DebianLinux extends Linux {
	public DebianLinux() {
		super(new APT());
	}
}
