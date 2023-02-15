create database actordb;
use actordb;

create table actor (
	actorId int primary key,
    firstname varchar(30) not null,
    lastname varchar(30) not null,
    dob date not null,
    phone varchar(12) not null unique,
    fees double not null);
    
alter table actor add column gender varchar(10) not null;

create table courses (
	courseId int primary key,
    title varchar(40) not null,
    description varchar(100) not null
    );