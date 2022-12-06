package system.yaml;

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

public class YamlObjectMapperTest {
	@Test
	public void testString() {
		SoftwareAliasesBean bean = new SoftwareAliasesBean();
		Map<String, String> aliases = new TreeMap<String, String>();
		aliases.put("1", "2");
		bean.setAliases(aliases);
		SoftwareAliasesBean other = null;
		String text = null;
		YamlBeanDumper yamlBeanDumper = YamlBeanDumper.getInstance();
		YamlBeanParser yamlBeanParser = YamlBeanParser.getInstance();
		
		try {
			text = yamlBeanDumper.dumpToString(bean);
		} catch (CannotDumpToYamlStringException e1) {
			fail("should be able to dump the bean");
		}
		
		try {
			other = SoftwareAliasesBean.class.cast(yamlBeanParser.parseFromString(text, SoftwareAliasesBean.class));
		} catch (CannotParseYamlFromStringException e1) {
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
		String path = Path.of(env.getPath(), "file.yml").toString();
		YamlBeanDumper yamlBeanDumper = YamlBeanDumper.getInstance();
		YamlBeanParser yamlBeanParser = YamlBeanParser.getInstance();
		
		try {
			yamlBeanDumper.dumpToFile(bean, path);
		} catch (CannotDumpToYamlFileException e1) {
			fail("should be able to dump the bean");
		}
		
		try {
			other = SoftwareAliasesBean.class.cast(yamlBeanParser.parseFromFile(path, SoftwareAliasesBean.class));
		} catch (CannotParseYamlFromFileException e1) {
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
