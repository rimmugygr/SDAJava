package programing2.wallet;

import programing2.wallet.exceptions.IncorrectCurrencyException;
import programing2.wallet.exceptions.IncorrectAmountException;
import programing2.wallet.exceptions.NoEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Cash> moneyList;
    
    {
        this.moneyList = new ArrayList<>();
    }

    public Wallet() {
    }

    public Wallet(Cash money) {
        this.moneyList.add(money);
    }

    public Wallet(List<Cash> moneyList) {
        this.moneyList = moneyList;
    }

    public List<Cash> getMoneyList() {
        return moneyList;
    }

    public boolean addCash(Cash cashToAdd) {
        Cash cashInWallet =  findCash(cashToAdd);
        try {
            cashInWallet.addMoney(cashToAdd);
        } catch (IncorrectCurrencyException | IncorrectAmountException e) {
            return false;
        }
        return true;


    }


    public boolean removeCash(Cash cashToRemove) {
        Cash cashInWallet =  findCash(cashToRemove);
        if(cashInWallet.isEnoughAmountAndCurrency(cashToRemove)){

            try {
                cashInWallet.removeMoney(cashToRemove);
            } catch (IncorrectCurrencyException | NoEnoughMoneyException | IncorrectAmountException e) {
                return false;
            }
            return true;
        }

        return false;
    }

    private Cash findCash(Cash cashToFind){
        for (int i = 0; i < moneyList.size(); i++) {
            if (moneyList.get(i).isTheSameCurrency(cashToFind)){
                return moneyList.get(i);
            }
        }
        Cash newCash = new Cash(cashToFind.getCurrency());
        moneyList.add(newCash);
        return newCash;
    }

    @Override
    public String toString() {
        return String.valueOf(moneyList);
    }
}
