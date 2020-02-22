package basic.tablicePetle;

import java.util.Scanner;
public class ZadanaTabliceDom {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
    /*Tablice
        1. Napisz metodę print, która wypisze w konsoli elementy tablicy intów, przekazanej jako parametr.
        2. Napisz metodę getMax, która przyjmie za parametr tablicę intów, a która zwróci największą wartość z tej tablicy.
        3. Napisz metodę getMin, która zwróci najmniejszy element przekazanej tablicy intów.
        4. Napisz metodę getSum, która przyjmie za parametr tablicę intów, a któa zwróci sumę jej elementów.
        5. Napisz metodę getMaxMinAndSum, która przyjmie za parametr tablicę intów, a która zwróci tablicę trzyelementową, której
        pierwszy element to wartość największa, drugi to najmniejsza, a trzeci suma wszystkich elementów.
        6. Napisz metodę getLarger, która przyjmie za parametry dwie tablice intów, a która zwróci tę tablicę, której suma elementów
        jest większa.
        7. Napisz metodę merge, która za parametry dwie tablice intów, a która zwróci tablicę, która zawierać będzie wszystkie
        elementy z jednej i drugiej tablicy.
        3 | 8
        8. Napisz metodę getDistinct, która za parametr przyjmie tablicę, a która zwróci tablicę, w której będą elementy bez
        powtórzeń z tablicy przekazanej w parametrze.*/

/*        Zadania do domu:
                Oprócz wypełnienia zadań z powyższych stron macie tu kilka z ostatnio omawianego materiału i 2 z wcześniejszych:
        1. Napisz metodę concatenate, która przyjmie dwa łańcuchy znaków jako parametry, a która zwróci ich konkatenację.
        2.  Napisz metodę power, która przyjmie dwa parametry typu int, a która zwróci wynik potęgowania o podstawie i wykładniku takich, jak przekazano.
        3.  Stwórz klasę Triangle, która będzie miała pola: a, b, h (długości boków). Do klasy dodaj konstruktor  oraz metody ustawiający wartości domyślne w konstruktorze.  W klasie głównej pytaj czy użytkownik chce pozostawić wartości domyślne jeśli nie ma zdefiniować własne wprowadzając je z klawiatury.
        4. Stwórz program, który poprosi użytkownika o podanie wartości liczbowej. Następnie sprawdzi, która potęga liczby 3 jest
        większa od zadanej wartości.
        Np. jeśli użytkownik podał 75, to odpowiedzią będzie 4, bo 3 do czwartej potęgi jest równe 81 i
        to pierwsza potęga liczby 3 większa od 75.
        5. Zapytaj użytkownika o liczbę całkowitą (kwotę). Następnie odpowiedz mu na pytanie, jaka kombinacja nominałów zajmie najmniej miejsca w portfelu.
                Np. dla 723 odpowiedzią jest: 3 banknoty dwustuzłotowe, 1 banknot stuzłotowy, jeden dwudziestozłotowy, moneta dwuzłotowa oraz złotówka. (edited)*/

        int a, b, c;
        ZadaniaTablice zad1=new ZadaniaTablice();
        System.out.printf("1 liczba ");
        a = input.nextInt();
        System.out.printf("2 liczba ");
        b = input.nextInt();
        System.out.printf("%d",zad1.power(a,b));

        ZadaniaTablice zad4 = new ZadaniaTablice();
        System.out.printf(" liczba ");
        a = input.nextInt();
        System.out.printf("%d",zad4.potega3(a));

        Banknoty portfel = new Banknoty();
        System.out.printf(" liczba ");
        a = input.nextInt();
        System.out.printf("%d", portfel.nowaKwota(a));
        System.out.printf(portfel.toString());

        int[] monety = {5, 2, 1};
        Banknoty portfelMonety = new Banknoty(monety, a);
        System.out.printf(portfelMonety.toString());


        System.out.printf("Default value: Y/N");
        String cheac=input.next().toLowerCase();
        Triangle trojkat;
        if(cheac.equals("y")) {
            trojkat=new Triangle();
        }
        else{
            System.out.printf("1 number ");
            a=input.nextInt();
            System.out.printf("2 number ");
            b=input.nextInt();
            System.out.printf("3 number ");
            c=input.nextInt();
            trojkat=new Triangle(a,b,c);
        }

        System.out.printf(trojkat.toString());


    }




}
