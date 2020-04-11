package programing2.Wallet;


import programing2.Wallet.exceptions.IncorrectCurrencyException;
import programing2.Wallet.exceptions.IncorrectAmountException;
import programing2.Wallet.exceptions.NoEnoughMoneyException;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Class represent money
 * Has field with amount and currency
 */
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

    public Currency getCurrency() {
        return currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Add value of amount from object in param
     * @param cashToAdd
     * @throws IncorrectCurrencyException when param have different filed currency
     * @throws IncorrectAmountException when param have negative value of field amount
     */
    public void addMoney(Cash cashToAdd) throws IncorrectCurrencyException, IncorrectAmountException {
        if (isValidatedCash(cashToAdd)) {
            this.amount = this.amount.add(cashToAdd.getAmount());
        }
    }

    /**
     * Remove value of amount this object, value is get from object in param
     * @param cashToRemove
     * @throws IncorrectCurrencyException when param have different filed currency
     * @throws IncorrectAmountException when param have negative value of field amount
     * @throws NoEnoughMoneyException when param have higher value of field amount
     */
    public boolean removeMoney(Cash cashToRemove) throws IncorrectCurrencyException, NoEnoughMoneyException, IncorrectAmountException {
        if (isEnoughAmount(cashToRemove) && isValidatedCash(cashToRemove)) {
            this.amount = this.amount.add(cashToRemove.getAmount().negate());
            return true;
        } else {
            throw new NoEnoughMoneyException();
        }
    }

    /**
     * Check is the same currency
     * @param cash
     * @return true if is the same currency other false
     */
    public boolean isTheSameCurrency(Cash cash) {
        return this.currency.equals(cash.getCurrency());
    }

    /**
     * Check is enough value amount to remove,  value is get from object in param
     * @param cash
     * @return true if value amount is bigger than value amount of param or the same other false
     */
    public boolean isEnoughAmount(Cash cash){
        return this.amount.compareTo(cash.amount)>=0;
    }

    /**
     * @return true if vale of amount is zero other false
     */
    public boolean isZeroAmount(){
        return this.amount.equals(BigDecimal.ZERO);
    }

    private boolean isValidatedCash(Cash cash) throws IncorrectCurrencyException, IncorrectAmountException {
        if (cash.getAmount().compareTo(BigDecimal.ZERO)<0) {
            throw new IncorrectAmountException();
        }
        if (!isTheSameCurrency(cash)) {
            throw new IncorrectCurrencyException();
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cash cash = (Cash) o;
        return Objects.equals(amount, cash.amount) &&
                currency == cash.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return " "+ amount +
                " " + currency;
    }
}
