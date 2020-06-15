### 1
-- create table przelew (
-- id int,
-- data datetime, 
-- kwota decimal,
-- primary key (id));
### 2
### 3
-- create table przelew_faktura (
-- id_przelew int,
-- id_faktura int,
-- foreign key (id_przelew) references przelew(id),
-- foreign key (id_faktura) references faktura(id)
-- );
### 4
### 5.Pobrać z bazy listę faktur zawierającą kwotę netto oraz sumę przelewów. 
-- select faktura.id as id_faktura, netto, sum(kwota) as suma_kwot_przelewow from faktura
-- join przelew_faktura on (faktura.id=przelew_faktura.id_faktura)
-- join przelew on (przelew.id=przelew_faktura.id_przelew)
-- group by faktura.id;
### 6.Pobrać listę faktur których przelewy spłaciły ją całkowicie, tj. suma kwot przelewów jest większa niż netto + vat faktury. 
-- select faktura.id as id_faktury, netto, vat, sum(kwota) as suma_przelwow from faktura
-- join przelew_faktura on (faktura.id=przelew_faktura.id_faktura)
-- join przelew on (przelew.id=przelew_faktura.id_przelew)
-- group by faktura.id having (sum(kwota))>(netto+vat);
### 7.Pobrać listę faktur których suma przelewów pokryła vat oraz 20% kwoty netto 
-- select faktura.id as id_faktury, netto, vat, sum(kwota) as suma_przelwow from faktura
-- join przelew_faktura on (faktura.id=przelew_faktura.id_faktura)
-- join przelew on (przelew.id=przelew_faktura.id_przelew)
-- group by faktura.id having (sum(kwota))>(0.2*netto+vat);
### 8.Wyświetlić listę wszystkich osób zawierającą: nazwę osoby, kod pocztowy, miejscowość ilość faktur oraz sumę przelewów.
-- select nazwa, kod_pocztowy, miejscowosc, count(faktura.id) as ilosc_faktur, sum(kwota) as suma_przelwow 
-- from faktura
-- join przelew_faktura on (faktura.id=przelew_faktura.id_faktura)
-- join przelew on (przelew.id=przelew_faktura.id_przelew)
-- join osoba on (osoba.id=faktura.id_osoba)
-- join dane_osobowe as dane on (osoba.id=dane.id_osoba)
-- group by osoba.id;

-- select o.id , d.nazwa, d.kod_pocztowy, d.miejscowosc, (select count (*) from faktura f2 where o.id = f2.id _osoba) as ilosc_faktur, sum (p.kwota) as suma_przelewow 
-- from osoby o 
-- join dane_osobowe d on ( o.id = d.id _osoba) 
-- join faktura f on ( o.id = f.id _osoba) 
-- join faktura_przelew fp on ( fp.id _faktura = f.id ) 
-- join przelew p on ( fp.id _przelew = p.id ) 
-- GROUP BY o.id , d.nazwa;

### 9.Naleźć osobę z największą kwotą wpłat dodaną przed 2010 rokiem
-- select nazwa, dodano, sum(kwota) as suma_przelwow 
-- from faktura
-- join przelew_faktura on (faktura.id=przelew_faktura.id_faktura)
-- join przelew on (przelew.id=przelew_faktura.id_przelew)
-- join osoba on (osoba.id=faktura.id_osoba)
-- join dane_osobowe as dane on (osoba.id=dane.id_osoba)
-- group by osoba.id having year(dodano)<2010
-- order by sum(kwota)  desc
-- limit 0,2;

