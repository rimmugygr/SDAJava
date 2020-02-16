package patterns.creational.factory;

public class Object2 extends ObjectType{
    private String o2Name;
    private String o2Param1;
    private int o2Param2;

    public Object2(String name, String param1, int param2) {
        this.o2Name = name;
        this.o2Param1 = param1;
        this.o2Param2 = param2;
    }

    @Override
    public String getName() {
        return o2Name;
    }

    @Override
    public String getParam1() {
        return o2Param1;
    }

    @Override
    public int getParam2() {
        return o2Param2;
    }
}