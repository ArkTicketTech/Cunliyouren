create database clyr;

use clyr;

create table t_admin(
	adminName varchar(10),
	password varchar(20)
);

create table t_product(
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

create table t_order(
	oId integer not null primary key AUTO_INCREMENT,
	buyerId integer,
	sellerId integer,
	productId integer,
	pruductNumber integer,
	createTime timestamp  NOT NULL default CURRENT_TIMESTAMP
);

create table t_user(
	openId varchar(30),
	nickName varchar(30),
	unionId varchar(30),
	headImgUrl varchar(50),
	telNum varchar(15),
	homeTown varchar(20),
	highSchool varchar(30),
	University varchar(30),
	homeAddress varchar(30),
	workingAddress varchar(30),
	state integer
);