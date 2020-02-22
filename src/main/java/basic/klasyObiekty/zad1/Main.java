package basic.klasyObiekty.zad1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        /*Stwórz klasę Pokoj.
                a) Dodaj atrybuty wysokość, szerokość, długość (typu double).
        b) Dodaj konstruktor, który przyjmie wszystkie wartości.
                c) Dodaj drugi konstruktor, który przyjmie szerokość i długość a wysokość ustawi na
        2,4.
        d) Dodaj metody obliczające oraz zwracające pole powierzchni oraz objętość pokoju.
        e) Dodaj metody wyświetlające pole powierzchni oraz objętość pokoju.
        f) Z poziomu metody main zaprezentuj działanie poszczególnych metod.
        g) Stwórz listę pokoi. Wyświetl ich parametry.*/

//        Pokoj salon=new Pokoj(8.777, 7676.4, 345.456);
//        Pokoj kuchnia=new Pokoj(8.777, 7676.4);
//
//        Pokoj[] pokoje=new Pokoj[3];
//        pokoje[0]=salon;
//        pokoje[1]=kuchnia;
//        pokoje[2]=new Pokoj(38.777, 76.4);
//
//        System.out.printf("%s\n",pokoje[0].toString());
//        pokoje[0].wyswietlObjetosc();
//        pokoje[0].wyswietlPole();
//
//        System.out.printf("%s\n",kuchnia.toString());
//        System.out.printf("objetość %12.3f\n",kuchnia.objetosc());
//        System.out.printf("pole     %12.3f\n",kuchnia.pole());
//
//
//
//        System.out.printf("%s\n",pokoje[2].toString());
//        pokoje[2].wyswietlObjetosc();
//        pokoje[2].wyswietlPole();
//


       /* Stwórz klasę Pies.
                a) Dodaj atrybuty rasa, wiek, płeć
        b) Dodaj metody umożliwiające ustawienie wieku oraz pobranie wieku (getAge,
                setAge)
        c) Dodaj konstruktor, który przyjmie wartości dla rasy i płci, a wiek ustawi na 0
        d) Dodaj metodę powodująca wypisanie na ekran dźwięku wydawanego przez psa
        „Woof!”
        e) Z poziomu metody main zaprezentuj działanie poszczególnych metody – utwórz
        obiekt klasy Pies, zmodyfikuj wiek, wyświetl parametry psa.
        f) *Stwórz listę składającą się z 2 różnych psów, wypisz wartości ich atrybutów.

        2. Zaprezentuj wykorzystanie zmiennej statycznej, która umożliwi zliczanie utworzonych
        obiektów danej klasy (np. Pies).
        */



//       Pies burek=new Pies("kundel","suka");
//       burek.setWiek(7);
//       System.out.printf("wiek-%d plec-%s rasa-%s \n",burek.getWiek(),burek.getPlec(),burek.getRasa());
//
//
//        Pies bobi=new Pies("pudel","samiec");
//        bobi.setWiek(17);
//        System.out.printf("wiek-%d plec-%s rasa-%s \n",bobi.getWiek(),bobi.getPlec(),bobi.getRasa());
//
//        Pies[] lista=new Pies[2];
//        lista[0]=burek;
//        lista[1]=bobi;
//        for (Pies element:lista) {
//            System.out.printf(element.toString()+"\n");
//        }
//        System.out.printf("liczba psów:%d\n",Pies.getLiczba());
//        System.out.printf("liczba zwierzat:%d\n",Zwierzeta.getLiczbaZwierzat());

        /*1. Analogicznie do klasy Pies stwórz klasę Kot, zaprezentuj jej działanie.
        2. Stwórz klasę nadrzędną, np. ZwierzeDomowe, po której będzie dziedziczył Kot i Pies.
        Przenieś do klasy ZwierzeDomowe wszystkie wspólne metody i atrybuty.
        3. Stwórz tablicę przechowującą obiekt klasy Pies i obiekt klasy Kot. Wypisz wydawane przez
        nie dźwięki.*/
        /*2. Utwórz klasę Kaganiec (rozmiar, materiał wykonania…), której obiekt będzie zawierała
        klasa Pies (kompozycja). Wyświetl dane dotyczące kagańca za pośrednictwem obiektu
        psa.*/

