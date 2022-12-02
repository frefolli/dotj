package system.beans;

public abstract class InvalidBeanException extends Exception {
	public InvalidBeanException(String message) {
		super(message);
	}
}