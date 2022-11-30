package system.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RepositoryProxyTest {
	public RepositoryProxy craftSampleRepositoryProxy() {
		LocalRepository localRepository = new LocalRepository("/tmp/dummy");
		RemoteRepository remoteRepository = new HTTPRemoteRepository("http://localhost:/dummy");
		RepositoryProxy repositoryProxy = new RepositoryProxy(
				localRepository, remoteRepository);
		return repositoryProxy;
	}
	
	@Test
	public void testConstructor() {
		RepositoryProxy repositoryProxy = this.craftSampleRepositoryProxy();
	}
	
	@Test
	public void testGet() {
		RepositoryProxy repositoryProxy = this.craftSampleRepositoryProxy();
		repositoryProxy.getListOfPackages();
		try {
			repositoryProxy.getPackage("dummy");
			repositoryProxy.getPackage("dummy");
		} catch (PackageNotFoundException e) {}
	}
}
