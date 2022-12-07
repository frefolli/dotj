package system.repository;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import system.beans.InvalidPackageBeanException;
import system.beans.PackageBean;
import system.beans.RepositoryBean;
import system.dumper.CannotDumpRepositoryBeanToFileException;
import system.dumper.RepositoryBeanDumper;
import system.packaging.Package;
import system.parser.CannotParsePackageBeanFromFileException;
import system.parser.CannotParseRepositoryBeanFromFileException;
import system.parser.PackageBeanParser;
import system.parser.RepositoryBeanParser;
import system.terminal.CannotCopyDirectoryException;
import system.terminal.Terminal;

public class LocalRepository {
	private Map<String, Package> cache = null;
	private List<String> packages = null;
	private String directoryPath = null;
	
	public LocalRepository(String path) throws CannotOpenLocalRepository {
		this.cache = new TreeMap<String, Package>();
		this.directoryPath = path;
		try {
			this.load(this.craftIndexFilePath());
		} catch (CannotSetupLocalRepositoryIndexFileException e) {
			throw new CannotOpenLocalRepository(path);
		}
	}
	
	public List<Package> searchPackages(String name) {
		List<Package> found = new ArrayList<Package>();
		for (String package_ : this.packages) {
			if (package_.contains(name))
				try {
					found.add(this.getPackage(package_));
				} catch (CannotFindPackageException e) {
					// ignoring then
				}
		}
		return found;
	}
	
	public Package getPackage(String name) throws CannotFindPackageException {
		if (this.cache.containsKey(name)) {
			return this.cache.get(name);
		} else if (this.packages.contains(name)) {
			String indexFilePath = Path.of(this.craftPackagePath(name), "index.yml").toString();
			try {
				PackageBean bean = PackageBeanParser.getInstance().parseFromFile(indexFilePath);
				bean.validate();
				Package package_ = bean.build();
				this.cache.put(name, package_);
				return package_;
			} catch (CannotParsePackageBeanFromFileException e) {
				throw new CannotFindPackageException(name);
			} catch (InvalidPackageBeanException e) {
				throw new CannotFindPackageException(name);
			}
		} else {
			throw new CannotFindPackageException(name);
		}
	}
	
	/**
	 * This method require that call has downloaded the package and has put this in a directory so that
	 * LocalRepository can fetch and copy it
	 * */
	public void addPackage(Package freshPackage, String tmpPath) throws CannotCopyPackageException, CannotAddPackageToLocalRepositoryIndexFileException {
		String packageName = freshPackage.getMetadata().getName();
		
		try {
			Terminal.getInstance().copyDirectory(tmpPath, this.craftPackagePath(packageName));
		} catch (CannotCopyDirectoryException e) {
			throw new CannotCopyPackageException();
		}
		
		this.packages.add(packageName);
		String indexFilePath = this.craftIndexFilePath();
		try {
			this.save(indexFilePath);
		} catch (CannotSaveLocalRepositoryIndexFileException e) {
			this.packages.remove(packageName);
			throw new CannotAddPackageToLocalRepositoryIndexFileException();
		}
		
		this.cache.put(packageName, freshPackage);
	}
	
	public void cleanCache() throws CannotCleanCacheException {
		try {
			Terminal.getInstance().deleteDirectory(directoryPath);
			Terminal.getInstance().createDirectory(directoryPath);
			this.save(this.craftIndexFilePath());
		} catch(Exception e) {
			throw new CannotCleanCacheException();
		}
		this.cache.clear();
		this.packages.clear();
	}
	
	private void load(String indexFilePath) throws CannotSetupLocalRepositoryIndexFileException {
		try {
			RepositoryBean bean = RepositoryBeanParser.getInstance().parseFromFile(indexFilePath);
			this.packages = new ArrayList<String>(bean.getPackages());
		} catch (CannotParseRepositoryBeanFromFileException e) {
			RepositoryBean bean = new RepositoryBean();
			bean.setPackages(new ArrayList<String>());
			this.packages = new ArrayList<String>(bean.getPackages());
			try {
				RepositoryBeanDumper.getInstance().dumpToFile(bean, indexFilePath);
			} catch (CannotDumpRepositoryBeanToFileException e1) {
				throw new CannotSetupLocalRepositoryIndexFileException(indexFilePath);
			}
		}
	}
	
	private void save(String indexFilePath) throws CannotSaveLocalRepositoryIndexFileException {
		RepositoryBean bean = new RepositoryBean();
		bean.setPackages(new ArrayList<String>(this.packages));
		try {
			RepositoryBeanDumper.getInstance().dumpToFile(bean, indexFilePath);
		} catch (CannotDumpRepositoryBeanToFileException e1) {
			throw new CannotSaveLocalRepositoryIndexFileException(indexFilePath);
		}
	}
	
	private String craftIndexFilePath() {
		return Path.of(directoryPath, "index.yml").toString();
	}
	
	private String craftPackagePath(String packageName) {
		return Path.of(directoryPath, packageName).toString();
	}
}
