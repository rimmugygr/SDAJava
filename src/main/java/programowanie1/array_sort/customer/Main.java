package programowanie1.array_sort.customer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            int number=Integer.parseInt(input.nextLine());//pobieramy dlugosc tablicy
            Customer[] bank=createNewCustomers(number);//tablica z kientami
            viewCustomers(bank);//wyswietla tablice

            System.out.println("Sortujemy rosnaco");
            CompareByAmount compare = new CompareByAmount();//tworzymy obiekt komparatora
            Arrays.sort(bank,compare);//sortowanie tablicy przy uzyciu komparatora

            viewCustomers(bank);//wyswietla tablice

            System.out.println("Sortujemy malejaco");
            Arrays.sort(bank);//sortowanie tablicy przy uzyciu komparatora wbudowanego w klasie
            viewCustomers(bank);//wyswietla tablice





        }while (true);
    }

    private static Customer[] createNewCustomers(int number){//zwraca tablice klientow
        Customer[] tab=new Customer[number];
        String firstName;
        String secondNme;
        double amount;
        for (int i=0;i<tab.length;i++) {
            firstName = input.nextLine();
            secondNme = input.nextLine();
            amount = Integer.parseInt(input.nextLine());
            tab[i]=new Customer(firstName,secondNme,amount);
        }
        return tab;
    }

    private static void viewCustomers(Customer[] customers){
        System.out.println("Klienci :");
        for (Customer c:customers) {
            System.out.println(c.toString());
        }
    }

}
