package system.repository;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import system.beans.PackageBean;
import system.beans.RepositoryBean;
import system.packaging.Package;
import system.parser.CannotParsePackageBeanFromFileException;
import system.parser.CannotParseRepositoryBeanFromFileException;
import system.parser.PackageBeanParser;
import system.parser.RepositoryBeanParser;
import system.temp.CannotCleanTemporaryDirectoryException;
import system.temp.CannotCreateTemporaryDirectoryException;
import system.temp.TemporaryDirectory;
import system.temp.TemporaryFactory;
import system.terminal.CannotCreateDirectoryException;
import system.terminal.Terminal;

public class HTTPRepository extends RemoteRepository {
	public HTTPRepository(String url) {
		super(url);
	}

	@Override
	public List<Package> searchPackages(String name) throws CannotSearchPackagesException {
			RepositoryBean bean;
			try {
				bean = this.downloadRepositoryIndex();
				List<Package> packages = new ArrayList<Package>();
				for (String packageName : bean.getPackages()) {
					if (packageName.contains(name)) {
						packages.add(this.downloadPackageIndex(packageName));
					}
				}
				return packages;
			} catch (CannotDownloadRepositoryIndexException e) {
				throw new CannotSearchPackagesException(this.getURL(), name);
			} catch (CannotDownloadPackageIndexException e) {
				throw new CannotSearchPackagesException(this.getURL(), name);
			}
	}
	
	private RepositoryBean downloadRepositoryIndex() throws CannotDownloadRepositoryIndexException {
		try {
			TemporaryDirectory env = TemporaryFactory.newDirectory();
			URL remoteIndex = new URL(String.format("%s/index.yml", url));
			File localIndex = new File(String.format("%s/index.yml", env.getPath()));
			FileUtils.copyURLToFile(remoteIndex, localIndex);
			RepositoryBean bean = RepositoryBeanParser.getInstance().parseFromFile(localIndex.getAbsolutePath());
			env.clean();
			return bean;
		} catch (MalformedURLException e) {
			throw new CannotDownloadRepositoryIndexException(this.getURL());
		} catch (IOException e) {
			throw new CannotDownloadRepositoryIndexException(this.getURL());
		} catch (CannotParseRepositoryBeanFromFileException e) {
			throw new CannotDownloadRepositoryIndexException(this.getURL());
		} catch (CannotCreateTemporaryDirectoryException e) {
			throw new CannotDownloadRepositoryIndexException(this.getURL());
		} catch (CannotCleanTemporaryDirectoryException e) {
			throw new CannotDownloadRepositoryIndexException(this.getURL());
		}
	}
	
	private Package downloadPackageIndex(String name) throws CannotDownloadPackageIndexException {
		TemporaryDirectory env;
		try {
			env = TemporaryFactory.newDirectory();
			URL remoteIndex = new URL(String.format("%s/%s/index.yml", url, name));
			File localIndex = new File(String.format("%s/index.yml", env.getPath()));
			FileUtils.copyURLToFile(remoteIndex, localIndex);
			PackageBean bean = PackageBeanParser.getInstance().parseFromFile(localIndex.getAbsolutePath());
			env.clean();
			return bean.build();
		} catch (CannotCreateTemporaryDirectoryException e) {
			throw new CannotDownloadPackageIndexException(this.getURL(), name);
		} catch (MalformedURLException e) {
			throw new CannotDownloadPackageIndexException(this.getURL(), name);
		} catch (IOException e) {
			throw new CannotDownloadPackageIndexException(this.getURL(), name);
		} catch (CannotParsePackageBeanFromFileException e) {
			throw new CannotDownloadPackageIndexException(this.getURL(), name);
		} catch (CannotCleanTemporaryDirectoryException e) {
			throw new CannotDownloadPackageIndexException(this.getURL(), name);
		}
	}

	@Override
	public Package downloadPackage(String name, String downloadDirectory) throws CannotDownloadPackageException {
		try {
			URL remoteIndex = new URL(String.format("%s/%s/index.yml", url, name));
			Terminal.getInstance().createDirectory(String.format("%s/%s", downloadDirectory, name));
			File localIndex = new File(String.format("%s/%s/index.yml", downloadDirectory, name));
			FileUtils.copyURLToFile(remoteIndex, localIndex);
			PackageBean bean = PackageBeanParser.getInstance().parseFromFile(localIndex.getAbsolutePath());
			for (String file : bean.getFiles().keySet()) {
				remoteIndex = new URL(String.format("%s/%s/%s", url, name, file));
				localIndex = new File(String.format("%s/%s/%s", downloadDirectory, name, file));
				FileUtils.copyURLToFile(remoteIndex, localIndex);
			}
			return bean.build();
		} catch (MalformedURLException e) {
			throw new CannotDownloadPackageException(this.getURL(), name);
		} catch (IOException e) {
			throw new CannotDownloadPackageException(this.getURL(), name);
		} catch (CannotParsePackageBeanFromFileException e) {
			throw new CannotDownloadPackageException(this.getURL(), name);
		} catch (CannotCreateDirectoryException e) {
			throw new CannotDownloadPackageException(this.getURL(), name);
		}
	}
}