package patterns.structural.flyweight;

public class FordMustang {
    private FordMustangBase fordMustangBase;
    private String engineSize;

    public FordMustang(String color, String engineSize) {
        System.out.println(this.getClass() + " constructor");
        this.fordMustangBase = FordMustangBaseFactory.getFordMustangBases(color);
        this.engineSize = engineSize;
    }

    @Override
    public String toString() {
        return "FordMustang{" +
                "fordMustangBase=" + fordMustangBase +
                ", engineSize='" + engineSize + '\'' +
                '}';
    }
}
