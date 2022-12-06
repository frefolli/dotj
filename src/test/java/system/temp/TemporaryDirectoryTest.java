package system.temp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import system.temp.TemporaryDirectory;

public class TemporaryDirectoryTest {
	@Test
	public void testTemporaryDirectory() {
		String path = "/tmp/dir";
		TemporaryDirectory directory = new TemporaryDirectory(path);
		assertEquals(path, directory.getPath());
	}
}
