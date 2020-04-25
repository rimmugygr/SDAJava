package programing2.wallet;

import java.util.*;

public class Offer {
    private String name;
    private List<Cash> moneyList;

    public Offer(String name, List<Cash> moneyList) {
        this.name = name;
        this.moneyList = moneyList;
    }

    // return cash for item in favor for selling OfferItem first match by currency of buying OfferItem
    public static Map<String, Cash> getSucceedOfferOnItem(Set<String> items, Set<Offer> itemsToBuy, Set<Offer> itemsToSell) {
        Map<String,Cash> resultTransaction = new HashMap<>();
        if (items == null) return Map.of();
        for (String item : items) {
            // collections with offers each side
            Offer offerBuy = getOfferFromListByName(itemsToBuy, item);
            Offer offerSell = getOfferFromListByName(itemsToSell, item);
            // if item is not in OfferItem
            if (offerBuy==null||offerSell==null) continue;
            // check is acceptable offer for this item
            Cash result = Offer.withCashIsAcceptableOffer(offerBuy,offerSell);
            if (result != null) {
                resultTransaction.put(item,result);
            }
        }
        return resultTransaction;
    }

    private static Offer getOfferFromListByName(Collection<Offer> itemsToBuy, String item) {
        return itemsToBuy.stream()
                .filter(x -> x.getName().equals(item))
                .findFirst().orElse(null);
    }

    private static Cash withCashIsAcceptableOffer(Offer offerBuy, Offer offerSell) {
        return offerBuy.getMoneyList().stream()
                .filter(cash -> checkIsEnoughCashInList(offerSell, cash))
                .findFirst()
                .orElse(null);
    }

    private static boolean checkIsEnoughCashInList(Offer offer, Cash cash) {
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
        Offer offer = (Offer) o;
        return Objects.equals(name, offer.name);
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
