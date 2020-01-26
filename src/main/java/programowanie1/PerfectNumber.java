package programowanie1;
/*Napisz metodę
public static boolean isPerfectNumber(int year)
        sprawdzającą czy podana liczba jest równa sumie wszystkich jej dzielników.
        Np 6 jest podzielne przez 1, 2, 3 i 1+2+3=6*/


import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        do {
            int liczba = input.nextInt();
            if (isPerfectNumber( liczba))System.out.println(liczba+"podana liczba jest równa sumie wszystkich jej dzielników " + isPerfectNumber( liczba));

        } while (true);

    }

    public static boolean isPerfectNumber(int liczba) {
        if(liczba<0)return false;
        int temp=1,counter=0;
        while (temp<liczba){
            if(liczba%temp==0)counter+=temp;
            temp++;
        }
        return counter==liczba;
    }
}
