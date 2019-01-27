create user employeeDb identified by employeeDb;
GRANT CREATE SESSION to employeeDb;
alter user employeeDb quota unlimited on SYSTEM;
/*
##create table EmployeeDb.Employee(id varchar(30), name varchar(100), role varchar(20));
##create table EmployeeDb.Phone(owner_id varchar(30), contact varchar(10));

##insert into EmployeeDb.Employee (id, name, role) values(1,'Messi', 'player');

##insert into EmployeeDb.Phone (id, owner_id, contact) values(1, 1, '9090909090');
##insert into EmployeeDb.Phone (id, owner_id, contact) values(2, 1, '9090909091');
*/