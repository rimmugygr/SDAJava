package programing2.Wallet;

import programing2.Wallet.exceptions.IncorrectCurrencyException;
import programing2.Wallet.exceptions.IncorretAmountExeption;
import programing2.Wallet.exceptions.NoEnoughMoneyException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Cash> moneyList;
    
    {
        this.moneyList = new ArrayList<>();
    }

    public void addCash(Cash cashToAdd) throws IncorrectCurrencyException, IncorretAmountExeption {
        Cash cashInWallet =  findCash(cashToAdd);
        cashInWallet.addCash(cashToAdd);
    }


    public Cash removeCash(Cash cashToRemove) throws IncorrectCurrencyException, NoEnoughMoneyException, IncorretAmountExeption {
        Cash cashInWallet =  findCash(cashToRemove);
        if(cashInWallet.isEnoughAmount(cashToRemove)){
            cashInWallet.removeCash(cashToRemove);
            return new Cash(BigDecimal.ZERO,cashToRemove.getCurrency());
        } else {
            return new Cash(cashInWallet.getAmount(),cashInWallet.getCurrency());
        }
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
