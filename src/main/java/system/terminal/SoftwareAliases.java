package system.terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import system.beans.InvalidSoftwareAliasesBeanException;
import system.beans.SoftwareAliasesBean;
import system.dumper.CannotDumpSoftwareAliasesBeanToFileException;
import system.dumper.SoftwareAliasesBeanDumper;
import system.parser.CannotParseSoftwareAliasesBeanFromFileException;
import system.parser.SoftwareAliasesBeanParser;

public class SoftwareAliases {
	private Map<String, String> aliases = null;
	
	public SoftwareAliases() {
		this(new TreeMap<String, String>());
	}
	
	public SoftwareAliases(Map<String, String> aliases) {
		this.aliases = aliases;
	}
	
	/**
	 * if a software is not found is intended to be self-mapping
	 * */
	public String getAlias(String software) {
		if (this.aliases.containsKey(software))
			return this.aliases.get(software);
		else
			return software;
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
	
	public void load(String configFilePath) throws CannotLoadSoftwareAliasesFromFileException {
		try {
			system.beans.SoftwareAliasesBean bean = SoftwareAliasesBeanParser.getInstance().parseFromFile(configFilePath);
			bean.validate();
			this.aliases = new TreeMap<String, String>(bean.getAliases());
		} catch (CannotParseSoftwareAliasesBeanFromFileException e) {
			throw new CannotLoadSoftwareAliasesFromFileException(configFilePath);
		} catch (InvalidSoftwareAliasesBeanException e) {
			throw new CannotLoadSoftwareAliasesFromFileException(configFilePath);
		}
	}
	
	public void save(String configFilePath) throws CannotDumpSoftwareAliasesToFileException {
		try {
			SoftwareAliasesBean bean = new SoftwareAliasesBean();
			bean.setAliases(new TreeMap<String, String>(this.aliases));
			SoftwareAliasesBeanDumper.getInstance().dumpToFile(bean, configFilePath);
		} catch (CannotDumpSoftwareAliasesBeanToFileException e) {
			throw new CannotDumpSoftwareAliasesToFileException(configFilePath);
		}
	}
}