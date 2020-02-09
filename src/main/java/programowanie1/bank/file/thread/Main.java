package programowanie1.bank.file.thread;


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




        Bank bank1 = new Bank("NBP");

/*        for (Client client : InputFile.getClientFromFile2Line("bankclients2line.txt")) {
            System.out.println(client.getViewAccounts());
        }*/





        bank1.addClients(InputFile.getClientFromFile1Line("bankclients1line.txt"));

        Client client1=bank1.addClient(new Client("aaa", "bbb", "12345"));
        String client1Account1 = bank1.addAccount(client1,"O");
        String client1Account2 = bank1.addAccount(client1,"R");
        String client1Account3 = bank1.addAccount(client1,"P");

        Client client2=bank1.addClient(new Client("xxx", "yyy", "12345"));
        String client2Account1 = bank1.addAccount(client2,"O");
        String client2Account2 = bank1.addAccount(client2,"R");
        String client2Account3 = bank1.addAccount(client2,"R");


        bank1.payIn(client1Account1,222);
        bank1.payIn(client1Account1,333);
        bank1.payIn(client2Account2,11);
        bank1.payIn(client2Account3,66);

        bank1.payOff(client1Account1,333);
        bank1.payOff(client1Account1,333);

        System.out.println(bank1.getViewClient());
        System.out.println(bank1.getViewWithClientSaldo());
        System.out.println(bank1.getViewAccount());
        System.out.println(bank1.getViewAccountWithSaldo());
    }


}
