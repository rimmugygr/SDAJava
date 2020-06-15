-- set global time_zone = '+2:00'
-- use mydb;
-- create table if not exists  people (
-- id numeric primary key,
-- first_name varchar(50),
-- last_name varchar(50),
-- age numeric,
-- gender char );
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('1','bartek','zagula','26','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('2','To','Ja','21','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('3','Typ','niepokorny','12','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('4','Nikt ','nie ','18','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('5','wie','co ','56','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('6','we ','mnie ','82','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('7','tkwi','Ten ','44','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('8','sam','choc  ','42','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('9','niepodobny','Kochanie','89','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('10','prosze','wybacz ','11','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('11','mi','Niewazne ','3','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('12','teraz','jak ','111','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('13','i','gdzie','77','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('14','Niewazne ','za ','91','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('15','jaka ','cene','36','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('16','Choc ','czas ','66','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('17','powoli ','posuwa ','26','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('18','mnie','Ja ','12','F');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('19','pewnie ','sie ','74','M');
-- INSERT INTO `people` (`id`,`first_name`,`last_name`,`age`,`gender`) VALUES ('20','nie ','zmienie','80','F');
-- SET SQL_SAFE_UPDATES=0;
-- update people set last_name='aaa' where last_name='Ja';
-- update people set last_name='xxx' where id=2;
-- select * from people;
-- drop table phones;
-- create table if not exists phones(
-- id int primary key,
-- number varchar(20),
-- person_id numeric,
-- foreign key (person_id) references people(id));
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('1','123456','1');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('2','123456','2');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('3','123456','3');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('4','123222','2');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('5','244456','2');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('6','123222','3');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('7','123556','1');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('8','123456','2');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('9','125556','5');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('10','123222','6');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('11','225556','7');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('12','123222','8');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('13','123356','11');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('14','123222','3');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('15','222456','8');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('16','123322','5');
-- INSERT INTO `phones` (`id`,`number`,`person_id`) VALUES ('17','123226','12');
-- select * from people join phones on people.id=phones.person_id;


-- CREATE TEMPORARY table temp_tab (select people.id from people join phones on people.id=phones.person_id where number='123222');
-- update people set age=4
-- WHERE id in
--   (
--     SELECT *
--     FROM temp_tab
--   );
-- DROP TABLE temp_tab;


-- select people.id, age from people join phones on people.id=phones.person_id where number='123222';




-- delete from people where id=1; 
-- select * from people join phones on people.id=phones.person_id where people.id=1;
select * from people;
select * from phones ; 
-- ALTER TABLE people AUTO_INCREMENT = 30;
select * from hibernate_sequence;
update hibernate_sequence set next_val = 30; 

