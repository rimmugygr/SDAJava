package programing2.Wallet;


import java.math.BigDecimal;

public class Cash {
    private BigDecimal Money;
    private Currency currency;

    public Cash(BigDecimal Money, Currency currency) {
        this.Money = Money;
        this.currency = currency;
    }

    public Cash(Currency currency) {
        this.Money = BigDecimal.ZERO;
        this.currency = currency;
    }

    public void addCash(BigDecimal money) {
        this.Money = this.Money.add(money);
    }

    public void removeCash(BigDecimal money) {
        this.Money = this.Money.add(money.negate());
    }

    public boolean checkCurrency(Currency currency) {
        return currency.equals(this.currency);
    }

    @Override
    public String toString() {
        return "Cash{" +
                "value=" + Money +
                ", currency=" + currency +
                '}';
    }
}
