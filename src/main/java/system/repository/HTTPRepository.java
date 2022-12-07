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
	public List<Package> searchPackages(String name) {
			RepositoryBean bean = this.downloadRepositoryIndex();
			List<Package> packages = new ArrayList<Package>();
			for (String packageName : bean.getPackages()) {
				if (packageName.contains(name)) {
					packages.add(this.downloadPackageIndex(packageName));
				}
			}
			return packages;
	}
	
	private RepositoryBean downloadRepositoryIndex() {
		try {
			TemporaryDirectory env = TemporaryFactory.newDirectory();
			URL remoteIndex = new URL(String.format("%s/index.yml", url));
			File localIndex = new File(String.format("%s/index.yml", env.getPath()));
			FileUtils.copyURLToFile(remoteIndex, localIndex);
			RepositoryBean bean = RepositoryBeanParser.getInstance().parseFromFile(localIndex.getAbsolutePath());
			env.clean();
			return bean;
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		} catch (CannotParseRepositoryBeanFromFileException e) {
			return null;
		} catch (CannotCreateTemporaryDirectoryException e) {
			return null;
		} catch (CannotCleanTemporaryDirectoryException e) {
			return null;
		}
	}
	
	private Package downloadPackageIndex(String name) {
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
			return null;
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			return null;
		} catch (CannotParsePackageBeanFromFileException e) {
			return null;
		} catch (CannotCleanTemporaryDirectoryException e) {
			return null;
		}
	}

	@Override
	public Package downloadPackage(String name, String downloadDirectory) {
		TemporaryDirectory env;
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
			return null;
		} catch (IOException e) {
			return null;
		} catch (CannotParsePackageBeanFromFileException e) {
			return null;
		} catch (CannotCreateDirectoryException e) {
			return null;
		}
	}
}