package system.terminal;

public class Yay extends SoftwareManager {
	private static Yay instance = null;
	
	public static Yay getInstance() {
		if (Yay.instance == null)
			Yay.instance = new Yay();
		return Yay.instance;
	}
	
	protected Yay() {
		super(new SoftwareAliases(), "yay", "-Syu --needed --noconfirm", "-R", false);
	}
}
