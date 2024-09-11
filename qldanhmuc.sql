CREATE DATABASE session16_jdb;
USE session16_jdb;
CREATE TABLE category(
	id int primary key auto_increment,
    name varchar(100) NOT NULL,
    status bit(1) default 1
);