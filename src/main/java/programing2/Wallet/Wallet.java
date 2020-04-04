package programing2.Wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Cash> moneyList;
    private List<Cash> creditList;
    
    {
        this.moneyList = new ArrayList<>();
        this.creditList = new ArrayList<>();
    }

    public void addCash(Cash cashToAdd) {
        Cash cashInMoney =  findMoney(cashToAdd);
        if (cashInMoney.isZeroAmount() && !findCredit(cashToAdd).isZeroAmount()) {
            Cash cashInCredit = findCredit(cashToAdd);
            if (cashInCredit.isEnougtAmount(cashToAdd)){
                cashInCredit.removeCash(cashToAdd);
            } else {
                cashInMoney.addCash(cashToAdd);
                cashInMoney.removeCash(cashInCredit);
                cashInCredit.setAmountToZero();
            }
        } else {
            cashInMoney.addCash(cashToAdd);
        }
    }

    public void removeCash(Cash cashToRemove) {
        Cash cashInMoney =  findMoney(cashToRemove);
        if(cashInMoney.isEnougtAmount(cashToRemove)){
            cashInMoney.removeCash(cashToRemove);
        } else {
            Cash cashInCredit = findCredit(cashToRemove);
            cashInCredit.addCash(cashToRemove);
            cashInCredit.removeCash(cashInMoney);
            cashInMoney.setAmountToZero();
        }
    }

    private Cash findMoney(Cash cashToFind){
        return findCash(cashToFind, this.moneyList);
    }

    private Cash findCredit(Cash cashToFind){
        return findCash(cashToFind, this.creditList);
    }

    private Cash findCash(Cash cashToFind, List<Cash> cashList){
        for (int i = 0; i < cashList.size(); i++) {
            if (cashList.get(i).checkCurrency(cashToFind)){
                return cashList.get(i);
            }
        }
        Cash newCash = new Cash(cashToFind.getCurrency());
        cashList.add(newCash);
        return newCash;
    }

    @Override
    public String toString() {
        return "\nMoney : "+ moneyList +"\nCredit : "+ creditList;
    }
}
