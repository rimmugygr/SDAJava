package programing2.Wallet;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<Cash> cash;
    
    {
        this.cash = new ArrayList<>();
    }

    public void addCash(BigDecimal money, Currency currency) {
        boolean isCurrencyInWallet = false;
        for (int i = 0; i < cash.size(); i++) {
            if (cash.get(i).checkCurrency(currency)){
                cash.get(i).addCash(money);
                isCurrencyInWallet = true;
            }
        }
        if (isCurrencyInWallet==false) {
            this.cash.add(new Cash(money,currency));
        }
    }

    public void removeCash(BigDecimal money, Currency currency) {
        boolean isCurrencyInWallet = false;
        for (int i = 0; i < cash.size(); i++) {
            if (cash.get(i).checkCurrency(currency)){
                cash.get(i).removeCash(money);
                isCurrencyInWallet = true;
            }
        }
        if (isCurrencyInWallet==false) {
            this.cash.add(new Cash(money.negate(),currency));
        }
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "cash=" + cash +
                '}';
    }
}
