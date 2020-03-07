package patterns.creational.prototype;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShoppingList shoppingListTemplate = new ShoppingList();
        shoppingListTemplate.loadData();
        ShoppingList listaZakupow = (ShoppingList) shoppingListTemplate.clone1();
        List<String> zakupy = listaZakupow.getShoppingList();
        zakupy.add("ser");

        System.out.println("Lista zakupów: ");
        zakupy.forEach(System.out::println);
    }
}
