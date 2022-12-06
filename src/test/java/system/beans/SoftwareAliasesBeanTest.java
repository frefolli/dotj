package system.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

public class SoftwareAliasesBeanTest {
	@Test
	public void testSoftwareAliasesBean() {
		Map<String,String> aliases = new TreeMap<String,String>();
		SoftwareAliasesBean softwareAliases = new SoftwareAliasesBean();
		
		softwareAliases.setAliases(aliases);
		assertEquals(aliases, softwareAliases.getAliases());
		try {
			softwareAliases.validate();
		} catch (InvalidSoftwareAliasesBeanException e) {
			fail("should be valid");
		}
	}
}
