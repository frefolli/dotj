package system.logging;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public abstract class ClassLogger {
	private Logger logger = null;

	protected ClassLogger(Class<?> theClass) {
		this.logger = LogManager.getLogger(theClass);
	}
	
	public void info(String message) {
		this.logger.info(message);
	}
	
	public void warn(String message) {
		this.logger.warn(message);
	}
	
	public void error(String message) {
		this.logger.error(message);
	}
	
	public void fatal(String message) {
		this.logger.fatal(message);
	}
}
