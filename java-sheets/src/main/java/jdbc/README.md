# JDBC Example

**Preconditions:**
- download and install mysql from https://dev.mysql.com/downloads/installer/
 "select default developer -> create user and password "root", "qwe1rty2" -> "
- download and install https://dev.mysql.com/downloads/workbench/
- start my sql server 
- open workbench and go to https://monosnap.com/file/a8TRROIW8NhtETYbtTUcuQcfiryQ86
- create new sql file and add to it :
     CREATE DATABASE Business;
 
     use Business;
 
     CREATE TABLE CustomerInfo
 
     (CourseName varchar(50),
 
     PurchasedDate date,
 
     Amount int(50),
 
     Location varchar(50));
 
     INSERT INTO CustomerInfo values("selenium",CURRENT_DATE(),120,'Africa');
 
     INSERT INTO CustomerInfo values("Protractor",CURRENT_DATE(),45,'Africa');
 
     INSERT INTO CustomerInfo values("Appium",CURRENT_DATE(),99,'Asia');
 
     INSERT INTO CustomerInfo values("WebServices",CURRENT_DATE(),21,'Asia');
 
     INSERT INTO CustomerInfo values("Jmeter",CURRENT_DATE(),76,'Asia');
 
     select * from CustomerInfo where CourseName = "Jmeter";
     
- then click on execute query (you should see result : 'Jmeter', '2020-07-20', '76', 'Asia')

JAVA

- add maven dependency for connection to jdbc mysql  https://mvnrepository.com/artifact/mysql/mysql-connector-java
- create connection to your DB Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Business?serverTimezone=UTC&useSSL=false", "root", "qwe1rty2");
- create Statament obj for execute queries Statement statement = connection.createStatement();
- Write result of query to  ResultSet result = statement.executeQuery("select * from CustomerInfo where CourseName = 'Jmeter';");
- use result.next() method for get row of object 
- result.getString({column num}) method to get column value where {column num} column number
- use connection.close() for closing connection

Serialize to obj
- create pojo class with getters and setters CustomerDetailsPOJO
- set all fields using setters to CustomerDetailsPOJO by loop (while(result.next()))
---- serialize using jackson ----
- add maven dependencies jackson-core , jackson-databind, jackson-annotations
- write json to file using ObjectMapper obj writeValue();
- create multiply json using simple json maven lib https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1.1  and maven gson lib
- for deserialize to object from file you should use objectMapper.readValue(jsonFile, CustomerDetailsPOJO.class)

all examples you can find in java/main/jdbc package












