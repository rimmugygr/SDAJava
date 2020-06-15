
# zad 2
-- select * from osoba where (saldo_ma - saldo_wn) = (select min(saldo_ma - saldo_wn) from osoba);
-- select nazwa, saldo_ma - saldo_wn as saldo from osoba order by saldo asc limit 0,1;

# zad 3
-- select * from osoba where (saldo_ma - saldo_wn) = (select max(saldo_ma - saldo_wn) from osoba where year(dodano)=2012);
-- select nazwa, saldo_ma - saldo_wn as saldo from osoba where year(dodano)=2012 order by saldo desc limit 0,1;

# zad 4
-- select avg(saldo_ma - saldo_wn) from osoba;

# zad 5
-- select miejscowosc , sum(ilosc_wplat) as suma_ilosci_wplat from osoba group by miejscowosc oreder by suma_ilosci_wplat;

# zad 6
-- select * from osoba where 
-- (ilosc_wplat between 50 and 80) and (saldo_ma - saldo_wn) > (select avg(saldo_ma - saldo_wn) from osoba);

# zad 7 Znajdź miejscowość z największym zadłużeniem (minimalnym saldem) której suma wpłat jest poniżej 50 TODO 
-- select  miejscowosc from osoba group by miejscowosc having count(ilosc_wplat) < 50;
-- select  miejscowosc,(saldo_ma - saldo_wn) from osoba 
-- where (saldo_ma - saldo_wn) =  (select sum(tab.saldo_ma - tab.saldo_wn) from osoba as tab group by tab.miejscowosc)
-- group by miejscowosc having count(ilosc_wplat) < 50;

-- select miejscowosc , min(saldo_ma-saldo_wm), sum(ilosc_wplapt)
-- from osoba
-- having sum (ilosc_wplat) < 50
-- order by sum(saldo_ma-saldo_wm)
-- asc limit 0,1;

# zad 8 Sporządź raport ze średniego salda oraz ilość wpłat dla każdej z miejscowości która ma całkowite saldo dodatnie.
-- select miejscowosc , count(ilosc_wplat) as suma_ilosci_wplat, avg(saldo_ma - saldo_wn) as saldo_miescowosci 
-- from osoba group by miejscowosc having (saldo_miescowosci) > 0;

# zad 9 Sprawdź jaka jest ilość wpłat w rozbiciu na rok dodania osoby do bazy 

# zad 10 Znajdź średnią wartość wpłaty w rozbiciu na poszczególne miasta z uwzględnieniem tylko tych które mają saldo dodatnie TODO 
-- select miejscowosc
-- from osoba
-- group by miejscowosc
-- having sum(saldo_ma-saldo_wm) >0 
-- order by avg(saldo_ma) desc;

# zad 11 Sporządź raport ze średniego salda osoby urodzonej pomiędzy 1980 a 1990 rokiem w rozbiciu na poszczególne miejscowości TODO 
-- select miejscowosc from osoba
-- group by miejscowosc
-- having year(data_urodzenia) between 4 and 4 
-- order by (saldo_ma-saldo_wm) desc
