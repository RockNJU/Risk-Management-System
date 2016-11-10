drop table if EXISTS users;

create table users(
	id varchar(255) not null,
	logincode varchar(255),
	password varchar(255),
	username varchar(255),
	remark varchar(255),
	primary key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into users(id,logincode,password,username,remark)
	values ('123','123','123','wzce13','这是一个超级账户');

drop table if EXISTS project;
create table project(
	id varchar(255),
	name varchar(255),
	description varchar(255),
	ownerid varchar(255),
username varchar(255),
	time varchar(255),
	remark varchar(255),
	primary key(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists participant;
create table participant(
	id varchar(255) not null,
	userid varchar(255) not null,
	projectid varchar(255) not null,
	primary key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists risk;
create table risk(
	id varchar(255) not null,
	name varchar(255),
	projectid varchar(255) not null,
	userid varchar(255) not null,
	username varchar(255),
	content varchar(255),
	possibility varchar(255),
	influence varchar(255),
	shreshold real,
	time varchar(255),
	primary key(id)
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists riskitem;
create table riskitem(
	id varchar(255) not null,
	riskid varchar(255) not null,
	userid varchar(255) not null,
	username varchar(255),
	state varchar(255),
	description varchar(255),
	time varchar(255);
	primary key(id))ENGINE=InnoDB DEFAULT CHARSET=utf8;

drop table if exists organization;
create table organization(
	oid varchar(255),
	oname varchar(255),
	leaderid varchar(255),
	primary key(oid))ENGINE=InnoDB DEFAULT CHARSET=utf8;



