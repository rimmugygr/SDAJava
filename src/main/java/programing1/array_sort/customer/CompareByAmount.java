package programing1.array_sort.customer;

import java.util.Comparator;
/**
 Klasa Komparatora implementuje interfejs Comparator
 Słuzy do poruwnywania obiektow klasy customer po polu amount rosnaco
 */
public class CompareByAmount implements Comparator<Customer> {

    @Override
    public int compare(Customer customer1, Customer customer2) {
        if(customer2==null)return -1;
        if (customer1==null)return -1;
        if(customer1.getAmount()>customer2.getAmount())return 1;
        else if (customer1.getAmount()<customer2.getAmount())return -1;
        return 0;
    }
}
