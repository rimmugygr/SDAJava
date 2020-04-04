package programing2.Wallet;

import java.math.BigDecimal;

public class Person {
    private String firstName;
    private String lastName;
    private Wallet wallet;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = new Wallet();
    }

    public void addMoney(double money, Currency currency) {
        this.wallet.addCash(BigDecimal.valueOf(money),currency);
    }

    public void addMoney(double money) {
        this.wallet.addCash(BigDecimal.valueOf(money),Currency.PLN);
    }


    public void removeMoney(double money, Currency currency) {
        this.wallet.removeCash(BigDecimal.valueOf(money),currency);
    }

    public void removeMoney(double money) {
        this.wallet.removeCash(BigDecimal.valueOf(money),Currency.PLN);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
