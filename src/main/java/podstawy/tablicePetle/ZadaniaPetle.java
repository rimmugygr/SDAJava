package podstawy.tablicePetle;
import java.util.Scanner;
public class ZadaniaPetle {
    public static void main(String[] args){
        Scanner Input= new Scanner(System.in);
        //1. Utwórz tabliczkę mnożenia do 100 w postaci kwadratu 10x10 złożonego z liczb.
//        for (int i=1;i<=10 ; i++){
//            for (int j=1; j<=10 ; j++){
//                System.out.printf(" %3d",i*j);
//            }
//            System.out.printf("\n");
//
//        }
        // 2. Narysuj kwadratową ramkę pustą w środku o boku i ze znaków podanych przez użytkownika.
//        int bok = Input.nextInt();
//        String znak = Input.next();
//        for (int i=0;i<bok;i++){
//            for (int j=0;j<bok;j++){
//               if(i==0|i==bok-1)System.out.printf("%3S",znak);
//               else if(j==0|j==bok-1)System.out.printf("%3S",znak);
//               else System.out.printf("   ");
//            }
//            System.out.printf("\n");
//        }
        //3. Podaj sumę liczb z przedziału 1-100.
//        int suma=0;
//        for(int i=1;i<=100;i++){
//            suma+=i;
//        }
//        System.out.printf("%3d",suma);
       // 4. Stwórz program, który poprosi użytkownika o podanie wartości liczbowej. Następnie program wypisze wszystkie liczby naturalne, aż do zadanej.
//        int liczba=Input.nextInt();
//        for(int i=0;i<=liczba;i++){
//            System.out.printf("%3d",i);
//        }
        //5. Stwórz program, który pyta użytkownika o wartość całkowitą i który daje odpowiedź na pytanie, czy podano liczbę pierwszą.
//        int liczba=Input.nextInt();
//        String liczbaPierwsza = "liczba pierwsza";
//        for(int i=2;i<liczba;i++){
//            if(liczba%i==0) liczbaPierwsza = "nie jest liczba pierwsza";
//        }
//        System.out.printf("to jest %S",liczbaPierwsza);
        //6. Wypisz w konsoli:
        //*
        //**
        int liczba=Input.nextInt();
        for(int i=1;i<=liczba;i++){
            for(int j=1;j<=i;j++){
                System.out.printf(" *");
            }
            System.out.printf("\n");

        }






    }
}
