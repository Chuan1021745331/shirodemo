## 用户表
drop table if exists s_user;
create table s_user(
  su_id int(11) not null AUTO_INCREMENT,
  username varchar(64) not null  COMMENT '用户名',
  password varchar(64) not null comment '密码',
  primary key(su_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
insert into s_user(username, password) values ('chuan1','123456');
insert into s_user(username, password) values ('chuan2','123456');
insert into s_user(username, password) values ('chuan3','123456');
insert into s_user(username, password) values ('chuan4','123456');

## 角色表
drop table if exists s_role;
create table s_role(
  sr_id int(11) not null AUTO_INCREMENT,
  name varchar(64) not null ,
  pid int(11) not null,
  description varchar(255) default '' comment '角色描述',
  primary key(sr_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
insert into s_role(name, pid, description)  values ('ROOT',0,'超级管理员');
insert into s_role(name, pid, description)  values ('USER',0,'超级管理员');

## 权限表
drop table if exists s_right;
create table s_right(
  sr_id int(11) not null AUTO_INCREMENT,
  name varchar(64) not null default '',
  pid int(11) not null,
  url varchar(255) default '' comment '',
  description varchar(255) default '',
  primary key (sr_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
insert into s_right(name, pid, description) values ('user',0,'用户权限');
insert into s_right(name, pid, description) values ('user_delete',1,'用户权限');
insert into s_right(name, pid, description) values ('user_add',1,'用户权限');
insert into s_right(name, pid, description) values ('user_update',1,'用户权限');

## 用户角色表
drop table if exists s_user_role;
create table s_user_role(
  sur_id int(11) not null AUTO_INCREMENT,
  user_id int(11) not null,
  role_id int(11) not null,
  primary key(sur_id),
  index index_user_id(user_id),
  index index_role_id(role_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

## 角色权限表
drop table if exists s_role_right;
create table s_role_right(
 srr_id int(11) not null AUTO_INCREMENT,
 role_id int(11) not null,
 right_id int(11) not null,
 primary key(srr_id),
 index index_role_id(role_id),
 index index_right_id(right_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;