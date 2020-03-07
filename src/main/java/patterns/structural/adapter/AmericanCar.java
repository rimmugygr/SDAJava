package patterns.structural.adapter;

public abstract class AmericanCar implements AmericanMovable {
    double speed;
    public double getSpeedKMH(){
        return  speed*SeepConverter.MILES_TO_KILOMETRS.getConverter();
    }
}
