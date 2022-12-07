package system.packaging;

public class PackageMetadataBuilder {
	private String name = null;
	private String author = null;
	private String date = null;
	private String version = null;
	
	public PackageMetadataBuilder() {}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public PackageMetadata build() {
		return new PackageMetadata(name, author, date, version);
	}

}
