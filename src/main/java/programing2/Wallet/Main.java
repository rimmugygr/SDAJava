package programing2.Wallet;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import programing2.Wallet.exceptions.IncorrectCurrencyException;
import programing2.Wallet.exceptions.IncorrectAmountException;
import programing2.Wallet.exceptions.NoEnoughMoneyException;

/**
 * Stwórz model: Osoba, Portfel, Pieniadze
 * Pieniadze mają kwotę i walutę
 * Portfel może zawierać wiele różnych walut
 * Osoba płaci używając portfela
 * Zaimplementuj sposób płatności jednej osoby do drugiej.
 *
 * Osoba może zaciągać pożyczki oraz je spłacać
 *  - zakładamy że pozyczkę posiada tylko przy braku pieniędzy w portfelu
 * */




public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IncorrectCurrencyException, IncorrectAmountException, NoEnoughMoneyException {
        Cash smallMoneyPLN = new Cash((double) 543);
        Cash bigMoneyPLN = new Cash((double) 678);
        Cash mediumMoneyPLN =  new Cash((double) 765);
        Cash smallMoneyEURO = new Cash((double) 543,Currency.EURO);
        Cash bigMoneyEURO = new Cash((double) 678,Currency.EURO);
        Cash mediumMoneyEURO =  new Cash((double) 765,Currency.EURO);

        Person adolf = new Person("Adolf","Kowalski");
        adolf.addMoney(mediumMoneyPLN);
        adolf.addMoney(smallMoneyEURO);
        logger.info(adolf.toString());
        logger.info(adolf.removeMoney(mediumMoneyPLN));
        logger.info(adolf.toString());
        logger.info(adolf.removeMoney(mediumMoneyPLN));
        logger.info(adolf.toString());


//        Person jozef = new Person("Jozef","Kowalski");
//        jozef.addMoney(bigMoneyPLN);
//        jozef.addMoney(mediumMoneyEURO);
//
//        logger.info(adolf.toString());
//        logger.info(jozef.toString());
//
//        //transaction
//        Person.transaction(jozef,adolf,smallMoneyPLN);
//        logger.info(adolf.toString());
//        logger.info(jozef.toString());
//
//        adolf.giveCashTo(jozef, mediumMoneyEURO);
//        logger.info(adolf.toString());
//        logger.info(jozef.toString());
//
//        jozef.giveCashTo(adolf, mediumMoneyPLN);
//        logger.info(adolf.toString());
//        logger.info(jozef.toString());
//
//        jozef.addMoney(smallMoneyPLN);
//        logger.info(jozef.toString());
//
//        jozef.addMoney(smallMoneyPLN);
//        logger.info(jozef.toString());

    }
}
