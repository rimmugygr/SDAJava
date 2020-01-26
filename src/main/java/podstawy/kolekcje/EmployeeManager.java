package podstawy.kolekcje;

import java.util.*;

public class EmployeeManager {
    public static void main(String[] args) {
        /*1. Stwórz mapę, gdzie kluczem będzie pracownik, a wartością jego manager.
            a) Klucz i wartość są typu String
            b) Klucz i wartość są typu „Employee” oraz „Manager”
            c) *Klucz jest typu „Manager”, wartość jest listą przechowującą typ „Employee”
            d) *Pozwól na zwolnienie danego pracownika, wyświetl rezultat
            e) *Pozwól na zatrudnienie nowego pracownika, wyświetl rezultat*/

        Map<Manager, List<Employee>>mapaGrup=new HashMap<>();
        Employee pracownik = new Employee("a","b");



        List<Employee>listaPrzacownikow1=new LinkedList<>();
        listaPrzacownikow1.add(new Employee("woj","wojtek"));
        listaPrzacownikow1.add(new Employee("mis","uszatek"));
        mapaGrup.put(new Manager("szef","juzek"),listaPrzacownikow1);

        List<Employee>listaPrzacownikow2=new LinkedList<>();
        listaPrzacownikow2.add(new Employee("ala","uszatek"));
        listaPrzacownikow2.add(pracownik);
        mapaGrup.put(new Manager("aaa","bbbb"),listaPrzacownikow2);

        for (Map.Entry<Manager,List<Employee>> grupa: mapaGrup.entrySet()) {
            System.out.println(grupa.getKey()+grupa.getValue().toString());
        }



        for (Map.Entry<Manager,List<Employee>> grupa: mapaGrup.entrySet()) {//usuwanie 2 sposoby
            grupa.getValue().remove(pracownik);//usuwamy z listy obiektów dany obiekt

            for (Employee praconicyWGrupie: grupa.getValue()){//wyciagamy obiekty z listy
                if(praconicyWGrupie.nazwisko.equals("uszatek")&&praconicyWGrupie.imie.equals("mis"))// sprawdzamy prametry obiektu
                    grupa.getValue().remove(praconicyWGrupie);//usuwamy
            }

        }

        for (Map.Entry<Manager,List<Employee>> grupa: mapaGrup.entrySet()) {
            System.out.println(grupa.getKey()+grupa.getValue().toString());
        }

        for (Map.Entry<Manager,List<Employee>> grupa: mapaGrup.entrySet()) {
            if(grupa.getKey().imie.equals("szef"))
            grupa.getValue().add(new Employee("dupa","dupa"));
        }

        for (Map.Entry<Manager,List<Employee>> grupa: mapaGrup.entrySet()) {
            System.out.println(grupa.getKey()+grupa.getValue().toString());
        }


    }
}
