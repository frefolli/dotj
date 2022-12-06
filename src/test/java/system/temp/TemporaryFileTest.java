package system.temp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import system.temp.TemporaryFile;

public class TemporaryFileTest {
	@Test
	public void testTemporaryFile() {
		String path = "/tmp/file";
		TemporaryFile file = new TemporaryFile(path);
		assertEquals(path, file.getPath());
	}
}
