package system.beans;

import java.util.List;
import java.util.Objects;

public class RepositoryIndex {
	List<String> packageList = null;

	public RepositoryIndex(List<String> packageList) {
		super();
		this.packageList = packageList;
	}

	public List<String> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<String> packageList) {
		this.packageList = packageList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(packageList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RepositoryIndex)) {
			return false;
		}
		RepositoryIndex other = (RepositoryIndex) obj;
		return Objects.equals(packageList, other.packageList);
	}
	
}
