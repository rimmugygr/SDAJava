package programing2.wallet;

import java.util.*;

public class OfferItem {
    private String name;
    private List<Cash> moneyList;

    public OfferItem(String name, List<Cash> moneyList) {
        this.name = name;
        this.moneyList = moneyList;
    }

    // return cash for item in favor for selling OfferItem first match by currency of buying OfferItem
    public static Map<String, Cash> getSucceedOfferOnItem(Set<String> items, Set<OfferItem> itemsToBuy, Set<OfferItem> itemsToSell) {
        Map<String,Cash> resultTransaction = new HashMap<>();
        if (items == null) return Map.of();
        for (String item : items) {
            // collections with offers each side
            OfferItem offerBuy = getOfferFromListByName(itemsToBuy, item);
            OfferItem offerSell = getOfferFromListByName(itemsToSell, item);
            // if item is not in OfferItem
            if (offerBuy==null||offerSell==null) continue;
            // check is acceptable offer for this item
            Cash result = OfferItem.withCashIsAcceptableOffer(offerBuy,offerSell);
            if (result != null) {
                resultTransaction.put(item,result);
            }
        }
        return resultTransaction;
    }

    private static OfferItem getOfferFromListByName(Collection<OfferItem> itemsToBuy, String item) {
        return itemsToBuy.stream()
                .filter(x -> x.getName().equals(item))
                .findFirst().orElse(null);
    }

    private static Cash withCashIsAcceptableOffer(OfferItem offerBuy, OfferItem offerSell) {
        return offerBuy.getMoneyList().stream()
                .filter(cash -> checkIsEnoughCashInList(offerSell, cash))
                .findFirst()
                .orElse(null);
    }

    private static boolean checkIsEnoughCashInList(OfferItem offer, Cash cash) {
        return offer.getMoneyList()
                .stream()
                .anyMatch(cash::isEnoughAmountAndCurrency);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferItem offerItem = (OfferItem) o;
        return Objects.equals(name, offerItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return " " + name +
                " for " + moneyList + ' ';
    }
}
