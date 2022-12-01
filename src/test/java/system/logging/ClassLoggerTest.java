package system.logging;

import org.junit.Test;

public class ClassLoggerTest extends ClassLogger {
	public ClassLoggerTest() {
		super(ClassLoggerTest.class);
	}
	
	@Test
	public void testLogLevels() {
		this.info("info");
		this.warn("warn");
		this.error("error");
		this.fatal("fatal");
	}
}
