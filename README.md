# Student-Management-System
Java Application with simple user friendly GUI to store,edit,create update and delete student record from the database.

To Run the Applicaton:

Create a Table in Mysql named 'student' in db2 database
 
 SQL QUERY:
 
      CREATE TABLE `student` (
        `rno` int(11) NOT NULL,
        `name` varchar(45) DEFAULT NULL,
        PRIMARY KEY (`rno`)
      ) 

To Run the Program in Command Prompt :

      1.javac -cp mysqljava.jar *.java
      2.java -cp mysqljava.jar;. MainFrame
      
      
