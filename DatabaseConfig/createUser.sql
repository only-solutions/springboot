
create user 'localuser'@'localhost' identified by 'somepassword';
create user 'localuser'@'127.0.0.1' identified by 'somepassword';
commit;
grant all privileges on storagedb.* to 'localuser'@'127.0.0.1' identified by 'somepassword';
