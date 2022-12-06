package system.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SoftwareAliases {
	private Map<String, String> aliases = null;
	
	public SoftwareAliases() {
		this(new TreeMap<String, String>());
	}
	
	public SoftwareAliases(Map<String, String> aliases) {
		this.aliases = aliases;
	}
	
	public String getAlias(String software) {
		return this.aliases.get(software);
	}
	
	public void addAlias(String software, String alias) {
		this.aliases.put(software, alias);
	}
	
	public void removeAlias(String software) {
		this.aliases.remove(software);
	}
	
	public List<String> getListOfAliases() {
		return new ArrayList<String>(this.aliases.keySet());
	}
	
	public String toString() {
		return String.format("(software-aliases '(%s))", String.join(" ", this.getListOfAliases()));
	}
	
	public void load(String configFilePath) {
		// TODO
	}
	
	public void save(String configFilePath) {
		// TODO
	}
}
