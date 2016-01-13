## Vert.x 3.1 & Play-twirl 1.1 to show openlayer map with wiki-text2speech link. 

### Steps to test 

**Build "*.classes"**

    ```$ gradle compileScala```

**Run "test"**

    ```$ gradle run```

Now point your browser at http://localhost:8080

**Open in "intellij idea"**   # Build first

    ```
    $ open intellij                                       # use >15.0.2 with scala and gradle plugin
    $$ File/import path/to/de.jwausle.vertx.first
    $$ Build/Make Project                                 # must compile without ERRORs
    -   on source-level error: check 'File/Project Structure/SDKs'      # 1.8 requiered
        FIX: select 1.8 SDK
    -   on compile error:      check 'File/Project Structure/Libraries' # maybe wrong gradle paths
        FIX: update paths
    $$ Right-Click ServerRunner.java/Run                  # start the server
    ```

Now point your browser at http://localhost:8080

### Structure

```
.
|-- README.md                                      # this doc:)
|-- build.gradle                                   # gradle build config
|-- settings.gradle
|-- de.jwausle.vertx.first.iml                     # intellij conf
|-- de.jwausle.vertx.first.ipr
|-- de.jwausle.vertx.first.iws
`-- src
    |-- gen
    |   `-- twirl                                  # generated scala from src/main/twirl
    |       `-- html
    |           `-- hello.template.scala
    `-- main
        |-- java                                   # the java8 vertx code
        |   `-- de
        |       `-- jwausle
        |           `-- vertx
        |               |-- Server.java
        |               `-- ServerRunner.java
        `-- twirl
            `-- hello.scala.html                   # play/twirl template

```

### Future 

You may also run the fat jar as a standalone runnable jar:

    java -jar build/libs/gradle-simplest-3.2.0-fat.jar

(You can take that jar and run it anywhere there is a Java 8+ JDK. It contains all the dependencies it needs so you
don't need to install Vert.x on the target machine).

