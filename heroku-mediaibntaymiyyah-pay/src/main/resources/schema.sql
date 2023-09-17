-- author
create table IF NOT EXISTS Author (
	id serial primary key,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	email varchar(255) not null,
	username varchar(100) not null
);

-- post
create table IF NOT EXISTS Post (
	id serial primary key,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	email varchar(255) not null,
	username varchar(100) not null
);

-- comment
create table IF NOT EXISTS Comment (
	id serial primary key,
	first_name varchar(100) not null,
	last_name varchar(100) not null,
	email varchar(255) not null,
	username varchar(100) not null
);