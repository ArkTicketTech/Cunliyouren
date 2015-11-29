create database clyr;

use clyr;

create table admin(
	adminName varchar(10),
	password varchar(20)
);

create table product(
	pId integer not null primary key AUTO_INCREMENT,
	productName varchar(30),
	price double,
	unit varchar(10),
	description varchar(255),
	picture1 varchar(50),
	picture2 varchar(50),
	picture3 varchar(50),
	deliveryPoint varchar(30),
	ownerId integer,
	updateTime timestamp  NOT NULL default CURRENT_TIMESTAMP
);

create table orderForm(
	oId integer not null primary key AUTO_INCREMENT,
	buyerId integer,
	sellerId integer,
	productId integer,
	pruductNumber integer,
	createTime timestamp  NOT NULL default CURRENT_TIMESTAMP
);