package system.beans;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class SoftwareAliasesBean implements Bean {
	private Map<String, String> aliases = null;
	
	public SoftwareAliasesBean() {
		aliases = new TreeMap<String, String>();
	}
	
	public Map<String, String> getAliases() {
		return this.aliases;
	}
	
	public void setAliases(Map<String, String> aliases) {
		this.aliases = aliases;
	}

	@Override
	public void validate() throws InvalidSoftwareAliasesBeanException {
		// TODO Auto-generated method stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(aliases);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SoftwareAliasesBean)) {
			return false;
		}
		SoftwareAliasesBean other = (SoftwareAliasesBean) obj;
		return Objects.equals(aliases, other.aliases);
	}
}