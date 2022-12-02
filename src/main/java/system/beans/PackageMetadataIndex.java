package system.beans;

public class PackageMetadataIndex extends Bean {
    private String name = null;
    private String author = null;
    private String version = null;
    private String date = null;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return String.format("(package-metadata-index :name %s :author %s :version %s :date %s)",
                this.name, this.author, this.version, this.date);
    }

    public void validate() throws InvalidBeanException {
        //
    }
}
