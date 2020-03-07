package patterns.structural.adapter;

public abstract class EuropeanCar implements EuropeanMovable {
    double speed;
    public double getSpeedMPH(){
        return  speed*SeepConverter.KILOMETRES_TO_MILES.getConverter();
    }
}
