package system.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HTTPRemoteRepositoryTest {
	public HTTPRemoteRepository craftSampleHTTPRemoteRepository() {
		HTTPRemoteRepository remoteRepository = new HTTPRemoteRepository("http://boh");
		return remoteRepository;
	}
	
	@Test
	public void testConstructor() {
		HTTPRemoteRepository remoteRepository = this.craftSampleHTTPRemoteRepository();
		assertEquals(remoteRepository.getURL(), "http://boh");
	}
	
	@Test
	public void testGet() {
		HTTPRemoteRepository remoteRepository = this.craftSampleHTTPRemoteRepository();
		remoteRepository.getListOfPackages();
		try {
			remoteRepository.getPackage(null);
		} catch (PackageNotFoundException e) {}
	}
}
