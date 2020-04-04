package programing2.Wallet;


import java.math.BigDecimal;

public class Cash {
    private BigDecimal amount;
    private Currency currency;

    public Cash(Double amount, Currency currency) {
        this.amount = new BigDecimal(amount);
        this.currency = currency;
    }

    public Cash(Double amount) {
        this.amount = new BigDecimal(amount);
        this.currency = Currency.PLN;
    }

    public Cash(BigDecimal amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Cash(Currency currency) {
        this.amount = BigDecimal.ZERO;
        this.currency = currency;
    }


    public void addCash(Cash cashToAdd) {
        this.amount = this.amount.add(cashToAdd.amount);
    }

    public void removeCash(Cash cashToAdd) {
        this.amount = this.amount.add(cashToAdd.amount.negate());
    }

    public boolean checkCurrency(Cash cash) {
        return this.currency.equals(cash.currency);
    }

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Cash{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
