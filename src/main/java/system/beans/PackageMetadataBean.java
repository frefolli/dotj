package system.beans;

public class PackageMetadataBean implements Bean {
	private String name = null;
	private String author = null;
	private String date = null;
	private String version = null;
	
	public PackageMetadataBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
	}

	public String getName() {
		return this.name;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getDate() {
		return this.date;
	}

	public String getVersion() {
		return this.version;
	}
	
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

}
