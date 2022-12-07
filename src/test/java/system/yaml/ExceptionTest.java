package system.yaml;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import system.beans.SoftwareAliasesBean;

public class ExceptionTest {
	@Test
	public void testString() {
		try {
			throw new CannotDumpToYamlStringException(new SoftwareAliasesBean());
		} catch(CannotDumpToYamlStringException e) {
			assertTrue(e instanceof Exception);
		}
		
		try {
			throw new CannotParseYamlFromStringException("");
		} catch(CannotParseYamlFromStringException e) {
			assertTrue(e instanceof Exception);
		}
	}
	
	@Test
	public void testFile() {
		try {
			throw new CannotDumpToYamlFileException(new SoftwareAliasesBean(), "");
		} catch(CannotDumpToYamlFileException e) {
			assertTrue(e instanceof Exception);
		}
		
		try {
			throw new CannotParseYamlFromFileException("");
		} catch(CannotParseYamlFromFileException e) {
			assertTrue(e instanceof Exception);
		}
	}
}
