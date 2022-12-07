package system.repository;

public class RemoteRepositoryFactory {
	public static SSHRepository newSSH(String url) {
		// TODO
		return null;
	}
	
	public static HTTPRepository newHTTP(String url) {
		return new HTTPRepository(url);
	}
}