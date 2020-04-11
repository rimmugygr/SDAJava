package programing2.Wallet;


import programing2.Wallet.exceptions.IncorrectCurrencyException;
import programing2.Wallet.exceptions.IncorretAmountExeption;
import programing2.Wallet.exceptions.NoEnoughMoneyException;

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

    public void addCash(Cash cashToAdd) throws IncorrectCurrencyException, IncorretAmountExeption {
        if (isValidatedCash(cashToAdd)) {
            this.amount = this.amount.add(cashToAdd.getAmount());
        }
    }


    public boolean removeCash(Cash cashToRemove) throws IncorrectCurrencyException, NoEnoughMoneyException, IncorretAmountExeption {
        if (isEnoughAmount(cashToRemove) && isValidatedCash(cashToRemove)) {
            this.amount = this.amount.add(cashToRemove.getAmount().negate());
            return true;
        } else {
            throw new NoEnoughMoneyException();
        }
    }

    public boolean isTheSameCurrency(Cash cash) {
        return this.currency.equals(cash.getCurrency());
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean isEnoughAmount(Cash cash){
        return this.amount.compareTo(cash.amount)>=0;
    }

    public boolean isZeroAmount(){
        return this.amount.equals(BigDecimal.ZERO);
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private boolean isValidatedCash(Cash cash) throws IncorrectCurrencyException, IncorretAmountExeption {
        if (cash.getAmount().compareTo(BigDecimal.ZERO)<0) {
            throw new  IncorretAmountExeption();
        }
        if (!isTheSameCurrency(cash)) {
            throw new IncorrectCurrencyException();
        }
        return true;
    }


    @Override
    public String toString() {
        return " "+ amount +
                " " + currency;
    }
}
