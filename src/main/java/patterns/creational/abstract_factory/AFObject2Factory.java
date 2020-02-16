package patterns.creational.abstract_factory;

public class AFObject2Factory implements AFObjectAbstractFactory {
    private String name;
    private String param1;
    private int param2;

    public AFObject2Factory(String name, String param1, int param2) {
        this.name = name;
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public AFObjectType createObject() {
        return new AFObject2(name,param1,param2);
    }
}
