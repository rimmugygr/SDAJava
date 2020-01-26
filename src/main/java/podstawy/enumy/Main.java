package podstawy.enumy;

import java.util.Scanner;

public class Main {
    static enum owocTempStatic{
        aaaaa,aaaa,a;

    }

    public enum owocTemp{
        AAAA,bbb,cccc;
    }

    private static String owoceStatic="aaaa";

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

//        EnumClass.owoc owoce;
//        owoce = EnumClass.owoc.APPLE;
//        owoce = EnumClass.owoc.BANANA;
//        owoce = EnumClass.owoc.PEAR;
//
//        System.out.println(owoce.values());
//        for (EnumClass.owoc o : EnumClass.owoc.values()) System.out.print(o + " ");
//        System.out.println();
//
//        owocTemp owoce2;
//        owoce2 = owocTemp.bbb;
//        owoce2 = owocTemp.AAAA;
//        owocTempStatic owoce3;
//        owoce3 = owocTempStatic.aaaaa;
//
//        System.out.println(owocTemp.valueOf("bbb"));
//
//        System.out.println(owocTemp.values());
//        for (owocTemp s : owocTemp.values()) System.out.print(s + " ");
//        System.out.println();
//
//        System.out.println(owoce3 + "\n");

        /*ENUM:
        1. Napisz program z użyciem konstrukcji enum to wyboru jednego z owoców: APPLE, PEAR, BANANA, w zależności o wyboru : "Wybrałeś ..."
        pokaż różne rozwiązania:
        a) z konstrukcją enum wewnątrz klasy Głównej
                b) z osobną "klasą" enum
        c) używając wprost wartości z enum
        d) pobierając wartość ze zmiennej statycznej
        Czy jest możliwe przyjęcie dla wartości wpisanej z klawiatury ?
        */

//        Owoc owoc = Owoc.valueOf("aaaa");
//        Owoc maValue = Owoc.aaaa;

        /*ENUM:
        1. Napisz program z użyciem konstrukcji enum
        a) -  z osobną "klasą" enum ktora zawieraz dane danej osoby (imie, nazwisko, wzrost i plec)
            -  wybieranie z klawiatury podanej osoby na podstawie jej danych (imie, nazwisko)
        c)* plec ma rozne sposoby zapisu np mezczyzna: M , men, facet, mezczyzna lecz tylko dwie warosci
           - wybieraj plec na podstawie roznych danych z klawiatury
           - nieoznaczona gdy nie ma w slowniku (* skorzystaj z wyjatkow)
        */
        do{
            System.out.println("podaj imie nazisko:");
            String imie = input.nextLine();
            String nazwisko = input.nextLine();
//            Person osoba=Person.getPerson(imie,nazwisko);
//            if (Person.getPerson(imie,nazwisko)==null) //wresja gdzie funkcja zwraca null
//                System.out.println("nie mam takiej osoby");//gdy nie zainicjowano bo Person.getPerson zwrociło null
//            else System.out.println(osoba.toString());//gdy zainicjowna wypisz
            try {//wresja z blokiem try catch bo funkacja moze zrocic wyjatek
                System.out.println(Person.getPerson(imie,nazwisko));
            } catch (Exception e) {//jezli null to wyjatek
                System.out.println("nie ma takiej osoby");
            }






            System.out.println("podaj plec:");
            String tekst = input.nextLine();

            try {//jezeli zwraca 0 albo 1
                System.out.println(Gender.isGenderMenorWonem(tekst) ? "mezczyzna" : "kobieta");
            } catch (Exception e) {//jezli null to wyjatek obslugujemy
                System.out.println("nieznana");
            }




        }while (true);





    }
}
