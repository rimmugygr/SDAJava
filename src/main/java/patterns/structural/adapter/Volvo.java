package patterns.structural.adapter;

public class Volvo extends EuropeanCar {
    String name;

    public Volvo(String name, double speed) {
        this.speed = speed;
        this.name = name;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }
}
