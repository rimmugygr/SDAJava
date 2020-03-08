package patterns.behavior.mediator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AllegroMediator implements Mediator {
    private ArrayList<Customer> biddingCustomers;

    public AllegroMediator() {
        this.biddingCustomers = new ArrayList<>();
        // connection to allegro
    }

    @Override
    public void addBuyer(Customer customer) {
        if(!biddingCustomers.contains(customer))
            biddingCustomers.add(customer);
    }

    @Override
    public void findHighestBidder() {
        int maxBid=0;
        Customer winner=null;
//        for (Customer c : biddingCustomers) {
//            if( c.price >maxBid){
//                maxBid = c.price;
//                winner = c;
//            }
//        }

        winner = Collections.max(biddingCustomers, Comparator.comparing(c -> c.price));

        System.out.println("Winner is "+winner.name);
    }
}
