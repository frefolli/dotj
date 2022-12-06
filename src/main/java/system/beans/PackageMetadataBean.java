package system.beans;

import java.util.List;
import java.util.Objects;

public class PackageMetadataBean implements Bean {
	private String name = null;
	private String author = null;
	private String date = null;
	private String version = null;
	
	public PackageMetadataBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void validate() throws InvalidPackageMetadataBeanException {
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

	@Override
	public int hashCode() {
		return Objects.hash(author, date, name, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PackageMetadataBean)) {
			return false;
		}
		PackageMetadataBean other = (PackageMetadataBean) obj;
		return Objects.equals(author, other.author) && Objects.equals(date, other.date)
				&& Objects.equals(name, other.name) && Objects.equals(version, other.version);
	}
}
