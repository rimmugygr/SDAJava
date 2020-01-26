package programowanie1.test;

import java.util.Scanner;

public class Silnia {
    public static void main(String[] args) {
        do{
            Scanner input = new Scanner(System.in);
            System.out.println(silnia(input.nextInt()));
            System.out.println(silniaRekurencja(input.nextInt()));
        }while (true);


    }
    public static long silnia(long number){
        long temp=1;
        //for(int i=1;i<=number;i++)  temp*=i;
        while (number>1) temp*=number--;
        return temp;
    }

    public static long silniaRekurencja(long number){
        return number > 1 ? silniaRekurencja(number-1)*number : 1;
    }

    private void testMethod(){
        System.out.println("Nothing");
    }


}
