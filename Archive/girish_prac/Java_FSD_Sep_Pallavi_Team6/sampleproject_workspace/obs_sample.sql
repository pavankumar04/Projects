create database onlinebookstore;
use onlinebookstore;

create table customer(
	customerId bigint primary key,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    address varchar(250) not null,
    phone varchar(12) not null unique,
    email varchar(80) not null unique,
    wallet double not null,
    coupon varchar(25),
    passcode varchar(25) not null
);

create table employee (
	employeeId bigint primary key,
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    phone varchar(12) not null unique,
    email varchar(80) not null unique,
    passcode varchar(25) not null
);

create table books (
	bookId bigint primary key,
    title varchar(150) not null,
    author varchar(100) not null,
    storeId bigint not null,
    category varchar(50) not null,
    availability bool not null default true,
    no_copies int not null,
    price double not null
);

create table stores (
	storeId bigint primary key,
    storename varchar(250) not null,
    city varchar(80) not null,
    state varchar(80) not null
);

create table orders (
	orderId bigint primary key,
    orderdate date not null,
    deliverydate date not null,
    amount double not null,
    bookId bigint not null,
    customerId bigint not null,
    quantity int not null,
    orderstatus varchar(10) not null
);

alter table books add constraint fk_store foreign key (storeid) references stores(storeid);
alter table orders add constraint fk_book foreign key(bookid) references books(bookId);
alter table orders add constraint fk_customer foreign key (customerId) references customer(customerid);

-- alter table customer drop column customer_id;
-- alter table customer drop column first_name;
-- alter table customer drop column last_name;
-- alter table employee drop column employee_id;
-- alter table employee drop column first_name;
-- alter table employee drop column last_name;
-- alter table books drop column book_id;
-- alter table books drop column store_id;
-- alter table orders drop column order_id;
-- alter table orders drop column book_id;
-- alter table orders drop column customer_id;
-- alter table stores drop column store_id;
-- alter table stores drop column store_name;