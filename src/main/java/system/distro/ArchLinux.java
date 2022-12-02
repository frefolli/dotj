package system.distro;

public class ArchLinux extends Linux {
	public ArchLinux() {
		super(new Pacman());
	}
}
