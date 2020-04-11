package programing2.Wallet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import programing2.Wallet.exceptions.IncorrectCurrencyException;
import programing2.Wallet.exceptions.IncorrectAmountException;
import programing2.Wallet.exceptions.NoEnoughMoneyException;

public class Person {
    private static final Logger logger = LogManager.getLogger(Person.class);

    private String firstName;
    private String lastName;
    private Wallet wallet;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = new Wallet();
    }

    public static void transaction(Person sourcePerson, Person targetPerson, Cash cashGiven) throws IncorrectCurrencyException, NoEnoughMoneyException, IncorrectAmountException {
        logger.info(sourcePerson.getFirstName() + " give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
        sourcePerson.wallet.removeCash(cashGiven);
        targetPerson.wallet.addCash(cashGiven);
    }

    public void giveCashTo(Person targetPerson, Cash cashGiven) throws IncorrectCurrencyException, NoEnoughMoneyException, IncorrectAmountException {
        logger.info(this.getFirstName() + " give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
        this.wallet.removeCash(cashGiven);
        targetPerson.wallet.addCash(cashGiven);
    }

    public void removeCashFrom(Person sourcePerson, Cash cashGiven) {

        sourcePerson.removeMoney(cashGiven);
        this.addMoney(cashGiven);
        logger.info(sourcePerson.getFirstName() + " give to " + this.getFirstName() + " " + cashGiven.toString());

    }

    public void addMoney(Cash cash) {
        try {
            this.wallet.addCash(cash);
        } catch (IncorrectCurrencyException | IncorrectAmountException e) {
            e.printStackTrace();
        } finally {
            logger.info(this.getFirstName() + " get  " + cash.toString());
        }
    }

    public boolean removeMoney(Cash cash) {
        try {
            System.out.println(this.wallet.toString()+"1aaaaa");
            this.wallet.removeCash(cash);
            System.out.println(this.wallet.toString()+"2aaaaa");
        } catch (IncorrectCurrencyException | IncorrectAmountException e) {
            e.printStackTrace();
            return false;
        } catch (NoEnoughMoneyException e) {
            logger.info(this.getFirstName() + " dont have " + cash.toString());
            e.printStackTrace();
            return false;
        } finally {
            logger.info(this.getFirstName() + " remove  " + cash.toString());
            return  true;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person " + firstName + //" " + lastName +
                " has : " + wallet ;
    }
}
