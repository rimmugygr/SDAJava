package patterns.creational.prototype;

import java.util.List;

public class ShoppingList {
    private List<String> shoppingList;


    public void loadData() {
        shoppingList.add("mleko");
        shoppingList.add("wódka");

    }

    public List<String> getShoppingList() {
        return shoppingList;
    }


    Object clone1(){

        return new Object();
    }
}
