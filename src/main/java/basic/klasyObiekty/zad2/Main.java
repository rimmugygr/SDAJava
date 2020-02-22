package basic.klasyObiekty.zad2;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        /*1. Bazując na napisanej wcześniej aplikacji:
        a) Stwórz aplikację – magazyn produktów
        b) Obsłuż wybór zadania do wykonania:
                - dodawanie nowego produktu: nazwa, cena, liczba dostępnych sztuk
        - wyświetlanie stanu magazynu
        c) *skorzystaj z kompozycji (Magazyn zawierający Produkt[y])
        d) **suma wartości poszczególnych/wszystkich produktów w magazynie
        e) ***aktualizacja stanu magazynu, np.:
        - „kombinerki:30”
        - „kombinerki:+4”
        Wymagania:
        Rozbicie aplikacji na klasy i metody. Użycie pól statycznych (id produktu). Najpierw jakoś
        potem dodać „ć”.*/
        System.out.printf("Wielkosc magazynu");
        int wielkosc=input.nextInt();
        Magazyn magazyn=new Magazyn(wielkosc);
        int warunek =1;
        do {
            System.out.printf("Podja id dodania produktu (0 edycja pozycji, -1 wyjscie, 1 kombinerki, 2 wiertarka) ");
            warunek=input.nextInt();
            if(warunek==1){
                System.out.printf("Marka ");
                String aaa=input.next();
                System.out.printf("ilosc ");
                double bbb=input.nextDouble();
                System.out.printf("cena ");
                int ccc=input.nextInt();
                Kombinerki kombinerki = new Kombinerki(aaa,bbb,ccc);
                magazyn.dodajProdukt(kombinerki);
            }
            if(warunek==2){
                System.out.printf("Marka ");
                String aaa=input.next();
                System.out.printf("ilosc ");
                double bbb=input.nextDouble();
                System.out.printf("cena ");
                int ccc=input.nextInt();
                Wiertarka wiertarka=new Wiertarka(aaa,bbb,ccc);
                magazyn.dodajProdukt(wiertarka);
            }
            if(warunek==0){
                int pozycja=input.nextInt();
                Produkt[] produkt = magazyn.getProdukt();
                System.out.print(produkt[pozycja].liczba+" "+ produkt[pozycja].nazwa+" "+ produkt[pozycja].cena);
                String aaa=input.next();
                produkt[pozycja].setNazwa(aaa);
                double bbb=input.nextDouble();
                produkt[pozycja].setCena(bbb);


            }
            System.out.printf(magazyn.toString()+"\n");


        }while (warunek!=-1);



//        Kombinerki kombinerki1=new Kombinerki("Male kombinerki",4.7,7);
//        Magazyn magazyn=new Magazyn(kombinerki1,7);
//        System.out.printf(magazyn.toString()+"\n");
//
//        Kombinerki kombinerki2=new Kombinerki("Duze kombinerki",9.7,2);
//        magazyn.dodajProdukt(kombinerki2);
//        System.out.printf(magazyn.toString()+"\n");
//
//        Wiertarka wiertarka1=new Wiertarka("Wiertarka udarowa",55,3);
//        magazyn.dodajProdukt(wiertarka1);
//        System.out.printf(magazyn.toString()+"\n");





        Wiertarka wiertarka2=new Wiertarka("Ruska Wiertarka",12,1);




    }


}
