package system.packaging;

public class PackageMetadata {
	private String name;
	private String author;
	private String version;
	private String date;
	
	public PackageMetadata(
			String name, String author,
			String version, String date) {
		this.name = name;
		this.author = author;
		this.version = version;
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getVersion() {
		return this.version;
	}

	public String getDate() {
		return this.date;
	}
}
