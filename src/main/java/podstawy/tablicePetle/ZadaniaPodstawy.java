package podstawy.tablicePetle;
import java.util.Scanner;
public class ZadaniaPodstawy {













    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*1. Zadeklaruj trzy zmienne liczbowe (całkowite) i przypisz im wartości. Następnie wypisz wartość największej z nich.
        2. Sprawdź, czy wartość przypisana zmiennej jest parzysta, czy nie (wypisz na ekranie odpowiedni komunikat). Użyj google,
                aby znaleźć sposób na sprawdzenie parzystości wartości.
        3. Sprawdź, czy wartość zmiennej jest większa, mniejsza, czy równa zero (użyj google żeby znaleźć odpowiedź, jak obsłużyć
        więcej niż dwa przypadki w instrukcji warunkowej).
        4. Rozwiąż zadanie 1. dla czterech zmiennych.*/

//        int aaa=7,bbb=8,ccc=11;
//
//        if(aaa>=bbb&aaa>=ccc)System.out.printf("%d ",aaa);
//        if(bbb>=aaa&bbb>=ccc)System.out.printf("%d ",bbb);
//        if(ccc>=bbb&ccc>=aaa)System.out.printf("%d ",ccc);
//
//        if(aaa%2==0)System.out.printf("pazysta ");
//        if(aaa>0|aaa<0)System.out.printf("wieksza,mniejsza ");
//        if(aaa==0)System.out.printf("rowna zero ");

        /*Scanner, switch
        1. Stwórz program, który poprosi użytkownika o podanie wartości liczbowej. Następnie program wypisze wszystkie liczby
        naturalne, aż do zadanej.
        2. Stwórz program, który poprosi użytkownika o podanie dwóch wartości - długości boków prostokąta. Następnie wypisze
        pole takiego prostokąta.
        3. Stwórz program, który spyta użytkownika o podanie figury, której pole chce policzyć:
        kwadratu, prostokąta, koła czy trójkąta. Następnie zgodnie z wyborem zada odpowiednie pytania o wymiary figury i wypisze
        jej pole oraz obwód.
        4. Stwórz program, który pyta użytkownika o wartość całkowitą i który daje odpowiedź na pytanie, czy podano liczbę
        pierwszą.*/

//        int aaa=input.nextInt();
//        for (int i=0;i<=aaa;i++){
//            System.out.printf("%3d",i);
//        }


//        int aaa=input.nextInt();
//        int bbb=input.nextInt();
//        System.out.printf("%3d",aaa*bbb);

//        System.out.printf("jaka figura");
//        String figura=input.nextLine();
//        int aaa,bbb,pole=0;
//        switch (figura){
//            case "kwadrat":
//                aaa=input.nextInt();
//                pole=aaa*aaa;
//                break;
//            case "prostokat":
//                aaa=input.nextInt();
//                bbb=input.nextInt();
//                pole=aaa*bbb;
//                break;
//            case "trojkat":
//                aaa=input.nextInt();
//                bbb=input.nextInt();
//                pole=aaa*bbb/2;
//                break;
//            case "kolo":
//                aaa=input.nextInt();
//                pole=aaa*aaa*3/2;
//                break;
//
//        }
//        System.out.printf("%d",pole);


//        int aaa=input.nextInt();
//        boolean pierwsza=true;
//
//        for (int i=2;i<aaa;i++){
//           if((aaa%i)==0)pierwsza=false;
//        }
//
//        System.out.print(pierwsza);

        /*For:
        1. Wypisz wszystkie liczby z zakresu 5 - 100.
        2. Wypisz wszystkie liczby z zakresu 55 - 150.
        3. Wypisz wszystkie liczby z zakresu 1 - 100 zaczynając od 100.
        4. Wypisz wszystkie liczby parzyste z przedziału 0 - 100.
        5. Dla liczb z przedziału 0 - 100 podaj informację, czy są podzielne przez 2, 3 i 5, w następujący sposób:
        0, podzielne przez 2, podzielne przez 3, podzielne przez 5
        1
        2, podzielne przez 2
        3, podzielne przez 3
        4, podzielne przez 2
        5, podzielne przez 5
        6, podzielne przez 2, podzielne przez 3
        7
        8, podzielne przez 2
        9, podzielne przez 3
        10, podzielne przez 2, podzielne przez 5
        6. Podaj sumę wszystkich liczb z przedziału 1 - 459 (skorzystaj z pętli for).
        7. Podaj wartość sumy wyrazów ciągu arytmetycznego. Wartość pierwszego wyrazu ciagu to 5, różnica każdych kolejnych
        dwóch wyrazów to 2. Chcemy zsumować 459 wyrazów (skorzystaj z pętli for).*/

//        for (int i=0;i<=100;i++){
//            if(i%2==0)System.out.printf("%3d",i);
//        }
//        for (int i=0;i<=100;i++){
//            System.out.printf("%3d Podzielna :",i);
//            if(i%2==0)System.out.printf(" 2,");
//            if(i%3==0)System.out.printf(" 3,");
//            if(i%5==0)System.out.printf(" 5,");
//            System.out.printf("\n");
//
//        }
//        int suma=0;
//        for (int i=0;i<=459;i++){
//            suma+=i;
//        }
//        System.out.print(suma);

//        int suma=0;
//        int element=5;
//        for (int i=0;i<459;i++){
//            suma+=element;
//            element+=2;
//        }
//        System.out.print(suma);


        /*While
        1. Stwórz program, który będzie zadawał użytkownikowi pytanie "Czy chcesz zakończyć działanie programu", póki nie
        odpowie "tak". (google: java porównanie stringów/java String comparison)
        2. Stwórz program, który poprosi użytkownika o podanie wartości liczbowej. Następnie sprawdzi, która potęga liczby 3 jest
        większa od zadanej wartości. Np. jeśli użytkownik podał 75, to odpowiedzią będzie 4, bo 3 do czwartej potęgi jest równe 81 i
        to pierwsza potęga liczby 3 większa od 75.
        3. Zapytaj użytkownika o liczbę całkowitą (kwotę). Następnie odpowiedz mu na pytanie, jaka kombinacja nominałów zajmie
        najmniej miejsca w portfelu. Np. dla 723 odpowiedzią jest:
        3 banknoty dwustuzłotowe, 1 banknot stuzłotowy, jeden dwudziestizłotowy, moneta dwuzłotowa oraz złotówka*/
//        String warunek;
//        do{
//            System.out.printf("czy koniec");
//            warunek=input.nextLine();
//        }while (warunek.equals("tak")==false);


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

            ZadaniaTablice metoda=new ZadaniaTablice();
            int[] tablica={0,1,3,6,78,0};
            metoda.print(metoda.getMinMaxSum(tablica));
            System.out.printf("\n");
            metoda.print(metoda.getDistinct(tablica));

    }
}
