package system.beans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PackageMetadataBeanTest {

	@Test
	public void testPackageMetadataBean() {
		String name = "";
		String author = "";
		String version = "";
		String date = "";
		
		PackageMetadataBean packageMetadata = new PackageMetadataBean();

		packageMetadata.setName(name);
		packageMetadata.setAuthor(author);
		packageMetadata.setVersion(version);
		packageMetadata.setDate(date);
		
		assertEquals(name, packageMetadata.getName());
		assertEquals(author, packageMetadata.getAuthor());
		assertEquals(version, packageMetadata.getVersion());
		assertEquals(date, packageMetadata.getDate());
		
		try {
			packageMetadata.validate();
		} catch (InvalidPackageMetadataBeanException e) {
			fail("should be valid");
		}
	}

}
