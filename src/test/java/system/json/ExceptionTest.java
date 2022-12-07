package system.json;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import system.beans.SoftwareAliasesBean;

public class ExceptionTest {
	@Test
	public void testString() {
		try {
			throw new CannotDumpToJsonStringException(new SoftwareAliasesBean());
		} catch(CannotDumpToJsonStringException e) {
			assertTrue(e instanceof Exception);
		}
		
		try {
			throw new CannotParseJsonFromStringException("");
		} catch(CannotParseJsonFromStringException e) {
			assertTrue(e instanceof Exception);
		}
	}
	
	@Test
	public void testFile() {
		try {
			throw new CannotDumpToJsonFileException(new SoftwareAliasesBean(), "");
		} catch(CannotDumpToJsonFileException e) {
			assertTrue(e instanceof Exception);
		}
		
		try {
			throw new CannotParseJsonFromFileException("");
		} catch(CannotParseJsonFromFileException e) {
			assertTrue(e instanceof Exception);
		}
	}
}
