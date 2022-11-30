package system.packaging;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PackageMetadataTest {
	@Test
	public void testConstructor() {
		String name = "package_name";
		String author = "package_author";
		String version = "package_version";
		String date = "package_date";
		PackageMetadata metadata = new PackageMetadata(name, author, version, date);
		assertEquals(metadata.getName(), name);
		assertEquals(metadata.getAuthor(), author);
		assertEquals(metadata.getVersion(), version);
		assertEquals(metadata.getDate(), date);
	}
}
