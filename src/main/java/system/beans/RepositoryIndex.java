package system.beans;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class RepositoryIndex extends Bean {
	List<String> packages = null;
    
    public RepositoryIndex() {
        this(new ArrayList<String>());
    }

	public RepositoryIndex(List<String> packages) {
		this.packages = packages;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

    @Override
    public String toString() {
        return String.format("(repository-index '(%s))", String.join(" ", this.packages));
    }

    public void validate() throws InvalidBeanException {
        //
    }
}
