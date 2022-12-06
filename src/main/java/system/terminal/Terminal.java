package system.terminal;

public class Terminal {
	private static Terminal instance = null;
	private FileManager fileManager = null;
	private DirectoryManager directoryManager = null;
	private SoftwareManager softwareManager = null;
	
	public static Terminal getInstance() {
		if (Terminal.instance == null)
			Terminal.instance = new Terminal();
		return Terminal.instance;
	}
	
	public Terminal() {
		this.fileManager = FileManager.getInstance();
		this.directoryManager = DirectoryManager.getInstance();
		this.softwareManager = SoftwareManager.getInstance();
	}
	
	public void createFile(String file) throws CannotCreateFileException {
		this.fileManager.createFile(file);
	}
	
	public void deleteFile(String file) throws CannotDeleteFileException {
		this.fileManager.deleteFile(file);
	}
	
	public void copyFile(String file, String destination) throws CannotCopyFileException {
		this.fileManager.copyFile(file, destination);
	}
	
	public void moveFile(String file, String destination) throws CannotMoveFileException {
		this.fileManager.moveFile(file, destination);
	}
	
	public void createDirectory(String directory) throws CannotCreateDirectoryException {
		this.directoryManager.createDirectory(directory);
	}
	
	public void deleteDirectory(String directory) throws CannotDeleteDirectoryException {
		this.directoryManager.deleteDirectory(directory);
	}
	
	public void copyDirectory(String directory, String destination) throws CannotCopyDirectoryException {
		this.directoryManager.copyDirectory(directory, destination);
	}
	
	public void moveDirectory(String directory, String destination) throws CannotMoveDirectoryException {
		this.directoryManager.moveDirectory(directory, destination);
	}
	
	public void installSoftware(String software) {
		this.softwareManager.installSoftware(software);
	}
	
	public void uninstallSoftware(String software) {
		this.softwareManager.uninstallSoftware(software);
	}
}