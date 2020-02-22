package programing1.bank_file.test;


import programing1.bank_file.BankOperations;
import programing1.bank_file.Client;
import programing1.bank_file.InputFile;
import programing1.bank_file.domena.Bank;

/**
 * Bank: nazwa, lista klientów, OPT(lista rachunków)
 * Klient: imie, nazwisko, pesel, unikalny numer klienta, lista rachunków
 * Rachunek: typ, stan rachunku
 * operacje:
 * założenie klienta
 * założenie rachunku dla klienta
 * usunięcie rachunku dla klienta (jeśli stan środków = 0)
 * usunięcie klienta (jeśli nie ma rachunków)
 * wpłata na rachunek
 * wypłata z rachunku
 * lista klientów banku (z listą rachunków(z saldem lub bez))
 * lista rachunków klienta (z saldem lub bez)
 * OPT(lista rachunków (z saldami lub bez))*
 *
 */
public class Main {

    public static void main(String[] args) {


        BankOperations bankNBP = new BankOperations(new Bank("NBP"));



        /*for (Client client : InputFile.getClientFromFile2Line("bankclients2line.txt")) {
            System.out.println(client.getViewAccounts());
        }*/





        bankNBP.addClients(InputFile.getClientFromFile2Line("bankclients1line.txt"));

        Client client1=bankNBP.addClient(new Client("aaa", "bbb", "12345"));
        String client1Account1 = bankNBP.addAccount(client1,"O");
        String client1Account2 = bankNBP.addAccount(client1,"R");
        String client1Account3 = bankNBP.addAccount(client1,"P");

        Client client2=bankNBP.addClient(new Client("xxx", "yyy", "12345"));
        String client2Account1 = bankNBP.addAccount(client2,"O");
        String client2Account2 = bankNBP.addAccount(client2,"R");
        String client2Account3 = bankNBP.addAccount(client2,"R");


        bankNBP.payIn(client1Account1,222);
        bankNBP.payIn(client1Account1,333);
        bankNBP.payIn(client2Account2,11);
        bankNBP.payIn(client2Account3,66);

        bankNBP.payOff(client1Account1,333);
        bankNBP.payOff(client1Account1,333);

        System.out.println(bankNBP.getViewClient());
        System.out.println(bankNBP.getViewWithClientSaldo());
        System.out.println(bankNBP.getViewAccount());
        System.out.println(bankNBP.getViewAccountWithSaldo());
    }


}
