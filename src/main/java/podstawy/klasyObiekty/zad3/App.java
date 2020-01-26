package podstawy.klasyObiekty.zad3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        /*1. Tworzymy aplikację składającą się z 6 klas lub 5 klas i 1 interfejsu.
                a) Klasa App zawiera metodę main i nic więcej
        b) Klasa StringParserzawiera statyczną metodę pozwalającą na przetworzenie za pośrednictwem Regex wejściowego tekstu na zmienne niezbędne do utworzenia obiektu klasy Person
        c) Klasa Vehicle jest klasą abstrakcyjną (*lub interfejsem – dla chętnych), którą dziedziczą (*implementują) klasy Car oraz Bike
        2. Przekazujemy do aplikacji tekst ze wszystkimi danymi wymaganymi do realizacji punktu 1b. Za pośrednictwem konsoli lub poprzez wpisanie na sztywno danych do zmiennej typu String.
        3. Przetwarzamy podany w pkt.2 tekst na obiekt klasy Person (dalej „osoba”). Osoba kupuje samochód oraz rower.
        4. Za pośrednictwem pętli for-each demonstrujemy efekt zakupu, np. „ kupił  marki  ”. „imię” pochodzi z obiektu klasy Person, dane dotyczące kupionych rzeczy pochodzą z samochodu oraz roweru. Moment zakupu powinien zostać zapisany wewnątrz obiektu, którego dotyczy (samochodu, roweru).
        5. *Markę i model auta/roweru przechowujemy w Enumie (do wyświetlenia informacji skorzystajcie z metody toString() dostępnej dla wartości Enuma).*/

        do {
            System.out.println("Imię , nazwisko , auto , rower");
            String dane = input.nextLine();
            StringParser.setDane(dane);
        }while (StringParser.getDane()[0]==null);




        //Person osoba=new Person(StringParser.getImie(),StringParser.getNazwisko());
        Person osoba=new Person(StringParser.getDane());

        Vehicle[] tablica=new Vehicle[10];
        tablica[0]=new Car("BMW","11.02.2001");
        tablica[1]=new Bike("ROMET","12.12.2121");

        for (Vehicle element:tablica) {
            if(element!=null){
                System.out.println(element.toString());
            }
        }






    }
}
