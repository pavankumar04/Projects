create database BMS75689;
use BMS75689;

create table Admin (
adminId int primary key,
adminName varchar(20) not null,
adminEmail varchar(30) not null,
adminPassword varchar(40) not null);

insert into admin values (1, 'admin', 'admin@123', 'admin');

create table Account (
accountNumber int primary key,
email varchar(30) not null,
password varchar(40) not null,
role varchar(40) not null,
balance double not null);
select* from account;
insert into account values(123456, 'nik@123', 'Nik','savings', 25000);

create table Transactions (
transactionId int primary key,
accountNumber int not null  ,
transactionType varchar(30) not null default "debit",
transactionStatus varchar(30) not null ,
secondAccount int not null ,
transactionDate date not null
);


select* from Transactions;

create table Users (
firstName varchar(30) not null,
lastName varchar(40) not null,
email varchar(40) not null unique,
phoneNumber int primary key ,
panNumber int not null,
aadharNumber int not null,
address varchar(200)not null ,
city varchar(20)not null );

insert into users values ('girish', 'reddy' ,'girish@123', 807451378,10384293,1234567, 'isckon city','Nellore');
select * from Users;
select * from Admin;

create table Recepient(
name varchar(20) not null ,
phonenumber int primary key,
accountNumber int
);
select * from recepient;
insert into recepient values ('nik', 809809, 1234567);