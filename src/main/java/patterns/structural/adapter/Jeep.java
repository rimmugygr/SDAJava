package patterns.structural.adapter;

public class Jeep extends AmericanCar {
    String name;

    public Jeep(String name, double speed) {
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
