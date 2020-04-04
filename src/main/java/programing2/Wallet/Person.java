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

    public static void transaction(Person sourcePerson, Person targetPerson, Cash cashGiven){
        logger.info(sourcePerson.getFirstName() + " give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
        sourcePerson.wallet.removeCash(cashGiven);
        targetPerson.wallet.addCash(cashGiven);
    }

    public void giveCashTo(Person targetPerson, Cash cashGiven) {
        logger.info(this.getFirstName() + " give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
        this.wallet.removeCash(cashGiven);
        targetPerson.wallet.addCash(cashGiven);
    }

    public void removeCashFrom(Person sourcePerson, Cash cashGiven) {
        logger.info(sourcePerson.getFirstName() + " give to " + this.getFirstName() + " " + cashGiven.toString());
        sourcePerson.wallet.removeCash(cashGiven);
        this.wallet.addCash(cashGiven);
    }

    public void addMoney(Cash cash) {
        logger.info(this.getFirstName() + " get  " + cash.toString());
        this.wallet.addCash(cash);
    }

    public void removeMoney(Cash cash){
        this.wallet.removeCash(cash);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person " + firstName + " " + lastName +
                " has : " + wallet ;
    }
}
