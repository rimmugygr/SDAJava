package programing2.Wallet;

import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Cash> cashList;
    
    {
        this.cashList = new ArrayList<>();
    }

    public void addCash(Cash cashToAdd) {
        Cash cashInWallet =  findCash(cashToAdd);
        cashInWallet.addCash(cashToAdd);
    }

    public void removeCash(Cash cashToRemove) {
        Cash cashInWallet =  findCash(cashToRemove);
        cashInWallet.removeCash(cashToRemove);
    }

    private Cash findCash(Cash cashToFind){
        for (int i = 0; i < this.cashList.size(); i++) {
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
        return "Wallet{"+ cashList +'}';
    }
}
