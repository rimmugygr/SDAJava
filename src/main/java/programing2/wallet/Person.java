package programing2.wallet;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Person {
    private static final Logger logger = LogManager.getLogger(Person.class);

    private String firstName;
    private String lastName;
    private Wallet wallet;

    private Set<String> itemsHave;
    private Set<OfferItem> itemsToBuy;
    private Set<OfferItem> itemsToSell;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wallet = new Wallet();
        this.itemsHave = new HashSet<>();
        this.itemsToBuy = new HashSet<>();
        this.itemsToSell = new HashSet<>();
    }

    public Person(String firstName, String lastName, Wallet wallet) {
        this(firstName,lastName);
        this.wallet = wallet;
    }

    public void addItem(String name){
        logger.info(this.firstName + " add item: " + name);
        this.itemsHave.add(name);
        this.itemsToBuy.remove(new OfferItem(name,null));
    }

    public void addItemToBuy(OfferItem offerItem){
        this.itemsToBuy.add(offerItem);
    }

    public void addItemToSell(OfferItem offerItem){
        if (this.itemsHave.contains(offerItem.getName())) {
            this.itemsToSell.add(offerItem);
        }
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean transactionAllItem(Person sellingPerson) {
        // check is items to trade
        Set<String> itemsName = this.itemsToBuy.stream()
                .map(OfferItem::getName)
                .filter(sellingPerson::isItemToSell)
                .collect(Collectors.toSet());
        // if no items to transaction return false
        if (itemsName.isEmpty()) return false;
        // check offer
        Map<String, Cash> resultTransaction = OfferItem.getSucceedOfferOnItem(itemsName, this.itemsToBuy,  sellingPerson.getItemsToSell());
        // if person have not enough money to give
        return transactionMoneysAndItems(sellingPerson, resultTransaction);
    }

    public boolean transactionItem(Person sellingPerson, String item) {
        if (item==null) return false;
        // check offer
        Map<String, Cash> resultTransaction = OfferItem.getSucceedOfferOnItem(Set.of(item), this.itemsToBuy, sellingPerson.getItemsToSell());
        return transactionMoneysAndItems(sellingPerson, resultTransaction);
    }

    private boolean transactionMoneysAndItems(Person sellingPerson, Map<String, Cash> resultTransaction) {
        // if person have not enough money to give
        if (resultTransaction.isEmpty()) return false;
        // trade accepted money for item
        for (String name : resultTransaction.keySet()) {
            transactionMoneyAndItem(sellingPerson, resultTransaction.get(name), name);
        }
        return true;
    }

    private void transactionMoneyAndItem(Person sellingPerson, Cash cashGiven, String name) {
        // check is enough money in wallet
        if (this.giveCashTo( sellingPerson, cashGiven)) {
            // when not give item then take money back
            if(sellingPerson.removeItem(name)){
                this.addItem(name);
            } else {
                this.removeCashFrom(sellingPerson, cashGiven);
            }
        }
    }

    private boolean removeItem(String name) {
        logger.info(this.firstName + " remove item: " + name);
        boolean result = this.itemsHave.remove(name);
        this.itemsToSell.remove(new OfferItem(name,null));
        return result;
    }

    public boolean isItemToSell(String name){
        return this.itemsToSell.stream().map(OfferItem::getName).anyMatch(name::equals);
    }

    private boolean transactionMoney(Person sourcePerson, Person targetPerson, Cash cashGiven) {
        boolean isRemovedFromSourcePerson = sourcePerson.removeMoney(cashGiven);
        if (isRemovedFromSourcePerson) {
            targetPerson.addMoney(cashGiven);
            logger.info(sourcePerson.getFirstName() + " give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
            return true;
        } else {
            logger.info(sourcePerson.getFirstName() + " not give to " + targetPerson.getFirstName() + " " + cashGiven.toString());
            return false;
        }
    }

    public boolean giveCashTo(Person targetPerson, Cash cashGiven) {
        return this.transactionMoney(this, targetPerson, cashGiven);
    }

    public boolean removeCashFrom(Person sourcePerson, Cash cashGiven) {
        return this.transactionMoney(sourcePerson, this, cashGiven);
    }

    public boolean addMoney(Cash cash) {
        if(this.wallet.addCash(cash)){
            logger.info(this.getFirstName() + " get  " + cash.toString());
            return true;
        } else {
            logger.info(this.getFirstName() + " dont get  " + cash.toString());
            return false;
        }
    }

    public boolean removeMoney(Cash cash) {
        if(this.wallet.removeCash(cash)){
            logger.info(this.getFirstName() + " remove " + cash.toString() + " from wallet");
            return true;
        } else {
            logger.info(this.getFirstName() + " dont have " + cash.toString());
            return false;
        }
    }


    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Set<OfferItem> getItemsToBuy() {
        return itemsToBuy;
    }

    public Set<OfferItem> getItemsToSell() {
        return itemsToSell;
    }

    @Override
    public String toString() {
        return "Person " +
                "firstName " + firstName +
                " wallet " + wallet +
                " itemsHave " + itemsHave +
                " itemsToBuy " + itemsToBuy +
                " itemsToSell " + itemsToSell;
    }


}
