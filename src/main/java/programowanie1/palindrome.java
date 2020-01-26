package programowanie1;

import java.util.Scanner;
/*Napisz metodę
public static boolean isPalindrome(int number)
        Sprawdzającą czy podana liczba jest palindromem (pisana od początku i od
        końca jest taka sama*/
public class palindrome {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        do {
            System.out.println("liczba:");
            long liczba = input.nextLong();
            boolean wartosc=isPalindrome(liczba);
            System.out.println("wynik : " + wartosc);
        }while (true);
    }


    public static boolean isPalindrome(long number){
        long checkNumber=number;
        long reversNumber=0;
        boolean ujemna=false;
        if(number<0){
            number*=-1;
            ujemna=true;
        }
//        boolean wynik=true;                       //na stringu
//        String tekst;
//        tekst=""+number;
//        for (int i=0;i<tekst.length();i++){
//            if(tekst.charAt(i)!=tekst.charAt(tekst.length()-1-i))
//                wynik=false;
//        }
        while (checkNumber>0){
            reversNumber= reversNumber * 10 + checkNumber % 10;
            checkNumber/=10;
        }
        if (ujemna)reversNumber*=-1;
        return (reversNumber==number);

    }
}
