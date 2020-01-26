package programowanie1;

import java.util.Scanner;

/*Napisz metodę
public static int getLargestPrime(int number)
        Zwracającą największy dzielnik podanej liczby który jednocześnie jest liczbą
        pierwszą.*/
public class largestPrime {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        do {
            long liczba = input.nextLong();
            System.out.println("Wynik "+getLargestPrime((int) liczba));
        }while (true);
    }

    public static int getLargestPrime(int liczba){
        int wynik=1,temp=0;
        for(int i=1;i<liczba;i++){
           if(liczba%i==0){
               boolean liczbapierwsza=true;
               for (int j=2;j<i;j++){
                   if(i%j==0)liczbapierwsza=false;
               }
               if(liczbapierwsza&&i>wynik)wynik=i;
           }
        }
//        int temp=1,temp2=2,wynik=0;
//        while (temp<liczba){
//            if(liczba%temp==0){
//                boolean liczbaPierwsza=true;
//                while (temp2<temp){
//                    if(temp%temp2==0)liczbaPierwsza=false;
//                    temp2++;
//                }
//                if (liczbaPierwsza)wynik=temp;
//            }
//            temp++;
//        }
        return wynik;
    }
}
