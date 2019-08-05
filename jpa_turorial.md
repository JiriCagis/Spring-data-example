# Java JPA

## What is it?
Java Persistence API is a collection of classes and methods to persistently store the vast amounts of data into a database. 

Any enterprise application performs database operations by storing and retrieving vast amounts of data. Despite all the available technologies for storage management, application developers normally struggle to perform database operations efficiently.

Generally, Java developers use lots of code, or use the proprietary framework to interact with the database, whereas using JPA, the burden of interacting with the database reduces significantly. It forms a bridge between object models (Java program) and relational models (database program).

## Where to use JPA?
To reduce the burden of writing codes for relational object management, a programmer follows the ‘JPA Provider’ framework, which allows easy interaction with database instance. Here the required framework is taken over by JPA.

![](https://www.tutorialspoint.com/jpa/images/jpa_provider.png)

## JPA History
Earlier versions of EJB, defined persistence layer combined with business logic layer using javax.ejb.EntityBean Interface.

While introducing EJB 3.0, the persistence layer was separated and specified as JPA 1.0 (Java Persistence API). The specifications of this API were released along with the specifications of JAVA EE5 on May 11, 2006 using JSR 220.

JPA 2.0 was released with the specifications of JAVA EE6 on December 10, 2009 as a part of Java Community Process JSR 317.

JPA 2.1 was released with the specification of JAVA EE7 on April 22, 2013 using JSR 338.

## JPA Providers
JPA is an open source API, therefore various enterprise vendors such as Oracle, Redhat, Eclipse, etc. provide new products by adding the JPA persistence flavor in them. Some of these products include: Hibernate, Eclipselink, Toplink, Spring Data JPA, etc.

## Architecture
Java Persistence API is a source to store business entities as relational entities. It shows how to define a PLAIN OLD JAVA OBJECT (POJO) as an entity and how to manage entities with relations.

### Class Level architecture
The following image shows the class level architecture of JPA. It shows the core classes and interfaces of JPA.

![](https://www.tutorialspoint.com/jpa/images/jpa_class_level_architecture.png)

The following table describes each of the units shown in the above architecture.

|Units|Description|
|-----|-----------|
|EntityManagerFactory|This is a factory class of EntityManager. It creates and manages multiple EntityManager instances.
|EntityManager|It is an Interface, it manages the persistence operations on objects. It works like factory for Query instance.
|Entity|Entities are the persistence objects, stores as records in the database.
|EntityTransaction|It has one-to-one relationship with EntityManager. For each EntityManager, operations are maintained by EntityTransaction class.
|Persistence|This class contain static methods to obtain EntityManagerFactory instance.
|Query|This interface is implemented by each JPA vendor to obtain relational objects that meet the criteria.

The above classes and interfaces are used for storing entities into a database as a record. They help programmers by reducing their efforts to write codes for storing data into a database so that they can concentrate on more important activities such as writing codes for mapping the classes with database tables.


### JPA Class Relations
In the above architecture, the relations between the classes and interfaces belong to the javax.persistence package. The following diagram shows the relationship between them.

![](https://www.tutorialspoint.com/jpa/images/jpa_class_relationships.png)

* The relationship between EntityManagerFactory and EntityManager is one-to-many. It is a factory class to EntityManager instances.
* The relationship between EntityManager and EntityTransaction is one-to-one. For each EntityManager operation, there is an EntityTransaction instance.
* The relationship between EntityManager and Query is one-to-many. Many number of queries can execute using one EntityManager instance.
* The relationship between EntityManager and Entity is one-to-many. One EntityManager instance can manage multiple Entities.

## Object Relational Mapping
Object Relational Mapping (ORM) briefly tells you about what is ORM and how it works. ORM is a programming ability to covert data from object type to relational type and vice versa.

![](https://www.tutorialspoint.com/jpa/images/object_relational_mapping.png)

**Phase1**

The first phase, named as the Object data phase contains POJO classes, service interfaces and classes. It is the main business component layer, which has business logic operations and attributes.

For example let us take an employee database as schema-

Employee POJO class contain attributes such as ID, name, salary, and designation. And methods like setter and getter methods of those attributes.

Employee DAO/Service classes contains service methods such as create employee, find employee, and delete employee.

**Phase2**

The second phase named as mapping or persistence phase which contains JPA provider, mapping file (ORM.xml), JPA Loader, and Object Grid.

JPA Provider : The vendor product which contains JPA flavor (javax.persistence). For example Eclipselink, Toplink, Hibernate, etc.

Mapping file : The mapping file (ORM.xml) contains mapping configuration between the data in a POJO class and data in a relational database.

JPA Loader : The JPA loader works like cache memory, which can load the relational grid data. It works like a copy of database to interact with service classes for POJO data (Attributes of POJO class).

Object Grid : The Object grid is a temporary location which can store the copy of relational data, i.e. like a cache memory. All queries against the database is first effected on the data in the object grid. Only after it is committed, it effects the main database.

**Phase 3**

The third phase is the Relational data phase. It contains the relational data which is logically connected to the business component. As discussed above, only when the business component commit the data, it is stored into the database physically. Until then the modified data is stored in a cache memory as a grid format. Same is the process for obtaining data.

The mechanism of the programmatic interaction of above three phases is called as object relational mapping.

## Java Bean Standard
Java class, encapsulates the instance values and behaviors into a single unit callled object. Java Bean is a temporary storage and reusable component or an object. It is a serializable class which has default constructor and getter & setter methods to initialize the instance attributes individually.

* Bean contains the default constructor or a file that contains serialized instance. Therefore, a bean can instantiate the bean.
* The properties of a bean can be segregated into Boolean properties and non-Boolean properties.
* Non-Boolean property contains getter and setter methods.
* Boolean property contain setter and is method.
* Getter method of any property should start with small lettered ‘get’ (java method convention) and continued with a field name that starts with capital letter. E.g. the field name is ‘salary’ therefore the getter method of this field is ‘getSalary ()’.
*Setter method of any property should start with small lettered ‘set’ (java method convention), continued with a field name that starts with capital letter and the argument value to set to field. E.g. the field name is ‘salary’ therefore the setter method of this field is ‘setSalary (double sal)’.
* For Boolean property, is method to check if it is true or false. E.g. the Boolean property ‘empty’, the is method of this field is ‘isEmpty ()’.

## Relations
**ManyToOne Relation**
 
It between entities where one entity (column or set of columns) is/are referenced with another entity (column or set of columns) which contain unique values. In relational databases these relations are applicable by using foreign key/primary key between tables.

Let us consider an example of relation between Employee and Department entities. In unidirectional manner, i.e.from Employee to Department, Many-To-One relation is applicable. That means each record of employee contains one department id, which should be a primary key in Department table. Here in the Employee table, Department id is foreign Key.

![](https://www.tutorialspoint.com/jpa/images/many_to_one_relation.png)

**OneToMany Relation**

In this relationship each row of one entity is referenced to many child records in other entity. The important thing is that child records cannot have multiple parents. In a one-to-many relationship between Table A and Table B, each row in Table A is linked to 0, 1 or many rows in Table B.

Let us consider the above example. If Employee and Department is in a reverse unidirectional manner, relation is Many-To-One relation.

**OneToOne Relation**

In One-To-One relationship, one item can belong to only one other item. It means each row of one entity is referred to one and only one row of another entity.

Let us consider the above example. Employee and Department in a reverse unidirectional manner, the relation is One-To-One relation. It means each employee belongs to only one department.

**ManyToMany Relation**

Many-To-Many relationship is where one or more rows from one entity are associated with more than one row in other entity.

Let us consider an example of relation between Class and Teacher entities. In bidirectional manner, both Class and Teacher have Many-To-One relation. That means each record of Class is referred by Teacher set (teacher ids), which should be primary keys in Teacher table and stored in Teacher_Class table and vice versa.

![](https://www.tutorialspoint.com/jpa/images/many_to_many_relation.png)
## ID generators
The JPA specification supports 4 different primary key generation strategies which generate the primary key values programmatically or use database features, like auto-incremented columns or sequences. The only thing you have to do is to add the @GeneratedValue annotation to your primary key attribute and choose a generation strategy.

**AUTO**: The GenerationType.AUTO is the default generation type and lets the persistence provider choose the generation strategy.
If you use Hibernate as your persistence provider, it selects a generation strategy based on the database specific dialect. For most popular databases, it selects GenerationType.SEQUENCE which I will explain later.  

**IDENTITY**: The GenerationType.IDENTITY is the easiest to use but not the best one from a performance point of view. It relies on an auto-incremented database column and lets the database generate a new value with each insert operation. From a database point of view, this is very efficient because the auto-increment columns are highly optimized, and it doesn’t require any additional statements.

**SEQUENCE**: The GenerationType.SEQUENCE is my preferred way to generate primary key values and uses a database sequence to generate unique values.
              It requires additional select statements to get the next value from a database sequence. But this has no performance impact for most applications and it is fast.
              
 **TABLE**: The GenerationType.TABLE gets only rarely used nowadays. It simulates a sequence by storing and updating its current value in a database table which requires the use of pessimistic locks which put all transactions into a sequential order. This slows down your application, and you should, therefore, prefer the GenerationType.SEQUENCE, if your database supports sequences, which most popular databases do.
 
 
## Eager and Lazy Loading
The main concept of JPA is to make a duplicate copy of the database in cache memory. While transacting with the database, first it will effect on duplicate data and only when it is committed using entity manager, the changes are effected into the database.

There are two ways of fetching records from the database - eager fetch and lazy fetch.

**Eager fetch**: Fetching the whole record while finding the record using Primary Key.

**Lazy fetch**: It checks for the availability of notifies it with primary key if it exists. Then later if you call any of the getter method of that entity then it fetches the whole.

But lazy fetch is possible when you try to fetch the record for the first time. That way, a copy of the whole record is already stored in cache memory. Performance wise, lazy fetch is preferable.

---------------------------------
**References**
* [Tutorials point](https://www.tutorialspoint.com/jpa/index.htm)
* [Thoughts-on-java](https://thoughts-on-java.org/jpa-generate-primary-keys/)
* [Geeksforgeeks.org](https://www.geeksforgeeks.org/sql-server-identity/)