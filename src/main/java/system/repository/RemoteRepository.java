package system.repository;

public abstract class RemoteRepository extends Repository {
	protected String url = null;

	protected RemoteRepository(String url) {
		this.url = url;
	}

	public String getURL() {
		return this.url;
	}
}