### 1.Dodać do bazy tabelę faktura_pozycja zawierającą pola: id, cena, ilosc, stawka_vat, id_faktura. Dodać odpowiednie klucze do tabeli.
-- create table faktura_pozycja (
-- id int primary key,
-- cena decimal,
-- ilisc int,
-- stawka_vat int,
-- id_faktura int,
-- foreign key (id_faktura) references faktura(id)
-- );
### 2.Dodać tabelę towar zawierającą informacje o nazwie, jednostce (sztuki, kilogramy itd.) oraz opisie sprzedawanych towarów. Dodać dodać odpowiednie kolumny tak by powiązać ją z tabelą faktura_pozycja. 
-- create table towar (
-- id int primary key,
-- nazwa varchar(20),
-- jednostka varchar(10),
-- opis varchar(100),
-- id_faktura_pozycja int,
-- foreign key (id_faktura_pozycja) references faktura_pozycja(id)
-- );
### 3.Wygenerować diagram ER z powstałego dzieła. Sprawdzić czy nie występuje cykliczność połączeń. 
### 4.Wypełnić powstałe tabele przykładowymi danymi. Uczynić to ręcznie bądź przy użyciu gotowego narzędzia np. strony https://www.generatedata.com/
-- select * from faktura_pozycja;
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (435,9,62,166,1),(60,8,82,288,2),(960,2,82,22,3),(501,2,24,12,4),(250,6,11,65,5),(625,5,21,274,6),(234,5,78,209,7),(228,7,20,145,8),(937,8,72,10,9),(834,5,76,275,10);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (114,3,44,158,11),(327,4,67,82,12),(200,2,66,27,13),(730,10,7,246,14),(383,6,79,84,15),(348,10,2,155,16),(683,9,67,145,17),(43,2,56,270,18),(244,8,32,257,19),(711,2,8,103,20);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (535,3,29,30,21),(257,10,38,142,22),(415,8,75,100,23),(163,10,53,214,24),(551,9,77,203,25),(458,1,20,267,26),(620,10,24,183,27),(958,10,14,88,28),(684,4,60,72,29),(547,10,64,292,30);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (257,3,73,242,31),(598,3,65,268,32),(98,3,68,99,33),(969,8,84,280,34),(852,7,69,139,35),(135,3,41,122,36),(6,6,39,81,37),(129,5,36,239,38),(258,2,27,119,39),(646,8,64,40,40);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (285,9,76,71,41),(544,3,85,145,42),(333,9,87,187,43),(965,7,16,87,44),(817,1,36,47,45),(300,10,9,91,46),(225,1,1,15,47),(298,1,26,86,48),(867,3,62,127,49),(191,5,26,86,50);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (131,6,81,61,51),(486,10,46,276,52),(878,5,55,185,53),(643,10,70,225,54),(903,4,73,85,55),(33,4,48,275,56),(696,8,11,281,57),(490,7,46,234,58),(892,1,75,76,59),(881,2,58,242,60);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (579,1,82,192,61),(699,10,82,72,62),(551,10,71,128,63),(10,8,38,147,64),(8,7,73,244,65),(630,5,22,75,66),(577,9,44,38,67),(504,7,66,87,68),(314,2,5,13,69),(716,9,51,66,70);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (597,5,2,103,71),(937,2,45,79,72),(921,3,49,229,73),(526,10,68,278,74),(175,3,7,258,75),(336,5,25,289,76),(493,1,6,35,77),(595,8,17,251,78),(582,6,26,64,79),(899,7,55,169,80);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (730,8,20,108,81),(978,7,11,212,82),(805,6,48,198,83),(183,5,48,47,84),(250,5,78,60,85),(544,6,1,59,86),(700,8,67,27,87),(450,1,73,197,88),(295,4,79,85,89),(943,9,50,125,90);
-- INSERT INTO `faktura_pozycja` (`cena`,`ilisc`,`stawka_vat`,`id_faktura`,`id`) VALUES (414,6,37,195,91),(531,3,51,40,92),(885,6,44,20,93),(741,1,41,242,94),(265,7,29,95,95),(807,3,30,128,96),(86,5,75,284,97),(671,9,40,91,98),(94,6,77,151,99),(103,8,67,217,100);
-- select * from towar;
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("venenatis a,","justo","senectus et netus et malesuada fames",91,1),("ligula. Aenean","Aliquam","velit. Pellentesque ultricies",4,2),("scelerisque neque","et,","neque sed sem egestas blandit. Nam",78,3),("parturient montes,","Duis","Maecenas iaculis aliquet diam. Sed",77,4),("Mauris vestibulum,","gravida","Quisque ac libero",62,5),("interdum libero","in,","velit justo nec ante. Maecenas mi",29,6),("Cras eu","mollis.","tellus. Suspendisse sed dolor. Fusce mi lorem, vehicula",25,7),("nascetur ridiculus","mauris.","nascetur ridiculus mus. Proin",97,8),("Quisque tincidunt","Nullam","Nunc laoreet",96,9),("dictum augue","eleifend","magna sed dui. Fusce aliquam, enim nec tempus scelerisque,",1,10);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("purus mauris","et","tellus. Phasellus elit pede,",61,11),("felis, adipiscing","purus.","habitant morbi tristique senectus et",37,12),("gravida non,","pede.","ipsum dolor",86,13),("non enim","lacinia","Mauris nulla. Integer urna. Vivamus molestie",16,14),("Nulla dignissim.","ut","ornare sagittis felis. Donec tempor, est ac",68,15),("pharetra sed,","et,","tristique aliquet. Phasellus fermentum convallis ligula.",42,16),("gravida. Aliquam","adipiscing","tincidunt",32,17),("luctus lobortis.","nulla.","purus. Duis elementum, dui quis accumsan",92,18),("Etiam bibendum","adipiscing","Cras interdum. Nunc sollicitudin commodo ipsum.",53,19),("dictum. Proin","ultrices,","Curabitur dictum. Phasellus in felis. Nulla",41,20);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("ipsum porta","nonummy","varius et,",45,21),("gravida sagittis.","vulputate","turpis egestas. Fusce aliquet magna a neque.",10,22),("orci luctus","justo","luctus et ultrices posuere cubilia Curae; Phasellus",98,23),("et, lacinia","ut","Curabitur",95,24),("tincidunt adipiscing.","ligula.","Aliquam ornare, libero at auctor ullamcorper, nisl",39,25),("et tristique","ultricies","elit, pharetra ut, pharetra",51,26),("amet, faucibus","metus.","risus. Nulla eget",71,27),("placerat velit.","est,","ut",1,28),("Suspendisse non","dolor,","tellus eu augue porttitor interdum.",42,29),("et malesuada","egestas","dui. Cras pellentesque. Sed dictum. Proin eget odio.",86,30);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("a feugiat","convallis,","lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque.",19,31),("justo. Proin","dictum","lobortis. Class aptent taciti",75,32),("blandit enim","enim","nostra, per inceptos",81,33),("arcu iaculis","erat","elit. Aliquam auctor, velit eget laoreet posuere, enim",36,34),("dolor sit","sed","adipiscing",59,35),("iaculis enim,","Aliquam","imperdiet",36,36),("sem. Pellentesque","Aenean","taciti sociosqu ad",71,37),("malesuada malesuada.","ipsum","montes, nascetur ridiculus mus. Proin vel nisl. Quisque",3,38),("augue ac","enim","Nullam velit dui, semper et, lacinia",7,39),("euismod in,","ultrices,","Suspendisse non leo. Vivamus nibh dolor,",15,40);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("a felis","Phasellus","odio. Etiam ligula",22,41),("eget nisi","fermentum","ac orci. Ut semper pretium neque. Morbi",87,42),("netus et","orci","risus. Nunc ac",66,43),("lobortis augue","amet,","libero et tristique pellentesque, tellus",30,44),("ultricies ornare,","vehicula","nulla. Cras eu tellus eu augue",44,45),("egestas. Aliquam","at,","gravida nunc sed",21,46),("ridiculus mus.","In","metus urna convallis erat, eget tincidunt",89,47),("non, bibendum","Proin","euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur",19,48),("Class aptent","primis","a, aliquet vel, vulputate eu, odio. Phasellus at augue id",28,49),("Nam ac","ipsum","amet metus. Aliquam erat volutpat. Nulla facilisis. Suspendisse",5,50);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("sed orci","eu,","iaculis odio. Nam interdum enim non nisi. Aenean",99,51),("hendrerit id,","Sed","dictum cursus. Nunc mauris elit, dictum",48,52),("scelerisque dui.","nascetur","odio. Etiam ligula tortor, dictum eu, placerat eget, venenatis a,",81,53),("nisi sem","pellentesque","sodales elit erat vitae risus. Duis a mi fringilla mi",2,54),("egestas a,","enim,","a, enim. Suspendisse",73,55),("est. Nunc","tempor","vel, convallis in, cursus et, eros.",40,56),("commodo auctor","Nullam","Phasellus fermentum convallis ligula.",69,57),("arcu. Vestibulum","lobortis","orci. Ut semper pretium neque. Morbi quis urna. Nunc",53,58),("enim diam","Nulla","ultrices a, auctor non, feugiat nec,",47,59),("dolor sit","neque","massa.",33,60);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("mauris ipsum","molestie","Quisque fringilla euismod enim. Etiam gravida molestie",83,61),("sem mollis","eu","vel, venenatis vel, faucibus id, libero. Donec consectetuer",49,62),("Curabitur sed","hendrerit","a ultricies adipiscing, enim",59,63),("sed, facilisis","magna,","Nulla interdum. Curabitur dictum. Phasellus in felis. Nulla tempor augue",83,64),("ante, iaculis","augue","scelerisque sed,",44,65),("Proin dolor.","id","ridiculus mus. Aenean eget",38,66),("nibh. Donec","ante","lobortis mauris. Suspendisse aliquet molestie tellus. Aenean",31,67),("Sed nunc","risus.","Nullam feugiat placerat velit. Quisque varius.",97,68),("fermentum vel,","diam.","mauris blandit mattis. Cras eget nisi dictum augue malesuada",81,69),("et, magna.","pede","fringilla purus mauris a nunc. In",41,70);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("tellus. Aenean","velit","Sed nec metus facilisis lorem tristique aliquet. Phasellus",10,71),("eget, volutpat","eu,","volutpat. Nulla facilisis. Suspendisse commodo tincidunt nibh.",79,72),("Suspendisse aliquet,","ac","cursus, diam at pretium aliquet, metus urna convallis erat,",57,73),("Fusce fermentum","nunc.","sed dui. Fusce aliquam, enim nec tempus scelerisque,",85,74),("a sollicitudin","et,","Pellentesque habitant morbi tristique",77,75),("Sed auctor","eu","libero et tristique pellentesque, tellus sem mollis",21,76),("dictum. Phasellus","ut","lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo.",11,77),("imperdiet non,","metus","arcu. Sed et libero. Proin",16,78),("orci, consectetuer","ultricies","mi enim, condimentum eget,",95,79),("sagittis lobortis","vel,","iaculis nec,",6,80);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("at risus.","Donec","Nam nulla magna, malesuada vel, convallis in,",47,81),("Sed nulla","dis","Nullam vitae diam.",92,82),("Cras vehicula","Sed","Curabitur dictum. Phasellus in felis. Nulla tempor augue ac",98,83),("ac libero","consequat","Duis volutpat",95,84),("Pellentesque habitant","sociis","arcu ac orci.",3,85),("nunc ac","nisl","Donec tempor, est ac mattis semper, dui lectus",18,86),("justo faucibus","non,","augue ac ipsum. Phasellus vitae mauris sit amet lorem semper",87,87),("neque. Nullam","a","nunc sed",96,88),("feugiat non,","vel,","Pellentesque habitant morbi tristique senectus et netus et malesuada fames",2,89),("dolor egestas","fringilla","gravida non,",44,90);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("Duis gravida.","nisl","eu,",41,91),("Morbi neque","euismod","gravida sit",10,92),("vitae velit","Morbi","diam. Duis mi enim, condimentum",64,93),("a purus.","eu","Sed eu nibh vulputate mauris",82,94),("non, dapibus","habitant","Donec fringilla. Donec feugiat metus sit amet",19,95),("Cras dolor","euismod","molestie. Sed id risus quis",54,96),("dignissim pharetra.","Curabitur","erat vitae risus. Duis a mi fringilla mi",23,97),("sed turpis","interdum","eu",5,98),("imperdiet ornare.","Curabitur","arcu et pede. Nunc sed orci lobortis",60,99),("ante dictum","rutrum,","iaculis enim, sit amet ornare",1,100);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("ante dictum","egestas.","placerat. Cras dictum ultricies",21,101),("pede. Cras","sapien.","consequat nec, mollis",56,102),("vestibulum lorem,","viverra.","nisl",12,103),("lorem ipsum","mauris.","nunc",20,104),("elit elit","ligula","Mauris nulla. Integer urna. Vivamus molestie dapibus ligula. Aliquam",39,105),("eget metus.","massa","facilisis lorem",11,106),("pede, malesuada","non,","Donec nibh enim, gravida sit",58,107),("enim. Nunc","eu","neque non quam. Pellentesque habitant morbi tristique senectus et netus",62,108),("augue porttitor","malesuada","aliquam eu, accumsan sed, facilisis vitae, orci.",72,109),("Praesent luctus.","et,","arcu. Aliquam ultrices iaculis",90,110);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("sit amet,","tempor","nisl. Quisque fringilla euismod enim. Etiam",41,111),("enim. Etiam","contetuer","Mauris ut quam vel sapien imperdiet ornare. In",48,112),("Morbi accumsan","lacus","In mi",32,113),("magna. Cras","bibendum","lectus quis massa. Mauris",17,114),("senectus et","lacinia","nec ante. Maecenas mi felis, adipiscing fringilla,",71,115),("nec ligula","porttitor","nunc est, mollis non,",72,116),("vitae diam.","orci","diam nunc, ullamcorper eu, euismod ac, fermentum",79,117),("vitae mauris","libero.","odio. Nam interdum enim non nisi. Aenean",7,118),("habitant morbi","mauris,","Proin vel nisl. Quisque fringilla euismod",10,119),("Nunc quis","sit","arcu. Vestibulum",47,120);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("dignissim lacus.","Sed","senectus et netus et malesuada fames",61,121),("tempus non,","sem","eleifend, nunc risus varius orci, in",48,122),("magna. Ut","placerat,","at sem",30,123),("aliquet, metus","gravida","In at pede. Cras vulputate velit eu sem. Pellentesque",2,124),("lectus, a","non,","quam dignissim",27,125),("nec urna","vel,","sed turpis nec mauris blandit mattis. Cras",74,126),("hendrerit neque.","eget","Aenean massa. Integer vitae nibh. Donec est mauris, rhoncus",12,127),("faucibus leo,","accumsan","libero et tristique pellentesque, tellus sem",94,128),("tristique ac,","nulla","dignissim",35,129),("dictum cursus.","mauris,","sem eget massa. Suspendisse eleifend.",97,130);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("tellus non","a","scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas",68,131),("Nunc mauris","luctus","tellus non magna. Nam ligula elit, pretium et, rutrum",50,132),("placerat, augue.","et,","euismod ac, fermentum vel, mauris. Integer",56,133),("luctus sit","ac","blandit at, nisi. Cum sociis natoque penatibus et magnis",62,134),("quam. Pellentesque","vitae","orci. Phasellus",5,135),("luctus ut,","mauris","dictum",8,136),("accumsan convallis,","lacinia","eu turpis. Nulla",60,137),("elit pede,","pharetra","scelerisque neque sed",35,138),("consectetuer euismod","eu","mus. Donec dignissim magna a",92,139),("Aenean gravida","vulputate,","magna. Praesent interdum ligula",46,140);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("odio sagittis","sit","lorem semper",46,141),("Cras lorem","imperdiet","fames ac turpis egestas.",69,142),("at auctor","enim","metus. Aenean sed pede nec ante blandit viverra. Donec",30,143),("lorem eu","semper","varius. Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada",53,144),("sit amet","ipsum","imperdiet dictum magna. Ut tincidunt orci",62,145),("nunc. Quisque","condimtum.","nisl arcu iaculis enim, sit amet ornare",36,146),("non nisi.","nec","id enim. Curabitur massa. Vestibulum accumsan neque",43,147),("Duis elementum,","eros.","tempor lorem, eget",50,148),("Proin vel","risus","non",59,149),("non, dapibus","vitae","semper",23,150);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("mi eleifend","metus","leo",1,151),("semper. Nam","luctus.","tortor. Integer aliquam adipiscing lacus.",88,152),("neque. Nullam","montes,","pharetra. Quisque ac libero",86,153),("Nunc commodo","eget","eu,",32,154),("lacus, varius","velit.","mattis. Integer eu lacus. Quisque imperdiet, erat",76,155),("Sed molestie.","Aliquam","habitant morbi tristique senectus et netus et malesuada fames ac",29,156),("auctor. Mauris","lobortis","orci quis",81,157),("non massa","Maecenas","non, egestas a, dui. Cras pellentesque. Sed",21,158),("metus. In","eu","odio, auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque",56,159),("Ut sagittis","tempor","vulputate dui, nec tempus mauris",27,160);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("diam. Sed","volutpat","ipsum. Donec sollicitudin adipiscing",10,161),("volutpat. Nulla","eu,","Suspendisse ac",8,162),("Sed eu","Phasellus","vel pede blandit congue.",12,163),("lacus. Nulla","luctus","Nunc pulvinar arcu et pede. Nunc sed",49,164),("ut aliquam","lacus.","nisi nibh lacinia orci, consectetuer euismod est arcu ac",55,165),("rutrum magna.","varius","nibh dolor, nonummy ac, feugiat non, lobortis quis,",2,166),("at, velit.","ullamcoer.","consequat nec, mollis vitae, posuere at, velit. Cras",85,167),("netus et","auctor","Curabitur egestas nunc sed libero.",6,168),("Vivamus sit","parturient","interdum",97,169),("nunc. Quisque","Cras","eu lacus. Quisque imperdiet, erat",83,170);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("quis, tristique","fringilla","magnis dis parturient montes, nascetur",40,171),("justo faucibus","sapien.","sit",31,172),("scelerisque mollis.","et","dolor sit amet, consectetuer adipiscing elit. Etiam laoreet, libero",75,173),("netus et","dictum","Integer mollis.",8,174),("ac urna.","ornare,","placerat eget, venenatis a, magna.",97,175),("gravida non,","orci.","facilisis",88,176),("ornare tortor","vel","Suspendisse sagittis. Nullam vitae diam. Proin dolor.",28,177),("ac metus","non","aliquet vel, vulputate eu, odio. Phasellus at augue id ante",85,178),("neque. In","Aenean","pharetra, felis eget varius ultrices, mauris ipsum",18,179),("egestas. Aliquam","interdum.","sed,",87,180);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("sit amet,","Aliquam","nec enim.",68,181),("In ornare","malesuada","rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales",19,182),("Nullam scelerisque","hendrerit","mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam",23,183),("dictum. Proin","sit","nibh enim, gravida sit amet, dapibus",4,184),("Donec tincidunt.","mauris","gravida sit amet, dapibus id, blandit at, nisi.",1,185),("tempor augue","Ut","Nunc ut erat. Sed nunc",82,186),("varius et,","enim.","imperdiet non, vestibulum nec, euismod in, dolor.",74,187),("dui. Cras","non","sagittis placerat. Cras dictum ultricies ligula. Nullam enim.",31,188),("Nulla semper","auctor.","elit, a feugiat tellus lorem eu metus. In lorem. Donec",49,189),("elit. Etiam","Sed","dictum magna. Ut tincidunt",57,190);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("malesuada vel,","feugiat","nascetur ridiculus mus. Donec",36,191),("dapibus ligula.","leo.","ornare, libero at auctor ullamcorper, nisl",76,192),("pharetra ut,","nonummy","et magnis dis parturient montes, nascetur ridiculus mus. Proin",13,193),("tristique pellesque,","est","in consectetuer ipsum nunc id enim. Curabitur massa.",92,194),("arcu. Vestibulum","non,","mattis semper, dui lectus rutrum urna, nec luctus",3,195),("dolor sit","at,","Nullam lobortis quam a felis ullamcorper viverra.",56,196),("ligula. Donec","nec,","metus. Aenean sed pede nec",13,197),("libero. Integer","a","bibendum sed, est. Nunc laoreet lectus quis massa. Mauris",20,198),("adipiscing lobortis","a","sociis natoque penatibus et magnis",92,199),("lectus justo","metus","tempor lorem, eget mollis lectus pede et risus.",75,200);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("amet,","Donec","ut quam vel sapien imperdiet",29,201),("egestas.","malesuada","mollis. Integer",78,202),("dictum","porta","ornare. In faucibus. Morbi vehicula. Pellentesque",79,203),("sem","Morbi","id risus quis",88,204),("id,","lacus.","adipiscing ligula. Aenean gravida nunc",89,205),("non,","Nulla","natoque penatibus et magnis dis parturient montes, nascetur ridiculus",39,206),("turpis","varius.","eleifend vitae, erat. Vivamus nisi. Mauris nulla.",90,207),("libero","elit,","est arcu",60,208),("quis","a","arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum",53,209),("ante","mus.","porttitor eros nec tellus. Nunc",97,210);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("semper","consequat","ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet,",58,211),("eu,","in","mi tempor lorem, eget mollis lectus pede et",55,212),("dolor.","dictum","lobortis risus. In mi",14,213),("Sed","Donec","eu elit. Nulla facilisi.",21,214),("interdum","parturient","felis,",88,215),("Proin","consequat","Morbi metus. Vivamus euismod urna. Nullam",15,216),("libero.","pulvinar","eleifend",65,217),("ultrices","metus","ante lectus convallis",25,218),("felis","enim","dolor, tempus non, lacinia",35,219),("Etiam","eu","Proin velit. Sed malesuada augue",85,220);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("quis","dolor.","enim non",69,221),("amet","vitae","pharetra ut, pharetra sed, hendrerit a, arcu. Sed",55,222),("Donec","metus.","lorem vitae odio sagittis semper. Nam tempor diam dictum sapien.",46,223),("luctus","interdum","feugiat metus sit amet ante. Vivamus",72,224),("Duis","eget","sapien.",66,225),("lectus.","enim.","ullamcorper. Duis cursus, diam at pretium aliquet,",91,226),("nec","quam.","amet, consectetuer adipiscing elit. Etiam laoreet, libero",62,227),("amet,","aliquam","elit, dictum eu, eleifend nec, malesuada ut, sem.",85,228),("nonummy.","velit","Nunc laoreet lectus quis",57,229),("tempor","Duis","iaculis quis, pede. Praesent eu dui. Cum sociis",24,230);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("enim","dui","neque. Nullam ut nisi a odio semper cursus.",67,231),("molestie.","dui.","Nam tempor",50,232),("non,","sociis","ac turpis egestas. Fusce aliquet magna a",54,233),("commodo","Mauris","nec ligula consectetuer rhoncus.",63,234),("dictum","quis","posuere cubilia Curae;",67,235),("nonummy","Integer","ac mi eleifend egestas.",19,236),("libero.","ullamcorper","vel",97,237),("pede","leo.","ullamcorper, velit in aliquet lobortis,",20,238),("tellus","Duis","sociis natoque penatibus et magnis dis parturient",71,239),("libero","odio.","mollis. Duis sit amet diam eu dolor egestas rhoncus. Proin",78,240);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("cursus","ac","eu, placerat",15,241),("non","scelerisque","Pellentesque habitant morbi tristique",3,242),("pellentesque.","congue","lacus. Mauris non dui nec urna",91,243),("adipiscing","nibh","eu",33,244),("nulla.","sem.","quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar",37,245),("tellus","tortor.","Duis elementum, dui quis accumsan convallis, ante",6,246),("luctus","Phasellus","lacus, varius et, euismod et, commodo at,",10,247),("non","auctor","lacus pede sagittis augue, eu tempor erat",69,248),("Cras","non,","ultrices, mauris ipsum porta",68,249),("in","ad","Fusce diam nunc, ullamcorper eu, euismod",70,250);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("Maecenas","ultrices,","et, magna. Praesent interdum ligula",91,251),("nulla.","metus","Mauris magna. Duis dignissim tempor arcu. Vestibulum",61,252),("euismod","In","iaculis aliquet diam. Sed diam lorem,",76,253),("vitae","In","elit, pellentesque a, facilisis non, bibendum",64,254),("dui","tincidunt","metus. Vivamus euismod urna. Nullam lobortis quam a felis ullamcorper",54,255),("sem","libero.","magna a neque. Nullam ut nisi a odio",52,256),("Phasellus","at","tellus non magna. Nam ligula",92,257),("bibendum","orci.","dictum eu, eleifend nec, malesuada ut, sem.",66,258),("libero.","eros","magna. Phasellus dolor elit, pellentesque a, facilisis non, bibendum",71,259),("Nunc","purus","sodales",46,260);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("aliquet","mattis","Donec est.",67,261),("pulvinar","pede","dis parturient montes, nascetur ridiculus mus. Donec",39,262),("a","magnis","vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse sagittis.",10,263),("ante","rhoncus","placerat, orci lacus",62,264),("cursus,","Suspendisse","id sapien. Cras dolor dolor,",71,265),("sagittis","sed","erat",84,266),("enim.","Aliquam","luctus, ipsum leo elementum sem, vitae aliquam eros turpis",28,267),("Cras","metus.","imperdiet",56,268),("vel","ac,","habitant morbi tristique senectus",1,269),("aliquet","dolor.","ipsum ac mi eleifend egestas. Sed",80,270);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("mauris","dapibus","tellus id",90,271),("parturient","Maecenas","suscipit, est ac facilisis",50,272),("augue","Donec","gravida nunc sed pede. Cum sociis natoque penatibus",15,273),("lectus","nulla","velit dui, semper et, lacinia vitae, sodales at,",79,274),("sociis","Nunc","Duis mi enim, condimentum",66,275),("tristique","per","non enim commodo",80,276),("Phasellus","Vivamus","neque venenatis lacus. Etiam bibendum fermentum metus.",60,277),("penatibus","Cras","pharetra, felis eget varius ultrices, mauris ipsum porta",57,278),("et","In","Curabitur consequat, lectus",6,279),("risus.","convallis","consectetuer adipiscing elit. Etiam laoreet, libero et tristique",40,280);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("Vivamus","bibendum","Quisque nonummy",80,281),("lobortis","metus.","eu sem. Pellentesque ut ipsum ac mi",41,282),("rutrum,","ut,","enim, sit amet ornare lectus justo eu arcu. Morbi",19,283),("iaculis","ultrices,","Quisque nonummy ipsum non arcu. Vivamus",19,284),("Nullam","Pellentesque","erat",64,285),("tellus","diam","odio, auctor vitae, aliquet nec,",29,286),("congue.","montes,","mi, ac mattis velit justo nec ante. Maecenas mi felis,",77,287),("accumsan","fringilla,","mollis lectus pede et",11,288),("eu","nonummy","commodo hendrerit. Donec porttitor",72,289),("imperdiet,","Nulla","Sed id risus quis diam luctus",22,290);
-- INSERT INTO `towar` (`nazwa`,`jednostka`,`opis`,`id_faktura_pozycja`,`id`) VALUES ("arcu.","sed","felis. Nulla tempor augue ac ipsum. Phasellus vitae",32,291),("eu","cursus,","in faucibus orci luctus et ultrices",84,292),("tellus","blandit.","faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum.",56,293),("semper","vel","arcu. Morbi sit amet massa. Quisque",1,294),("ligula.","ut","imperdiet",7,295),("Nunc","Vivamus","lectus quis massa. Mauris vestibulum, neque sed dictum eleifend, nunc",33,296),("viverra.","ac","mollis lectus pede et risus. Quisque libero lacus, varius et,",81,297),("nec,","luctus","Sed molestie. Sed",4,298),("Quisque","Nunc","parturient montes, nascetur ridiculus mus. Aenean eget magna. Suspendisse",38,299),("semper.","et","scelerisque",69,300);


