package patterns.behavior.mediator;

public class Test {
    public static void main(String[] args) {
        Mediator mediator = new AllegroMediator();
        Customer customer1 = new AllegroCustomer(mediator,"aaa");
        Customer customer2 = new AllegroCustomer(mediator,"bbb");
        Customer customer3 = new AllegroCustomer(mediator,"ccc");

        mediator.addBuyer(customer1);
        mediator.addBuyer(customer2);
        mediator.addBuyer(customer3);

        customer1.bid(1000);
        customer2.bid(2);
        customer3.bid(1000_000);

        mediator.findHighestBidder();

        customer3.cancelBid();

        mediator.findHighestBidder();
    }
}
