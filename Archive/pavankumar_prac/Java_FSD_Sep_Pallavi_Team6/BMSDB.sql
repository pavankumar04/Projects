
-- drop database bmsdb;

create database bmsdb;

use bmsdb;

create table User
(
    userId int not null primary key,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    username varchar(50) not null,
    password varchar(20) not null,
    email varchar(50) not null unique,
    phoneNo varchar(20) not null unique,
    panNo varchar(20) not null unique,
    dob date not null,
    aadharNo varchar(20) not null unique,
    address varchar(100) not null,
    city varchar(50) not null
);


create table Appointment 
(
    apptId int not null,
    userId int not null,
	-- name varchar(50),
    -- email varchar(50),
    -- phoneNo varchar(20),
    -- time varchar(20),
    date DATETIME not null DEFAULT CURRENT_TIMESTAMP,
    description varchar(50) not null
);


ALTER TABLE Appointment  
ADD CONSTRAINT FK_userId_Appointment
FOREIGN KEY (userId) REFERENCES User(userId);


create table Recepient 
(
    rcptId int not null,
    acctNo bigint not null,
	name varchar(50) not null,
    phoneNo varchar(20) not null, 
    bankType enum("SAME","DIFFERENT") not null
);


create table Admin
(
	adminId int not null,
    adminName varchar(50) not null,
    Email varchar(50) not null,
    Password varchar(20) not null
  
);


create table Account
(   
    acctNo bigint not null primary key,
    acctType enum("SALARY", "SAVINGS", "CURRENT") not null,
    userId int not null,
    balance double not null default 0
);

ALTER TABLE Account 
ADD CONSTRAINT FK_userId_Account
FOREIGN KEY (userId) REFERENCES User(userId);


create table Transaction
(
	txnId varchar(50) not null,
	acctNo bigint not null,
    othersAcct bigint not null,
    txnDate DATE not null,
    txnType enum("DEPOSIT", "WITHDRAWL") not null,
    txnAmount double not null,
    balance double not null 
);

ALTER TABLE Transaction
ADD CONSTRAINT FK_acctNo_Transaction
FOREIGN KEY (acctNo) REFERENCES Account(acctNo);










-- DATA FOR USER TABLE

insert into user values(30001, "kishore", "varma", "varma02", "login12", "kishore34@gmail.com", "9024845638", "HWUDI7728D", "1998-03-12", "234582639274", "2nd road in juhu street", "Delhi");
insert into user values(30002, "abdul", "hussain", "abdul54", "login21", "abdul87@gmail.com", "8294759371", "KWIST9385P", "1992-06-24", "396598429183", "opposite bandar road", "kolkata");
insert into user values(30003, "prashanth", "kishore", "kishore22", "login12", "prashanth45@gmail.com", "9573957421", "OPKDU6394K", "1996-04-01", "398475931634", "beside kites street", "banglore");
insert into user values(30004, "kiran", "kumar", "kiran54", "login21", "kiran4@gmail.com", "9387493745", "KUEIF9467E", "1998-09-28", "747398749274", "3rd building ispot", "chennai");
insert into user values(30005, "lokesh", "raj", "raj3", "login12", "raj4@gmail.com", "8564937232", "NJAYG9375T", "1999-02-22", "827493774958", "koroke street", "mumbai");


-- DATA FOR APPOINTMENT TABLE

insert into appointment(apptId, userId, description) values(60001, 30003, "loan");
insert into appointment(apptId, userId, description) values(60002, 30001, "deposit");
insert into appointment(apptId, userId, description) values(60003, 30004, "paying dues");


-- DATA FOR RECEPIENT TABLE

insert into recepient values(40001, 9000022233, "kishore", "9024845638", "SAME");
insert into recepient values(40002, 9000011122, "mouli", "9024845638", "SAME");
insert into recepient values(40003, 3000222244, "ravi", "8764859384", "DIFFERENT");
insert into recepient values(40004, 8202839993332, "hammedh", "9947364933", "DIFFERENT");


-- DATA FOR ADMIN TABLE

insert into admin values(10001, "lokesh", "loki@gmail.com", "login12");
insert into admin values(10002, "kishore", "kishore99@gmail.com", "login21");


-- DATA FOR ACCOUNT TABLE

insert into account(acctNo, acctType, userId) values(9000011122, "SAVINGS", 30002);
insert into account(acctNo, acctType, userId) values(9000022233, "SAVINGS", 30001);
insert into account(acctNo, acctType, userId) values(9000033344, "SAVINGS", 30004);
insert into account(acctNo, acctType, userId) values(9000044455, "CURRENT", 30003);
insert into account(acctNo, acctType, userId) values(9000055566, "SAVINGS", 30003);
insert into account(acctNo, acctType, userId) values(9000066677, "SAVINGS", 30005);
insert into account(acctNo, acctType, userId) values(9000077788, "SALARY", 30005);


-- DATA FOR TRANSACTION TABLE

insert into transaction(txnId, acctNo, othersAcct, txnDate, txnType, txnAmount, balance) values(50001, 9000022233, 9000022233,"2019-03-21", "DEPOSIT", 1000, 1000);





