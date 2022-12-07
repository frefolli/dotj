package system.packaging;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PackageMetadataTest {
	@Test
	public void test() {
		String name = "";
		String author = "";
		String date = "";
		String version = "";
		PackageMetadata metadata = new PackageMetadata(name, author, date, version);
		assertEquals(name, metadata.getName());
		assertEquals(author, metadata.getAuthor());
		assertEquals(date, metadata.getDate());
		assertEquals(version, metadata.getVersion());
	}
}
