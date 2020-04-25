package programing2.wallet;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import programing2.wallet.exceptions.IncorrectCurrencyException;
import programing2.wallet.exceptions.IncorrectAmountException;
import programing2.wallet.exceptions.NoEnoughMoneyException;

import java.io.IOException;
import java.util.List;

/**
 * Stwórz model: Osoba, Portfel, Pieniadze  V
 * Pieniadze mają kwotę i walutę  V
 * Portfel może zawierać wiele różnych walut  V
 * Osoba płaci używając portfela  V
 * Zaimplementuj sposób płatności jednej osoby do drugiej.  V
 *
 * Person posiada zestaw Item (mogą się powtarzać)  XXX
 * Person może mieć Item, które chce sprzedać albo kupić po określonej cenie  V
 * transakcja kupna-sprzedaży:  V
 * Person, która chce kupić, pyta drugą Person czy sprzeda dany Item  V
 * Person sprzedająca proponuje swoją cenę  V
 * Person kupująca zależnie od oczekiwanej ceny, kupuje albo nie  V
 * kupująca Person płaci sprzedającej  V
 * sprzedająca Person przekazuje Item kupującej  V
 *
 *
 * Person powinny dostosować swoje oferty kupna-sprzedaży po transakcji  V
 * Person sprzedająca potwierdza czy zapłacona kwota zgadza się z jej oczekiwaniami XXXX
 * Person kupująca może spróbować zapłacić mniej niż sprzedająca   XXXX
 * Item nie jest przekazywany jeśli Money się nie zgadzają  V
 * w razie nieudanej transakcji, Person powinny mieć tyle samo Money co wcześniej  V
 * wprowadź Kantor umożliwiający transakcje sprzedaży w USD i kupna w PLN, etc.  V
 *
 * */




public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        Cash smallMoneyPLN = new Cash((double) 543);
        Cash bigMoneyPLN = new Cash((double) 678);
        Cash mediumMoneyPLN =  new Cash((double) 765);
        Cash smallMoneyEURO = new Cash((double) 543,Currency.EURO);
        Cash bigMoneyEURO = new Cash((double) 678,Currency.EURO);
        Cash mediumMoneyEURO =  new Cash((double) 765,Currency.EURO);

        Person adolf = new Person("Adolf","Kowalski");
        adolf.addMoney(mediumMoneyPLN);
        adolf.addMoney(mediumMoneyEURO);
        adolf.addItem("Siekiera");
        adolf.addItemToBuy(new Offer("Wiadro", List.of(smallMoneyEURO)));
        adolf.addItemToBuy(new Offer("Malpa", List.of(bigMoneyPLN)));

        Person jozef = new Person("Jozef","Kowalski");
        jozef.addMoney(bigMoneyPLN);
        jozef.addMoney(mediumMoneyEURO);
        jozef.addItem("Malpa");
        jozef.addItem("Wiadro");
        jozef.addItemToSell(new Offer("Wiadro", List.of(smallMoneyEURO)));
        logger.info(adolf.toString());
        logger.info(jozef.toString());


        System.out.println("Transaction is success: " + adolf.transactionItem(jozef,"Wiadro"));
        logger.info(adolf.toString());
        logger.info(jozef.toString());

        Cantor.getCourseByFile("dataCourse");




    }
}
