### Usuń wszystkie dane z tabeli osoba a następnie wykonaj skrypt z pliku osoby_20.sql
###2.Stwórz tabelę dane_osobowe zawierającą pola: id, nazwa, miejscowosc, nr_domu, nr_lokalu, poczta, kod_pocztowy, data_urodzenia, ulica, id_osoba 
### relacja 1:1
-- create table dane_osobowe (
-- id_osoba int not null,
-- nazwa varchar(100), 
-- miejscowosc varchar(100), 
-- nr_domu varchar(100),
-- nr_lokalu varchar(100), 
-- archadane_osobower(100), 
-- kod_pocztowy varchar(100), 
-- data_urodzenia datetime, 
-- ulica varchar(100),
-- primary key (id_osoba),
-- foreign key (id_osoba) references osoba(id));
###3.Przekopiuj dane z tabeli osoba do tabeli dane_osobowe
-- insert into dane_osobowe select id as id_osoba, nazwa, miejscowosc, nr_domu, nr_lokalu, poczta, kod_pocztowy, data_urodzenia, ulica from osoba;  
###4.Zdefiniuj odpowiednie klucze by została utworzona relacja 1:1 // jest
###5.Usuń zbędne kolumny z tabeli osoba 
-- alter table osoba 
-- drop nazwa,
-- drop miejscowosc,
-- drop nr_domu,
-- drop nr_lokalu,
-- drop column poczta,
-- drop column kod_pocztowy,
-- drop column data_urodzenia,
-- drop column ulica;
###6.Przetestuj integralność danych
-- delete from osoba where id=20;
-- # Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`sklep`.`dane_osobowe`, CONSTRAINT `dane_osobowe_ibfk_1` FOREIGN KEY (`id_osoba`) REFERENCES `osoba` (`id`))
-- delete from dane_osobowe where id_osoba=20;
-- delete from osoba where id=20;
-- select * from dane_osobowe;
-- select * from osoba; 
# Złącz tabele
-- select * from osoba join dane_osobowe on osoba.id = dane_osobowe.id_osoba;
-- select * from osoba, dane_osobowe where osoba.id = dane_osobowe.id_osoba;

### 1.Wybrać nazwy oraz ilość wpłat osób które były urodzone w lub przed 2001 rokiem 
-- select dane_osobowe.nazwa, osoba.ilosc_wplat 
-- from osoba join dane_osobowe on osoba.id=dane_osobowe.id_osoba 
-- where year(dane_osobowe.data_urodzenia)<=2001;
### 2.Wygenerować zapytanie pobierające miejscowość oraz saldo_wn dla osób które zostały dodane w styczniu. Dane posortować po nazwie osoby i pobrać tylko 4 rekordy zaczynając od 5 rekordu w zapytaniu  
-- select dane_osobowe.miejscowosc, osoba.saldo_wn 
-- from osoba join dane_osobowe on osoba.id=dane_osobowe.id_osoba 
-- where month(osoba.dodano)=1 limit 5,4;
### 3.Wstawić nowy rekord to tabeli osoba. Następnie sprawdzić ilość wszystkich wierszy w tabeli osoba oraz  danych pobranych z obu tabel połączonych zapytaniem.
-- INSERT INTO osoba (id,dodano, saldo_wn, saldo_ma, ilosc_wplat)
-- VALUES (20 ,date(now()) ,11 ,1 , 111);
### 1. Utworzyć nową tabelę o nazwie faktura, zawierającą kolumny: id, id_osoba, data_wystawienia, netto, vat, termin_platnosci. Kolumna termin_platnosci to liczba dni na zapłacenie faktury.
### 2. Dodać odpowiednie złączenia i ograniczenia tak by powstała relacja 1 do wielu z tabelą osoba
-- create table faktura (
-- id int,
-- id_osoba int ,
-- data_wstawienia datetime, 
-- netto decimal, 
-- vat int,
-- termin_platnosci int,
-- primary key (id),
-- foreign key (id_osoba) references osoba(id));
### 3. Do tabeli z fakturami dodać 8 faktur, pierwsze 4 połączone do 4 różnych osób, następne 4 nie powiązane z żadną z osób (id_osoba=null)
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (1 , 1, date(now()), 5515, 15, 1);
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (2 , 3, date(now()), 5155, 51, 111);
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (3 , 4, date(now()), 5155, 51, 1);
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (4 , 11, date(now()), 1555, 45, 211);
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (5, null, date(now()), 75, 73, 7);
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (6, null, date(now()), 75, 73, 73);
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (7, null, date(now()), 7, 37, 73);
-- insert into faktura (id, id_osoba, data_wstawienia, netto, vat, termin_platnosci) values (8, null, date(now()), 75, 1, 1);
### 4. Wygenerować zapytanie pobierające z bazy listę zawierającą nazwę osoby oraz datę wystawienia i kwotę netto powiązanych faktur.
-- select nazwa, data_wstawienia, netto from osoba 
-- join dane_osobowe on (osoba.id=dane_osobowe.id_osoba)
-- join faktura on (osoba.id=faktura.id_osoba); 
### 5. Obliczyć sumę kwot netto faktur których właściciele mają mniej niż 40 wpłat
-- select sum(netto) from osoba 
-- join faktura on (osoba.id=faktura.id_osoba)
-- where ilosc_wplat<40; 
### 6. Pobrać z bazy danych połączony zestaw danych zawierający: nazwę osoby, miejscowość oraz kwotę netto dla powiązanej faktury
-- select nazwa, miejscowosc, netto from osoba 
-- join dane_osobowe on (osoba.id=dane_osobowe.id_osoba)
-- join faktura on (osoba.id=faktura.id_osoba); 

