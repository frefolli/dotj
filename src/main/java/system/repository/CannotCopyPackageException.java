package system.repository;

import system.packaging.Package;

public class CannotCopyPackageException extends Exception {

	public CannotCopyPackageException() {
		super(String.format("cannot copy package to local repository"));
	}

}
