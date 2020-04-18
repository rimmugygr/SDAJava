package programing2.Wallet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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

    public Person(String firstName, String lastName, Wallet wallet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = wallet;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static boolean transaction(Person sourcePerson, Person targetPerson, Cash cashGiven) {
        boolean isRemovedFromSourcePerson = sourcePerson.removeMoney(cashGiven);
        if (isRemovedFromSourcePerson) {
            targetPerson.addMoney(cashGiven);
            logger.info(sourcePerson.getFirstName() + " give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
            return true;
        } else {
            logger.info(sourcePerson.getFirstName() + " not give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
            return false;
        }
    }

    public void giveCashTo(Person targetPerson, Cash cashGiven) {
        Person.transaction(this, targetPerson, cashGiven);
    }

    public void removeCashFrom(Person sourcePerson, Cash cashGiven) {
        Person.transaction(sourcePerson, this, cashGiven);
    }

    public boolean addMoney(Cash cash) {
        if(this.wallet.addCash(cash)){
            logger.info(this.getFirstName() + " get  " + cash.toString());
            return true;
        } else {
            logger.info(this.getFirstName() + " dont get  " + cash.toString());
            return false;
        }
    }

    public boolean removeMoney(Cash cash) {
        if(this.wallet.removeCash(cash)){
            logger.info(this.getFirstName() + " remove " + cash.toString() + " from wallet");
            return true;
        } else {
            logger.info(this.getFirstName() + " dont have " + cash.toString());
            return false;
        }
    }


    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "Person " + firstName + //" " + lastName +
                " has : " + wallet ;
    }
}
