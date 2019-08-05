# Spring Data JPA

## What is JPA ?
Mapping Java objects to database tables and vice versa is called Object-relational mapping (ORM). The Java Persistence API (JPA) is one possible approach to ORM. Via JPA the developer can map, store, update and retrieve data from relational databases to Java objects and vice versa. JPA can be used in Java-EE and Java-SE applications.

JPA is a specification and several implementations are available. Popular implementations are Hibernate, EclipseLink and Apache OpenJPA. The reference implementation of JPA is EclipseLink.

JPA permits the developer to work directly with objects rather than with SQL statements. The JPA implementation is typically called persistence provider.

The mapping between Java objects and database tables is defined via persistence metadata. The JPA provider will use the persistence metadata information to perform the correct database operations.

JPA metadata is typically defined via annotations in the Java class. Alternatively, the metadata can be defined via XML or a combination of both. A XML configuration overwrites the annotations.

For more information about JPA see [JPA tutorial](jpa_turorial.md)
## What is Spring Data JPA?
Spring Data JPA, part of the larger Spring Data family, makes it easy to easily implement JPA based repositories. This module deals with enhanced support for JPA based data access layers. It makes it easier to build Spring-powered applications that use data access technologies.
Implementing a data access layer of an application has been cumbersome for quite a while. Too much boilerplate code has to be written to execute simple queries as well as perform pagination, and auditing. Spring Data JPA aims to significantly improve the implementation of data access layers by reducing the effort to the amount that’s actually needed. As a developer you write your repository interfaces, including custom finder methods, and Spring will provide the implementation automatically.

**Architecture overview**
* Spring Data JPA provides support for creating JPA repositories by extending the Spring Data repository interfaces.
* Spring Data Commons provides the infrastructure that is shared by the datastore-specific Spring Data projects.
* The JPA Provider (like hibernate) implements the Java Persistence API.

![Spring Data JPA architecture](https://3.bp.blogspot.com/-25dgXaEwfjw/W9skvXDdZcI/AAAAAAAAEjI/lHbqfkykUtw3FzzjfEeKxQHEGGxvXBVtgCLcBGAs/s1600/springdatajpalayers.png)

## How to build
 ``` 
mvn clean package
``` 

## How to run
 ``` 
mvn spring-boot:run
 ``` 

## Technologies
* Spring Boot 2.1.2.RELEASE
* Spring 5.1.4.RELEASE
* Hibernate 5.3.7
* HikariCP 3.2.0
* H2 in-memory database 1.4.197
* Maven 3
* Java 8

---------------------------------
**References**
* [Tutorials point](https://www.tutorialspoint.com/jpa/index.htm)
* [Thoughts-on-java](https://thoughts-on-java.org/jpa-generate-primary-keys/)
* [Geeksforgeeks.org](https://www.geeksforgeeks.org/sql-server-identity/)