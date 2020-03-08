package patterns.behavior.mediator;

public abstract class Customer {
    protected Mediator mediator;
    protected String name;
    protected int price;

    public Customer(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void bid(int price);
    public abstract void cancelBid();

}
