# POS System [Layered-JPA with Maven]

In this **POS System** has all the functionalities of a POS system, like customer adding,item management,order placing,order viewing and order searching.It consists of five main parts;

    * Manage customers
    * Manage items
    * Placeorders
    * View orders
    * Search orders

## Dependencies

* [JFoenix](https://mvnrepository.com/artifact/com.jfoenix/jfoenix/8.0.10) - is an open source Java library, that implements Google Material Design using Java components.
* [MySQL Connector](https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.21) - MySQL Connector/J is the official JDBC driver for MySQL.
* [Project Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.12) - Project Lombok is a java library that automatically plugs into your editor and build tools, spicing up your java.
                                                                                          Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables and etc;
* [Hibernate Core](https://mvnrepository.com/artifact/org.hibernate/hibernate-core/5.4.21.Final) - **Hibernate** reduces lines of code by maintaining object-table mapping(ORM) itself and returns result to application in form of Java objects. It relieves programmer from manual handling of persistent data, hence reducing the development time and maintenance cost.                                                                                          

## Maven

> Maven is project/build management tool.
  
  Instead of downloading and placing the jars manually in the project, we can use maven to automate the process. We can define the dependency in the **pom.xml (Project object model)**. Maven requires internet to download the jars, which is a one time process.

## JPA

 Java Persistence API **(JPA)** defines the management of relational data in the Java applications. Hibernate is an Object-Relational Mapping (ORM) tool which is used to save the state of Java object into the database. It is just a specification. Various ORM tools implement it for data persistence.

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)
