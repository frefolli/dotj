# Agile

## Visual Paradigm

project file is `dotj.vpp`

## UML diagrams

### Class Diagrams

#### package system.json

![package system.json](system.json.png)

#### package system.yaml

![package system.yaml](system.yaml.png)

#### package system.parser

![package system.parser](system.parser.png)

#### package system.packaging

![package system.packaging](system.packaging.png)

#### package system.repository

![package system.repository](system.repository.png)

#### package system.beans

![package system.beans](system.beans.png)

#### package system.main

![package system.main](system.main.png)

#### package system.temp

![package system.temp](system.temp.png)

Si applica il Design Pattern *Facade*: la classe TemporaryFactory contiene una interfaccia unificata per le operazioni di creazione di TemporaryFile e TemporaryDirectory.

#### package system.terminal

![package system.terminal](system.terminal.png)

Si applica il Design Pattern *Facade*: la classe Terminal contiene una interfaccia unificata per le operazioni gestite da FileManager, SoftwareManager e DirectoryManager.

Si applica il Design Pattern *Singleton*: le classi Terminal, FileManager, SoftwareManager e DirectoryManager sono progettate per avere un'unica istanza.

Si applica il Design Pattern *Strategy*: le classi concrete APT, DNF e Pacman implementano i servizi promessi dalla classe astratta SoftwareManager.

#### package system

![package system](system.png)