# łączenie tabel
-- select * from osoba join faktura on (osoba.id=faktura.id_osoba);
-- select * from osoba left join faktura on (osoba.id=faktura.id_osoba); 
-- select * from osoba right join faktura on (osoba.id=faktura.id_osoba);  

### 1. Pobrać z bazy ilość osób które posiadają faktury
-- select count(*) from osoba join faktura on (osoba.id=faktura.id_osoba);
### 2. Pobrać z bazy ilość wszystkich faktur wraz z ich ewentualnymi dowiązaniami do osób
-- select count(*) from osoba right join faktura on (osoba.id=faktura.id_osoba);
### 3. Pobrać z bazy ilość wszystkich osób wraz z ich ewentualnymi dowiązaniami do faktur
-- select count(*) from osoba left join faktura on (osoba.id=faktura.id_osoba);
### 4. Pobrać z bazy wszystkie faktury oraz osoby
-- select count(*) from osoba left join faktura on (osoba.id=faktura.id_osoba)
-- union
-- select count(*) from osoba right join faktura on (osoba.id=faktura.id_osoba); 
### 5. Usunąć wszystkie faktury z tabeli a następnie wykorzystując plik faktura_300.sql wstawić nowe dane do tabeli faktura. Upewnić się wcześniej że w tabeli osoba znajdują się osoby o identyfikatorach od 1 do 20.
-- delete from faktura;
### 6. Pobrać sumaryczną kwotę netto oraz vat w rozbiciu na miasta
-- select miejscowosc, sum(netto), sum(vat) from osoba 
-- join dane_osobowe on (osoba.id=dane_osobowe.id_osoba)
-- join faktura on (osoba.id=faktura.id_osoba)
-- group by miejscowosc;  
### 7. Pobrać średnią kwotę netto oraz ilość faktur w rozbiciu na ilość wpłat dla osób które zostały dodane przed 2000 rokiem
-- select ilosc_wplat, avg(netto), count(*) 
-- from osoba join faktura on (osoba.id=faktura.id_osoba)
-- where year(dodano)<2000 
-- group by ilosc_wplat;
### 8. Pobrać różnicę pomiędzy saldo_wn a średnią wartością vat (dla całej tabeli) + netto dla każdej z osób
-- select nazwa, (saldo_wn - (select avg(vat) from faktura) + sum(netto)) as roznica_plus_netto 
-- left join faktura on (osoba.id=faktura.id_osoba)
-- join dane_osobowe on (osoba.id=dane_osobowe.id_osoba)
-- group by osoba.id;
### 9. Znaleźć osobę z największą kwotą vat do zapłaty
-- select nazwa , sum(vat) from osoba 
-- join dane_osobowe on (osoba.id=dane_osobowe.id_osoba)
-- join faktura on (osoba.id=faktura.id_osoba)
-- group by osoba.id 
-- order by sum(vat) desc limit 0,1;

### 10. Znaleźć osoby których sumaryczna kwota vat do zapłaty nie przekracza 10-krotności średniej wartości kwoty netto dla wszystkich faktur
-- select nazwa, sum(faktura.vat), (select avg(netto) from faktura) from osoba 
-- join dane_osobowe as dane on (osoba.id=dane.id_osoba)
-- join faktura on (osoba.id=faktura.id_osoba)
-- group by osoba.id 
-- having sum(faktura.vat)<10*(select avg(netto) from faktura);


### 1. Znajdź średnią wartość stawki vat (netto * stawka = vat) płaconej na wszystkich fakturach z terminem płatności któtszym niż 10 dni dla osób dodanych przed 2010 rokiem.
-- select avg(vat/netto) from faktura 
-- join osoba on (faktura.id_osoba=osoba.id)   
-- where termin_platnosci<10 and year(dodano)<2010; 
### 2. Znajdź sumę kwoty netto do zapłacenia dla wszytkich faktur które miały termin płatności pomiędzy 10 a 20 dniami w latach wystawienia 2010, 2011 oraz w pierwszym pólroczu 2012 roku
-- select sum(netto) from faktura 
-- where ((termin_platnosci between 10 and 20) and (data_wystawienia between '2010-01-01' and '2012-05-31'));  
### 3. Znajdź wszystkie faktury które zostały wystawione zanim osoba z nią powiązana została dodana do bazy. Wyliczyć wartość procentową tej ilości względem wszystkich faktur
-- select ((count(*) / (select count(*) from faktura)) * 100) as procent_faktur 
-- from faktura join osoba on (faktura.id_osoba=osoba.id)
-- where dodano>data_wystawienia;   

