package patterns.creational.abstract_factory;

public class AFObject1 extends AFObjectType {
    private String name;
    private String param1;
    private int param2;

    public AFObject1(String name, String param1, int param2) {
        this.name = name;
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getParam1() {
        return param1;
    }

    @Override
    public int getParam2() {
        return param2;
    }
}
