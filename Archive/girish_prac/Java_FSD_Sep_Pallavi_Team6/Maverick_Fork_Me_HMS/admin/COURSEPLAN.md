# Course Plan

## Week #1 Learning Goals

  1. Git
     1. setup/clone
  1. Databases
     1. MySQL/DML + Workbench
  1. HTTP 
     1. Curl Basics
  1. Agile Basics
     1. Backlogs, Sprints, Rituals
     1. Epics, User stories, Tasks, Sub-Tasks
     1. Life Cycle

## Week #1 Workshop Goals

  To get a running application from a source repository in git by following step-by-step instructions. The components and technologies will be explained in the weeks to come, but here we just get the basic application up and running.
 
  * Build, and deploy a skeletal application in a development tomcat server + development MySQL/RDS.

  * Demo the build/deployment: Insert a few rows via SQL/Workbench, show that the new rows appear via all the mechanisms below; delete the rows, show that the rows
  do not appear any longer
    * Database via Mysql Workbench
    * Java code via cli
    * REST application war via Curl
    * UI application via browser

## Week #2 Learning Goals

  1. Git
    1. branch, add, commit, push, pull
  1. Databases
    1. MySQL/DDL + Workbench
    1. Databases, Tables, Indexes, Keys and Constraints
    1. Normal Forms
  1. Agile
    1. Estimation: Story Points
    1. Velocity, BurnDown
  1. Java
    1. Types, classes, methods
  1. JDBI
    1. dao, mapper
  1. Build Automation w/ Jenkins
    1. Unit, Integration, Staging  

## Week #2 Workshop Goals

The goals of this week are
  1. To complete the database design
  1. Start on java changes

  1. Design a database schema given the requirements
  1. Add other attributes of the Room java class
  1. Change mapper to map the columns of Room table to Room class
  1. Cli to output other Room attributes
  1. Git add/commit/push/review/merge
  1. Update Integration/Staging databases
  1. Green Pipeline

## Week #3 Learning Goals

  1. Coding Standards
  1. Unit Testing
    1. Coverage
    1. Mocking

## Week #3 Workshop Goals

  1. Junit/Jmockit based tests for Room class
  1. 95% coverage in unit test job
  1. checkstyle PMD,CPD findbugs 

## Week #4 Goals

### Concrete demo-able deliverables

  1. All other classes + JDBI
  1. Cli implemented for all the functionality
  
## Week #5 Goals

### Concrete demo-able deliverables

  1. REST for Room class to return all attributes
  1. RestAssured Tests for the Room APIs
  
## Week #6 Goals

### Concrete demo-able deliverables

  1. REST for all the classes
  1. RestAssured Tests for all the APIs

## Week #7 Goals

### Concrete demo-able deliverables

  1. Angular UI for the Room list

## Week #8 Goals

### Concrete demo-able deliverables

  1. Angular UI for all the functionality
  1. Html,CSS,Typescript
  
## Week #9 Goals
   
### Concrete demo-able deliverables

  1. Selenium Tests
  1. Jasmine
  
