package system.terminal;

public class Terminal {
	private static Terminal instance = null;
	
	private Terminal() {
		// TODO
	}
	
	public static Terminal getInstance() {
		if (Terminal.instance == null)
			Terminal.instance = new Terminal();
		return Terminal.instance;
	}
	
	public void createFile(String file) {
		// TODO
	}
	
	public void deleteFile(String file) {
		// TODO
	}
	
	public void copyFile(String file, String destination) {
		// TODO
	}
	
	public void moveFile(String file, String destination) {
		// TODO
	}
	
	public void createDirectory(String directory) {
		// TODO
	}
	
	public void deleteDirectory(String directory) {
		// TODO
	}
	
	public void copyDirectory(String directory, String destination) {
		// TODO
	}
	
	public void moveDirectory(String directory, String destination) {
		// TODO
	}
	
	public String createTemporaryDirectory() {
		// TODO
		return null;
	}
	
	public String createTemporaryFile() {
		// TODO
		return null;
	}
	
	public void runCommand(String command) {
		// TODO
	}
}