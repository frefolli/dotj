package system.beans;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class PackageBeanTest {
	@Test
	public void testPackageBean() {
		PackageMetadataBean metadata = new PackageMetadataBean();
		List<String> dependencies = new ArrayList<String>();
		List<String> softwares = new ArrayList<String>();
		List<String> install = new ArrayList<String>();
		List<String> uninstall = new ArrayList<String>();
		Map<String,String> files = new TreeMap<String,String>();
		PackageBean packageBean = new PackageBean();
		
		packageBean.setMetadata(metadata);
		packageBean.setDependencies(dependencies);
		packageBean.setFiles(files);
		packageBean.setSoftwares(softwares);
		packageBean.setInstall(install);
		packageBean.setUninstall(uninstall);

		assertEquals(metadata, packageBean.getMetadata());
		assertEquals(dependencies ,packageBean.getDependencies());
		assertEquals(files ,packageBean.getFiles());
		assertEquals(softwares ,packageBean.getSoftwares());
		assertEquals(install ,packageBean.getInstall());
		assertEquals(uninstall ,packageBean.getUninstall());
		
		packageBean.validate();
	}
}