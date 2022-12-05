package system.beans;

import java.util.Map;

public class SoftwareAliasesBean implements Bean {
	private Map<String, String> aliases = null;
	
	public SoftwareAliasesBean() {
		// TODO
	}
	
	public Map<String, String> getAliases() {
		return this.aliases;
	}
	
	public void setAliases(Map<String, String> aliases) {
		this.aliases = aliases;
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
	}
}