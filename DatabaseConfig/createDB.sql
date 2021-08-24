
create database storagedb;
use storagedb;

drop table storageboxes;
create table storageboxes (
  id INT(10)UNSIGNED,
  myid INT(10)UNSIGNED default 0,
  category varchar(256) default 'invalid',
     folder varchar(256) default 'invalid',
     tags varchar(1024) default 'invalid',
     file varchar(2048) default 'invalid');

ALTER TABLE storageboxes CHANGE id id INT(10)AUTO_INCREMENT PRIMARY KEY;
