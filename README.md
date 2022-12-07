# dotj

A simple package manager written with Java and tested with Sonarqube CE

## Developer Notes

This project should be tested under a posix-compatible system because file attributes/permissions for temp dir/file are granted with posix mechanics.

## Repository index

### JSON

```json
{
    "packages": [
        "package1",
        ...
        "package2"
    ]
}
```

### YAML

```yaml
packages:
 - package1
 ...
 - package2
```
## Package index

### JSON

```json
{
    "metadata": {
        "name": "package-name",
        "author": "package-author",
        "date": "package-date",
        "version": "package-version",
    },
    "dependencies": [
        "package1"
        ...
        "package2"
    ],
    "softwares": [
        "software1"
        ...
        "software2"
    ],
    "files": {
        "file1": "destination1",
        ...
        "file2": "destination2"
    },
    "install": {
        "command1",
        ...
        "command2"
    },
    "uninstall": {
        "command1",
        ...
        "command2"
    }
}
```

### YAML

```yaml
metadata:
    name: package-name
    author: package-author
    date: package-date
    version: package-version
dependencies:
 - package1
 ...
 - package2
softwares:
 - software1
 ...
 - software2
files:
 - file1: destination1,
   ...
 - file2: destination2
install:
 - command1
 ...
 - command2
unistall:
 - command1
 ...
 - command2
```