//        System.out.printf("\ndzieniczenie\n");
//
//        Zwierzeta[] zoo=new Zwierzeta[3];
//        zoo[0]=new Pies("kundel","suka",7);
//        zoo[1]=new Kot("dachowiec","samiec");
//        zoo[2]=new Pies("kundel","samiec",7,7,"skora");
//
//        for (Zwierzeta element:zoo) {
//            System.out.printf(element.toString()+"   ");
//            element.dajGlos();
//        }
//        // zoo[2] nie ma dostepu do wypiszKaganiec()
//
//        Pies piesNaSmyczy=new Pies("kundel","samiec",7,7,"skora");
//        System.out.printf(piesNaSmyczy.toString()+"   ");
//        piesNaSmyczy.dajGlos();
//        System.out.printf(piesNaSmyczy.wypiszKaganiec());

        /*1. Stwórz 3 klasy: Czlowiek, Programista, JavaDeveloper.
                a) Powiąż klasy:
        • Czlowiek jest nadrzędny
        • Programista dziedziczy po Czlowiek
        • JavaDeveloper dziedziczy po Programista
        b) Dla każdej z klas stwórz konstruktor, który wywoła konstruktor nadrzędny (jeśli
                istnieje) oraz wypisze informację o swoim wywołaniu, np. dla klasy Czlowiek
        powinniśmy otrzymać komunikat „Wywołanie konstruktora Czlowiek”.
        c) Utwórz obiekt klasy JavaDeveloper
        d) *Za pośrednictwem obiektu JavaDeveloper wywołaj dowolną metodę utworzoną
        w klasie Czlowiek, która przyjmie jeden parametr. Jaki powinna posiadać
        modyfikator dostępu?
        e) **Przeciąż metodę z klasy Człowiek wewnątrz klasy JavaDeveloper tak, aby mogła
        przyjmować dodatkowe parametry.*/


//        JavaDeveloper pracownik=new JavaDeveloper();
//        pracownik.cosTamWypisz("aaaaaaaa");
//        pracownik.cosTamWypisz("aaaaa","bbbbb");

        /*1. Stwórz kalkulator korzystając z metod statycznych:
        a) Stwórz najbardziej popularne metody: dodawanie, odejmowanie, mnożenie,
                dzielenie, reszta z dzielenia wewnątrz klasy „Kalkulator”
        b) Stwórz mechanizm wyboru przez użytkownika, która metoda zostanie wykonana.
                c) Zaprezentuj działanie poszczególnych metod*/
//        int a,b;
//        Kalkulator kalkulator=new Kalkulator();
//        System.out.printf("1 liczba ");
//        a=input.nextInt();
//        System.out.printf("2 liczba ");
//        b=input.nextInt();
//        System.out.printf("dzialanie: ");
//        String dzialanie=input.next();
//
//        switch (dzialanie){
//            case "dodawanie":
//                System.out.printf("%d",Kalkulator.dodawanie(a,b));
//                break;
//            case "odejmowanie":
//                System.out.printf("%d",Kalkulator.odejmowanie(a,b));
//                break;
//            case "mnozenie":
//                System.out.printf("%d",Kalkulator.mnozenie(a,b));
//                break;
//            case "dzielenie":
//                System.out.printf("%d",Kalkulator.dzielenie(a,b));
//                break;
//            case "resztazdzielenia":
//                System.out.printf("%d",Kalkulator.modulo(a,b));
//                break;
//            default:
//                System.out.printf("zle dzialanie");
//                break;
//
//
//
//        }



    }
}
