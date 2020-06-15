-- CREATE DATABASE sklep;
use sklep;
-- drop table osoba;
-- create table if not exists osoba(
-- id int primary key not null,
-- nazwa varchar(20),
-- wiek int,
-- data_dodania datetime
-- );

-- use sklep;
-- insert into osoba (id,nazwa, wiek, data_dodania) values (1,'Adam Bodar',24,'1986-01-02');
-- insert into osoba (id,nazwa, wiek, data_dodania) values (2,'Adam Bodar',10,'1999-06-01');
-- insert into osoba (id,nazwa, wiek, data_dodania) values 
-- (3,'Anna Bodar',24,'2010-01-25'),
-- (4,'Jacek Kalusz',24,'2010-09-24');
-- select * from osoba where nazwa='Anna Bodar';
-- SET SQL_SAFE_UPDATES = 0;
-- update osoba set data_dodania='2010-09-24' where nazwa='Anna Bodar'; 
-- select * from osoba;
-- DELETE FROM osoba WHERE wiek>25 AND data_dodania='2010-09-24';
-- select * from osoba;

-- select curdate();
-- select date_add(curdate(), interval 131 day);
-- select date_add(curdate(), interval -1111 day);
-- select upper(nazwa) from osoba;
-- select lower(nazwa) from osoba;
-- select * from osoba where nazwa like '%r';
-- select year(data_dodania) from osoba;

-- alter table osoba change column data_dodania dodano datetime;
-- alter table osoba
-- add column ulica varchar(100), 
-- add column nr_domu int, 
-- add column nr_lokalu int,
-- add column poczta  varchar(100),
-- add column kod_pocztowy  varchar(100),
-- add column miejscowosc varchar(100);
-- alter table osoba drop column wiek;
-- alter table osoba add column  data_urodzenia datetime;
-- alter table osoba 
-- add column saldo_wn decimal(10,2),
-- add column saldo_ma decimal(10,2);
-- alter table osoba add column ilosc_wplat int; 
-- alter table osoba change column nazwa nazwa varchar(100);
-- delete from osoba;
-- select * from osoba;

-- select distinct miejscowosc from osoba order by miejscowosc asc;

-- select * from osoba order by data_urodzenia asc limit 0,1;
-- select * from osoba where data_urodzenia = (select max(data_urodzenia) from osoba);

-- select * from osoba order by data_urodzenia desc limit 0,1; 
-- select * from osoba where data_urodzenia = (select min(data_urodzenia) from osoba);

-- select count(*) from osoba where year(data_urodzenia)='1995';
-- select count(*) from osoba where data_urodzenia like '%1995%';

-- select * from osoba where (saldo_ma - saldo_wn) > 0;

-- select * from osoba order by ilosc_wplat desc limit 0,1;
-- select * from osoba where ilosc_wplat =  (select max(ilosc_wplat) from osoba);

-- select * from osoba where year(dodano)='2012' and ilosc_wplat < 40;

-- select * from osoba order by (saldo_ma / ilosc_wplat) desc limit 0,1; 
-- select * from osoba where (saldo_ma/ilosc_wplat) = (SELECT MAX(saldo_ma/ilosc_wplat) FROM osoba);

-- select count(*) from osoba where kod_pocztowy like '%7'

-- select miejscowosc, count(*) from osoba group by miejscowosc;