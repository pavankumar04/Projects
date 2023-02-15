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

insert into books (bookid, title, category, author, storeid, price, availability, no_copies) 
values (501, 'Harry Potter and the Philosopher Stone', 'Fantasy', 'J K Rowling', 301,  600.00, true, 10),
(502, 'The Dragon Rider', 'Fantasy', 'Unknown', 305, 750.00, true, 10),
(503, 'Heller with a Gun', 'Western', 'Louis LAmour', 301, 450.00, true, 12),
(504, 'The Californios', 'Western', 'Louis LAmount', 301, 350.00, true, 6),
(505, 'Coma', 'Thriller', 'Robin Cook', 302, 340.00, true, 7),
(506, 'Outbreak', 'Thriller', 'Robin Cook', 302, 310.00, true, 8),
(507, 'Duke and I', 'Romance', 'Julia Quinn', 301, 280.00, true, 5),
(508, 'Ulysses', 'Classic', 'James Joyce', 303, 480.00, true, 2),
(509, 'The Great Gatsby', 'Classic', 'F. Scott Fitzgerald', 302, 500.00, true, 2),
(510, 'Don Quixote', 'Classic', 'Miguel de Cervantes', 303, 650.00, true, 3),
(511, 'Twilight', 'Romance', 'Stephenie Meyer', 301, 610.00, true, 6),
(512, 'Eragon', 'Fantasy', 'Christopher Paolini', 304, 425.00, true, 4);

