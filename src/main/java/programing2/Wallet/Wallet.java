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
        for (Cash c : cash) {
            
        }
        
        this.cash.add(new Cash(money,currency));
        
        
    }
}
