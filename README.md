# javaStuffPublic

## Example code with H2 MEM and Spring Boot Vers 3.3.1

* jpa Bean Configuration for the Datasource

  * Project: [/db/jpa/jpa1](./db/jpa/jpa1)
  * application.yaml not need configuration in in the Bean Configuration
* jpa with Xml Configuration

  * Project: [/db/jpa/jpa2](./db/jpa/jpa2)
* jpa with Autoconfiguration

  * Project: [/db/jpa/jpa3](./db/jpa/jpa3)
* r2dbc Reactive Relational Database Conectivity

  * Project: [/db\r2dbc](db\r2dbc)
* React Frontend for the above Examples

  * Project: [/db/r2dbc](./db/r2dbc)


## Maven Multi Module Configuration
[Video: YouTube](https://youtu.be/Es8U1ur1uqo)
Maven call for paralell build and skip test for the moment
```console
mvn -T 4 -Dmaven.test.skip=true  clean package
```

## Example with Lambda

Example of Future with Executor Service and multi line Lambda

<u>Usecase:</u> Get even and odd number from a list
File: [lambda/src/main/java/streams/Ex1.java](./lambda/src/main/java/streams/Ex1.java)

## Examples with Streams

Get two separate List from one over streams.

<u>Usecase:</u> Get even and odd number from a list
File: [streams/src/main/java/streams/Ex1.java](./streams/src/main/java/streams/Ex1.java)

[Video: YouTube](https://youtu.be/o2f2jfcMXUE)

---

Add the content from a list to an other list as streams.

<u>Usecase:</u> Store in one field Student Name with a course.

File: [streams/src/main/java/streams/Ex2.java](./streams/src/main/java/streams/Ex2.java)

[Video: YouTube](https://youtu.be/XTp2zJv93mw)

---

Example for Filtering Lists with Streams

Add Elements to a list with Streams.

Remove Elements from a list with Streams.

File: [streams/src/main/java/streams/Ex3.java](./streams/src/main/java/streams/Ex3.java)

## More Information in [RemoveElements.pdf](./RemoveElements.pdf)
