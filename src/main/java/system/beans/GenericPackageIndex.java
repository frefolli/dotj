package system.beans;

import java.util.List;
import java.util.Map;

public class GenericPackageIndex extends Bean {
    private PackageMetadataIndex metadata = null;
    private List<String> dependencies = null;
    private List<String> install = null;
    private List<String> uninstall = null;
    private List<String> softwares = null;
    private Map<String, String> files = null;

    public PackageMetadataIndex getMetadata() {
        return this.metadata;
    }

    public List<String> getDependencies() {
        return this.dependencies;
    }

    public List<String> getInstall() {
        return this.install;
    }
    
    public List<String> getUninstall() {
        return this.uninstall;
    }
    
    public List<String> getSoftwares() {
        return this.softwares;
    }

    public Map<String, String> getFiles() {
        return this.files;
    }

    public void setMetadata(PackageMetadataIndex metadata) {
        this.metadata = metadata;
    }

    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }
    
    public void setInstall(List<String> install) {
        this.install = install;
    }
    
    public void setUninstall(List<String> uninstall) {
        this.uninstall = uninstall;
    }
    
    public void setSoftwares(List<String> softwares) {
        this.softwares = softwares;
    }

    public void setFiles(Map<String, String> files) {
        this.files = files;
    }

    public String toString() {
        return String.format(
                "(generic-package-index :metadata %s :dependencies %s :install %s :uninstall %s :softwares %s :files%s)",
                this.metadata.toString(), dependencies,
                this.install, this.uninstall,
                this.softwares, this.files);
    }

    public void validate() throws InvalidBeanException {
        //
    }
}
