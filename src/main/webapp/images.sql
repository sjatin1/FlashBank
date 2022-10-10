use PerfiosBank;
create table perfiosdata (accno varchar(11), fname varchar(20), uname varchar(20),pwd varchar(20),cpwd varchar(20),phno varchar(10), email varchar(20), addr varchar(30), amt double, type varchar(10), upi_id varchar(20));
SELECT * FROM perfiosdata;
ALTER TABLE perfiosdata drop column newfd;
ALTER TABLE perfiosdata drop column FD_amt;
delete from perfiosdata where type="current";
update perfiosdata set amt = 20000 where upi_id = "sjatin1308@ybl";
delete from PerfiosBank.credit;
alter table LOAN modify aadhar_back mediumblob;
select * from fixeddeposit;
delete from fixeddeposit where fd_name = "gift";
alter table fixeddeposit add constraint fd_name unique(fd_name);



delete from PerfiosBank.perfiosdata where foreign_curr = 1000;

SELECT DATA_TYPE from INFORMATION_SCHEMA.COLUMNS where table_schema = 'PerfiosBank' and table_name = 'foreign_exchange';
delete from perfiosdata where uname = "admin";
create table fixeddeposit (accno varchar(30), fd_name varchar(20), fd_amt double, foreign key (accno) references perfiosdata (accno));
select * from credit;
select * from perfiosdata;
select * from foreign_exchange;
select * from fixeddeposit;

delete from foreign_exchange;
select exists(select * from foreign_exchange where accno="13084242506");
alter table fixeddeposit modify fd_time date;
alter table perfiosdata add primary key(accno);
create table foreign_exchange(accno varchar(20), currency_type varchar(30), foreign_currency double, foreign key (accno) references perfiosdata(accno));
alter table perfiosdata drop column foreign_curr;
alter table perfiosdata add (curr_type varchar(30),foreign_curr varchar(30));
alter table transaction_history add (accno varchar(30));
alter table transaction_history add foreign key (accno) references perfiosdata(accno);
select * from foreign_exchange;
delete from transaction_history;

