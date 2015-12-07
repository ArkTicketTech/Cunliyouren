create database clyr;

use clyr;

create table t_admin(
	adminName varchar(10) default "",
	password varchar(20) default ""
);


create table t_user(
	uId integer not null primary key AUTO_INCREMENT,
	openId varchar(30) default "",
	nickName varchar(30) default "",
	unionId varchar(30) default "",
	headImgUrl varchar(50) default "",
	telNum varchar(15) default "",
	homeTown varchar(20) default "",
	highSchool varchar(30) default "",
	university varchar(30) default "",
	homeAddress varchar(30) default "",
	workingAddress varchar(30) default "",
	state integer DEFAULT 1
);

create table t_product(
	pId integer not null primary key AUTO_INCREMENT,
	productName varchar(30) default "",
	price double default 0,
	unit varchar(10) default "",
	description varchar(255) default "",
	picture1 varchar(50) default "",
	picture2 varchar(50) default "",
	picture3 varchar(50) default "",
	deliveryPoint varchar(30) default "",
	ownerId integer default 0,
	updateTime timestamp  NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
	FOREIGN KEY (ownerId) REFERENCES t_user(uId)
);

create table t_order(
	oId integer not null primary key AUTO_INCREMENT,
	buyerId integer default 0,
	sellerId integer default 0,
	productId integer default 0,
	productNumber integer default 0,
	createTime timestamp  NOT NULL default CURRENT_TIMESTAMP,
	FOREIGN KEY (buyerId) REFERENCES t_user(uId),
	FOREIGN KEY (sellerId) REFERENCES t_user(uId),
	FOREIGN KEY (productId) REFERENCES t_product(pId)
);

--测试数据
insert into t_user values(1,"000001","test","00001","1.jpg","13111111111","sh","jdfz","ecnu","666","3663",1);
insert into t_user values(2,"000002","test1","00002","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(3,"000003","test2","00003","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(4,"000004","test3","00004","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(5,"000005","test4","00005","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(6,"000006","test5","00006","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(7,"000007","test6","00007","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(8,"000008","test7","00008","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(9,"000009","test8","00009","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(10,"000010","test9","00010","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(11,"000011","test10","00011","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(12,"000012","test11","00012","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(13,"000013","test12","00013","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(14,"000014","test13","00014","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(15,"000015","test14","00015","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(16,"000016","test15","00016","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(17,"000017","test16","00017","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(18,"000018","test17","00018","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(19,"000019","test18","00019","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(20,"000020","test19","00020","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_user values(21,"000021","test20","00021","2.jpg","1322222222","bj","qhfz","qhdx","222","2333",1);
insert into t_product(productName,price,unit,description,deliveryPoint,ownerId) values("p1",2,"个","p1 2.00","sh",1);
insert into t_product(productName,price,unit,description,deliveryPoint,ownerId) values("p2",3,"个","p2 3.00","gz",1);
insert into t_product(productName,price,unit,description,deliveryPoint,ownerId) values("p3",5,"个","2220","sh",2);
insert into t_product(productName,price,unit,description,deliveryPoint,ownerId) values("p4",2.2,"个","3543","sh",2);
insert into t_product(productName,price,unit,description,deliveryPoint,ownerId) values("p5",2,"个","afgafg","sh",2);
insert into t_product(productName,price,unit,description,deliveryPoint,ownerId) values("p6",2,"个","fhsj","sh",1);
insert into t_order(buyerId,sellerId,productId,productNumber)values(2,1,1,5);
insert into t_admin values("admin","123456");