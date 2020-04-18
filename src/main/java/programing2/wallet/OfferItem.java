package programing2.wallet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfferItem {
    private String name;
    private List<Cash> moneyList;

    public OfferItem(String name, List<Cash> moneyList) {
        this.name = name;
        this.moneyList = moneyList;
    }

    public static Map<String, Cash> getSuccesedOfferOnItem(Set<String> itemsName, Set<OfferItem> itemsToBuy, Set<OfferItem> itemsToSell) {
        Map<String,Cash> resultTransaction = new HashMap<>();

        for (String nameItem : itemsName) {
            // collections with offers each side
            OfferItem offerBuy = itemsToBuy.stream()
                    .filter(x -> x.getName().equals(nameItem))
                    .findFirst().get();
            OfferItem offerSell = itemsToSell.stream()
                    .filter(x -> x.getName().equals(nameItem))
                    .findFirst().get();

            // check is acceptable offer for this item
            Cash result = OfferItem.withCashIsAcceptableOffer(offerBuy,offerSell);
            if (result != null) {
                resultTransaction.put(nameItem,result);
            }
        }
        return resultTransaction;
    }

    private static Cash withCashIsAcceptableOffer(OfferItem offerBuy, OfferItem offerSell) {
        for (Cash cash : offerBuy.getMoneyList()) {
            if (checkIsEnoughCashInList(offerSell, cash)) return cash;
        }
        return null;
    }

    private static boolean checkIsEnoughCashInList(OfferItem offerSell, Cash cash) {
        for (int i = 0; i < offerSell.getMoneyList().size(); i++) {
            Cash tempCash = offerSell.getMoneyList().get(i);
            if(tempCash.isTheSameCurrency(cash) && tempCash.isEnoughAmount((cash))) return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cash> getMoneyList() {
        return moneyList;
    }

    public void setMoneyList(List<Cash> moneyList) {
        this.moneyList = moneyList;
    }


    @Override
    public String toString() {
        return "name: " + name +
                " moneyList=" + moneyList ;
    }
}
