package system.packaging;

public class PackageMetadata {
	private String name = null;
	private String author = null;
	private String date = null;
	private String version = null;

	public PackageMetadata(String name, String author, String date, String version) {
		this.name = name;
		this.author = author;
		this.date = date;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getVersion() {
		return version;
	}
	
	public String toString() {
		return String.format("(package-metadata :name %s :author %s :date %s :version %s)",
				name, author, date, version);
	}
}
