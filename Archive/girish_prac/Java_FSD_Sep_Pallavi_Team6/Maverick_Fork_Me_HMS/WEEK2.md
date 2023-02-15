# Week #2: Course Materials
  * MySql database
  * Design the schema for the HMS requirement
  * Create and execute all the tables

The objective of week #2 is to get the cli working with showing Room details - Room Type and Room cost. From this week onwards, we will be doing sprint planning and sprint review/retrospective every week.

## Java (Will be continued in Week#3 as well)

## Maven

## JDBI

# Week #2: Workshop Day #1 - Create the development database, table and populate it
  * Create Trello  Project Board for all the work to be done in Week #2 
    * Create  task for database design changes  
       * A "Card" should  be included to describe the below task in the Sprint Backlog (board) 
          * Task : "Create a database design for the hotel management application", and 
          * Ticket Number (manually typed) shoudld be included as prefix in the Task           
       * A "Card" should be included to describe the below task in the Sprint Backlog 
          * Task: "Change the model/Room java class for the columns identified"
       * A "Card" should be included to desribe the below task in the Sprint Backlog
          * Task: "Change the persistence/Room DAO/mapper java classes for the new attributes"           
          * Ticket Number (manually typed) shoudld be included as prefix in the Task  
       * A "Card" should be included to desribe the below task in the Sprint Backlog
          * Task: "Change the Util.CliMain java class for the new attributes"  
          * Ticket Number (manually typed) shoudld be included as prefix in the Task                 
  * Ensure that once after creating all your task moved to "To do" column in the project board
  * Move the task for "To do" to "In Progress" column and start your task  
  * Database Design
     * Edit Database.ddl for two tables: Booking and Room_Allocation
        * Use the "STANDARDS_AND_GUIDELINES.md" file for the naming conventions to be followed.
     * Edit Database.dml to insert data into the Booking table; The Room_Allocation table can be blank to start with.
     * Run the ddls and dmls against your local mysql server
     * Push the changes to remote branch
     * Now, the other team members can pull from branch and run the ddl/dml against their local databases
     * Follow the process for completing the review. and merging & cleanup
  * Re-run the Cli, the Curl and the Browser UI to see the changed data in all three interfaces

# Week #2: Workshop Day #2-5

  * Complete the other tickets
  * At the end, the cli should show all the new attributes added.
    * At this point, you must be able to compile ```mvn compile``` and run the cli ```mvn exec ...```, but other command i.e., ```mvn package``` etc will fail because of lack of code coverage etc.
  * You should have added some unit tests as well.
     
# Reading material

## Must-Read

### Java
  * https://docs.oracle.com/javase/tutorial/getStarted/index.html
  * https://docs.oracle.com/javase/tutorial/java/index.html
   
### JDBI
  * http://jdbi.org/#_declarative_api
  * http://jdbi.org/#_sql_objects
  
### Junit/Jmockit
  * https://github.com/junit-team/junit4/wiki/Getting-started
  * https://github.com/junit-team/junit4/wiki/Assertions
  * http://jmockit.org/
  * http://jmockit.org/gettingStarted.html
  
### Maven
  * https://javapapers.com/jee/maven-in-10-minutes/

## Nice-To-Read

### Java
  * https://docs.oracle.com/javase/tutorial/essential/index.html
  * https://docs.oracle.com/javase/tutorial/collections/index.html
  
### Junit/Jmockit
  * http://jmockit.org/tutorial/Mocking.html
  * http://jmockit.org/tutorial/Faking.html
  
## Go-Deep

### Java
  * https://www.udemy.com/java-tutorial/
  * https://www.javatpoint.com/java-tutorial

  
