# Graphql-Kotlin-MySQL
A demo showing how to set up a GraphQL API backed by Liquibase + MySQL. This is a work in progress and is a product of my learning. Hopefully it it helpful to others trying to accomplish the same!

Currently, querying payments by claimId does not work, and is causing querying the payments of returned claims to also fail. Hopefully this is resolved shortly!

NoSQL more your thing? Check out the [MongoDB version](https://github.com/mikebly/graphql-kotlin-mongo) of this demo!

### Getting Started
- To get started, you can scaffold a project using SpringInitializr by starting a new Maven
 project and selecting the "Web" and "Spring StartJPA" dependencies.
- Next, include the following dependencies in your `pom.xml`:
    - These will provide the tools necessary to implement GraphQL queries, mutations, and resolvers.
    - It will also allow the application to find schema files anywhere in the class-path
```
        <!--LIQUIBASE-->
        <dependency>
            <groupId>org.liquibase</groupId>
            <artifactId>liquibase-core</artifactId>
        </dependency>

        <!--GRAPH-QL-->
        <dependency>
            <groupId>com.graphql-java-kickstart</groupId>
            <artifactId>graphql-spring-boot-starter</artifactId>
            <version>5.7.3</version>
        </dependency>
        <dependency>
            <groupId>com.graphql-java-kickstart</groupId>
            <artifactId>graphiql-spring-boot-starter</artifactId>
            <version>5.7.3</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.graphql-java-kickstart</groupId>
            <artifactId>graphql-java-tools</artifactId>
            <version>5.4.0</version>
        </dependency>

        <!--DATABASES H2 & MYSQL-->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.16</version>
        </dependency>
```
- Define the database type and ports in `application.yml`:
```
server:
  port: 8080

# SPRING
spring:
  liquibase:
    change-log: classpath:/liquibase-changelog.xml
    enabled: true
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    hibernate:
      ddl-auto: none
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```
- Set local properties for SpringBoot in `application-local.yml`:
```
#SSL
server.port: 8080
server:
  ssl:
    enabled: false

#SPRING
spring:
  profiles:
    active: local
  datasource:
    url: jdbc:mysql://localhost:3306/graphQlClaims?createDatabaseIfNotExist=true&allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC
    username: your MySQL username
    password: your MySQL password
```
### Project Packages & Information
#### Packages
- `dao`: Holds database entity definitions and respositories, along with their respective implementation classes
- `dto`: Data classes representing the table entities, for use in processing
- `resolvers`: GraphQL resolver classes. Responsible for making queries and mutations
on the repositories
- `resources/graphql`: Holds schema files (`.graphqls`) that define the available queries and mutations
#### Other Info
- You may need to set the global timezone of the MySQL server. To do this, go to MySQL workbench (or equivalent), and run the follow query: `SET GLOBAL time_zone = '-4:00';`, or whatever timezone you may be in.
- The function names defined in your query and mutation resolvers must match the names defined in your 
schema files 
- To test your GraphQL API, navigate to http://localhost:8080/graphiql
    - You will be able to write GraphQL queries and mutations from this dashboard
    - There is also a view of the queries and mutations available on the API from this dashboard
- Exmaples queries/mutations:
```

mutation{
  newClaim(claimId:"C1234", lossDate:"07-13-2019"){
    lossDate: lossDate,
    claimId: claimId
  }  
  addNewPayment(paymentNum:"P1234",claimId:"C1234",claimantFullName:"Billy Bob"){
    paymentNumber: paymentNumber,
    claimId: claimId,
    claimantFullName: claimantFullName
  }
}
  
query{
  getClaimById(id:"C1234"){
    claimId:claimId
  }
  getPaymentByNumber(num:"P1234"){
    paymentNumber:paymentNumber
  }
}
  
```
