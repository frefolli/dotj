package system.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import system.beans.SoftwareAliasesBean;
import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;

public class JsonObjectMapperTest {
	@Test
	public void testString() {
		SoftwareAliasesBean bean = new SoftwareAliasesBean();
		Map<String, String> aliases = new TreeMap<String, String>();
		aliases.put("1", "2");
		bean.setAliases(aliases);
		SoftwareAliasesBean other = null;
		String text = null;
		JsonBeanDumper yamlBeanDumper = JsonBeanDumper.getInstance();
		JsonBeanParser yamlBeanParser = JsonBeanParser.getInstance();
		
		try {
			text = yamlBeanDumper.dumpToString(bean);
		} catch (CannotDumpToJsonStringException e1) {
			fail("should be able to dump the bean");
		}
		
		try {
			other = SoftwareAliasesBean.class.cast(yamlBeanParser.parseFromString(text, SoftwareAliasesBean.class));
		} catch (CannotParseJsonFromStringException e1) {
			fail("should be able to load the bean");
		}
		
		assertEquals(bean.getAliases(), other.getAliases());
	}
	
	@Test
	public void testFile() {
		TemporaryDirectory env = null;
		try {
			env = TemporaryFactory.newDirectory();
		} catch (CannotCreateTemporaryDirectoryException e) {
			fail("should be able to create an env");
		}

		SoftwareAliasesBean bean = new SoftwareAliasesBean();
		Map<String, String> aliases = new TreeMap<String, String>();
		aliases.put("3", "4");
		bean.setAliases(aliases);
		SoftwareAliasesBean other = null;
		String path = Path.of(env.getPath(), "file.json").toString();
		JsonBeanDumper jsonBeanDumper = JsonBeanDumper.getInstance();
		JsonBeanParser jsonBeanParser = JsonBeanParser.getInstance();
		
		try {
			jsonBeanDumper.dumpToFile(bean, path);
		} catch (CannotDumpToJsonFileException e1) {
			fail("should be able to dump the bean");
		}
		
		try {
			other = SoftwareAliasesBean.class.cast(jsonBeanParser.parseFromFile(path, SoftwareAliasesBean.class));
		} catch (CannotParseJsonFromFileException e1) {
			fail("should be able to load the bean");
		}
		
		assertEquals(bean.getAliases(), other.getAliases());
		
		try {
			env.clean();
		} catch (CannotCleanTemporaryDirectoryException e) {
			fail("should be able to clean the env");
		}
	}
}
