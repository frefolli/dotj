package system.beans;

import java.util.List;

public class RepositoryBean implements Bean {
	private List<String> packages = null;
	
	public RepositoryBean() {
		// TODO
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
	}

	public List<String> getPackages() {
		return this.packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}
}
