package patterns.creational.singleton;

public class BillPughSingleton {
    private BillPughSingleton(){
        System.out.println("Constructor BP");
    }
    private static class SingletonCreator{
        private static final BillPughSingleton INSTANCE=new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        System.out.println("Get SingletoCreator");
        return SingletonCreator.INSTANCE;
    }
}
