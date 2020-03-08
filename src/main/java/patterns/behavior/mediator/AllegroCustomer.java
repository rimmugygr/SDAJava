package patterns.behavior.mediator;

public class AllegroCustomer extends Customer {
    public AllegroCustomer(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void bid(int price) {
        this.price = price;
    }

    @Override
    public void cancelBid() {
        this.price = -1;
    }
}