### 5.Wygenerować raport zawierający informację który towar jest najczęściej kupowany przez daną osobę tj. nazwa osoby i nazwa towaru. 
-- select o.id, d.nazwa, t.nazwa, fp.ilisc 
-- from faktura as f
-- join faktura_pozycja as fp on (f.id=fp.id_faktura)
-- join towar as t on (fp.id=t.id_faktura_pozycja)
-- join osoba as o on (o.id=f.id_osoba)
-- join dane_osobowe as d on (o.id=d.id_osoba)
-- group by o.id, t.id;

select o.id, d.nazwa, t.nazwa, sum(fp.ilisc) , max(sum(fp.ilisc))
from faktura as f
join faktura_pozycja as fp on (f.id=fp.id_faktura)
join towar as t on (fp.id=t.id_faktura_pozycja)
join osoba as o on (o.id=f.id_osoba)
join dane_osobowe as d on (o.id=d.id_osoba)
where o.id=16
group by t.id having max(sum(fp.ilisc))=sum(fp.ilisc);



### Zapytanie z zadania 5 byłoby takie (dodałem jeszcze 3 kolumnę z ilością tego produktu)
select o1.id, ds.nazwa,
(
select  (t.nazwa) from towar t
join towar_pozycja tp on (tp.id_towar=t.id)
join pozycja pz on (pz.id=tp.id_pozycja)
join faktura f on (f.id=pz.id_faktura)
join osoba os on (os.id=f.id_osoba)
where os.id=o1.id
group by t.nazwa,os.id
order by count(t.nazwa) desc limit 0,1
) as nazwa,
(
select  count(t.nazwa) from towar t
join towar_pozycja tp on (tp.id_towar=t.id)
join pozycja pz on (pz.id=tp.id_pozycja)
join faktura f on (f.id=pz.id_faktura)
join osoba os on (os.id=f.id_osoba)
where os.id=o1.id
group by t.nazwa,os.id
order by count(t.nazwa) desc limit 0,1
) as ilosc
FROM osoba o1
JOIN dane_osobowe ds ON (ds.id_osoba=o1.id);

### 6.Utworzyć aplikację w języku Java generującą zapytania zawierające losowe dane którymi można następnie zasilić bazę.

