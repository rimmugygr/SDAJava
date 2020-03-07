package patterns.structural.flyweight;

public class FordMustangBase {
    private String color;

    public FordMustangBase(String color) {
        System.out.println(FordMustang.class + " construct of " + color);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "FordMustangBase{" +
                "color='" + color + '\'' +
                '}';
    }
}
