## UML diagrams (PlantUML, jar bundled in /uml)

This project bundles `plantuml.jar` inside the `/uml` folder. To create diagrams, simply `cd` into `/uml`, write a `.txt` (or `.puml`) file with PlantUML markup, and run the jar.

- [Official docs](https://plantuml.com/en/starting)

### Prerequisite

- Java 8+ installed (required to run the jar)

### Quick start (from /uml)

1) Open a terminal and change directory:

```bash
cd uml
```

2) Create a text file, e.g. `sequence-diagram.txt`:

```text
@startuml
Alice -> Bob: test
@enduml
```

3) Render the diagram to PNG (output goes to current folder by default):

```bash
java -jar plantuml.jar sequence-diagram.txt
```

You can also specify an output subfolder:

```bash
java -jar plantuml.jar -tpng -o out sequence-diagram.txt
```

Render all diagrams in the folder:

```bash
java -jar plantuml.jar -tpng -o out *.txt
```

Preview GUI (optional):

```bash
java -jar plantuml.jar -gui
```

### Using .puml files

The content is identical; `.puml` just has better editor syntax highlighting. Examples:

```bash
java -jar plantuml.jar -tpng -o out class-diagram.puml
java -jar plantuml.jar -tpng -o out *.puml
```

### Sample sources

- `/uml/sequence-diagram.txt` (created for you):

```text
@startuml
Alice -> Bob: test
@enduml
```

- `/uml/classDiagrams/quotely.txt`:

```plantuml
@startuml
hide circle
skinparam classAttributeIconSize 0

title Quotely Class Diagram
top to bottom direction

package command as Cmd {
  abstract class Command  
}

package data as Data {
  class CompanyName
  class Item
  class Quote
  class QuoteList
  class QuotelyState

  Quote -> Item
  QuoteList --> Quote
}

package parser as ParserComp {
  class Parser
}

package storage as StorageComp {
  class JsonSerializer
  class Storage
}

package ui as UIComp {
  class Ui
}

package util as Util {
  class LoggerConfig
}

package main as Main {
  class Quotely
}

Parser <- Quotely
Ui <-- Quotely
Quotely -> JsonSerializer
Quotely --> LoggerConfig

Quotely -> CompanyName
Quotely -> QuoteList
Quotely -> QuotelyState

Parser -> Command

Command ..> QuoteList
Command ..> CompanyName
Command ..> QuotelyState
Command .> Ui


Cmd -[hidden]-> Data
@enduml

Quotely -left-> LoggerConfig
Quotely -up-> JsonSerializer
Quotely -> Ui
Quotely --> CompanyName
Quotely -> QuoteList
Quotely --> QuotelyState

Parser --> Command
Command .left> Ui
Command ..> QuoteList
Command ..> CompanyName
Command ..> QuotelyState
```

![Quotely class diagram](./diagrams/class/quotely.png)

### Embedding generated images in docs

If you export to `/docs/diagrams/class`, reference them in Markdown like:

```markdown
![Class Diagram](./diagrams/class/quotely.png)
```

### Tips

- Use `-tsvg` for scalable SVG output instead of PNG.
- Keep shared styling in a separate include and reuse via `!include`.
- Commit generated images if your docs site can’t render PlantUML at build time.

For more, see the [Official docs](https://plantuml.com/en/starting)
