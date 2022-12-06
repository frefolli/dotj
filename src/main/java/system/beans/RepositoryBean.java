package system.beans;

import java.util.List;
import java.util.Objects;

public class RepositoryBean implements Bean {
	private List<String> packages = null;
	
	public RepositoryBean() {
		// TODO
	}

	@Override
	public void validate() throws InvalidRepositoryBeanException {
		// TODO Auto-generated method stub
	}

	public List<String> getPackages() {
		return this.packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

	@Override
	public int hashCode() {
		return Objects.hash(packages);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RepositoryBean)) {
			return false;
		}
		RepositoryBean other = (RepositoryBean) obj;
		return Objects.equals(packages, other.packages);
	}
}
