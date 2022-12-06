package system.temp;

public abstract class Temporary {
	protected String path = null;
	
	protected Temporary(String path) {
		this.path = path;
	}
	
	public String getPath() {
		return this.path;
	}
	
	public abstract void clean() throws CannotCleanTemporaryException;
}