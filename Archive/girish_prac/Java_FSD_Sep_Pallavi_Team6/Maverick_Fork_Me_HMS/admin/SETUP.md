# This readme is for the administrators of the Mavericks program

## Pre training start

  * Sort the teams into 2 batches of 25, then into teams of 5 each
    * CS/Non-CS folks
    * Scores equally distributed
    * Gender distribution
  * Create  repository for the 10 teams
    * Make sure that ftp-fork-me does not have any branches
    * Go to https://635681506020.signin.aws.amazon.com/console.com
      * create a group for each team : MLPnn
      * create a repository for each team : MLPnn
        * Add FTP-Admins as a group w/ Admin access, and MLPnn team w/ R/W to these repositories
    * `git clone --bare ssh://git-codecommit.us-east-2.amazonaws.com/v1/repos/MLPXX`
    * 'cd MLPXX`
    * For each team, nn = 01 to 10
      * `git push --mirror ssh://git-codecommit.us-east-2.amazonaws.com/v1/repos/MLPnn.git`
    * For each team, nn = 01 to 10
      * from the workspace
      * For windows
        * `git clone ssh://git-codecommit.us-east-2.amazonaws.com/v1/repos/MLPnn.git`
        * cd MLPnn
        * use VS Code, find/replace in files to do the following: replacing MLPXX -> MLPnn, MLPXX -> MLPnn
        * Rename directory restservice/leavemanager/src/main/java/com/hexaware/MLPXX/ to restservice/leavemanager/src/main/java/com/hexaware/MLPnn/
      * For Mac OS; replace nn with the team-id in the following three commands; use xxnn.sh
        * `git clone ssh://git-codecommit.us-east-2.amazonaws.com/v1/repos/MLPnn.git`
        * `cd MLPnn`      
        * `find . -type f -not -path '*/\.*' -not -path "*/node_modules/*" -exec sed -i '' -e 's/MLPXX/mlp[nn]/g' {} \; -exec sed -i '' -e 's/MLPXX/mlp[nn]/g' {} \;`
        * `mv restservice/leavemanager/src/main/java/com/hexaware/MLPXX/ restservice/leavemanager/src/main/java/com/hexaware/mlp[nn]/`
        * `mv restservice/leavemanager/src/test/java/com/hexaware/MLPXX/ restservice/leavemanager/src/test/java/com/hexaware/mlp[nn]/`
        * `mv restservice/integration-test/src/test/java/com/hexaware/MLPXX restservice/integration-test/src/test/java/com/hexaware/mlp[nn]`
      * `git add restservice/leavemanager/src/main/java/com/hexaware/mlp[nn]/ restservice/leavemanager/src/test/java/com/hexaware/mlp[nn]/ restservice/integration-test/src/test/java/com/hexaware/mlp[nn]`
      * `git commit -a -m "replacing xx with the team number"`
      * `git push origin HEAD`
      * `git clean -f`
      
    * Add the .pub key from jenkins home/.ssh directory for this team as the repository's deploy key
    * [TBD: This has to be done on day1] Add each team member to the team's git repository
  * Create Scrum teams corresponding to the 10 teams
    * Add each team member to the team's GITHUB Project Board group 
  * Staging and Integration ec2 instances
    * Use the instructions in JENKINS.md to spin up the instances, stop iptables, yum install and install jdk
    * Install tomcat
      * As centos, in /home/centos, wget "http://www-us.apache.org/dist/tomcat/tomcat-8/v8.5.23/bin/apache-tomcat-8.5.23.tar.gz", "tar -xvzf apache-tomcat-8.5.23"
      * Edit bin/startup.sh, add "export DB_CONNECTION=[rds-host]:3306"
      * Edit webapps/manager/META-INF/context.xml and comment out the valve which restricts access to localhost only
      * Edit conf/tomcat-users.xml and add roles manager-gui and manager-script, with a user "manager"/"manager" with access to both these roles 
  * Databases - 3 per team
    * Integration and Staging instances
      * `export PATH=$PATH:/Applications/MySQLWorkbench.app/Contents/MacOS`
      * `mysql -u root -po7Vb6H4bcrnC -h ftp-integration.c1jpaaszplju.us-east-1.rds.amazonaws.com`
      * 
    * `CREATE DATABASE MLPXX;` -- XX from 01 to 10
    * `CREATE USER 'MLPXX'@'%' IDENTIFIED BY 'MLPXX';`
    * `GRANT ALL ON MLPXX.* TO 'MLPXX'@'%';`
    * `select Host, User, Password from mysql.user order by user;`
    * `select * from mysql.db order by Db;`
  * Jenkins jobs - 3 per team
    * MLPXX-10-UNIT
    * MLPXX-30-INTEGRATION
    * MLPXX-50-STAGING
    * For each team, nn = 01 to 10
      * Create a tab MLPnn
      * Create New Item, for stage = 10-UNIT, 30-INTEGRATION, and 50-STAGING
        * Free Style Project
        * Copy from MLPnn-{stage}, "Add to current view" checked
        * Change all xx to nn in the job fields  
        * For the unit job, change the git repository as well; if the credentials are not yet added, you can add them now

# Week #1 Day #1
  * Go to https://console.aws.amazon.com/codecommit,  and clone the repo through GitBash 
  

## Setup Trello Project Board

The users are expected to login  through {Hexaware-id}-.hexaware@gmail.com id at Trello 

Create a "MLPXX" as project board and add users through add members link at Trello board

Create Sprint Backlog as list and include various tasks as cards
Assign each task to members (add member button) with due date mentioned  
