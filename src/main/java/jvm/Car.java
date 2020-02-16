package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable class
 * */
public final class Car {
    private final String engine;
    private final String driver;
    private final List<String> wheels;  //= new ArrayList<>();//gdy nie fainal

    public Car(String engine, String driver, String wheel1, String wheel2, String wheel3, String wheel4) {
        this.engine = engine;
        this.driver = driver;
        List<String> wheel = new ArrayList<>();
        wheel.add(wheel1);
        wheel.add(wheel2);
        wheel.add(wheel3);
        wheel.add(wheel4);
        this.wheels = wheel;
    }

    public Car(String engine, String driver, List<String> wheels) {
        if(wheels==null||wheels.size()!=4){
            throw new IllegalArgumentException("ma byc 4 kola");
        }
        this.engine = engine;
        this.driver = driver;
        this.wheels = wheels;
    }



    public Car replaceEngine(String newEngine){
        return new Car(newEngine,this.driver,this.wheels);
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }

    public String getEngine() {
        return engine;
    }

    public String getDriver() {
        return driver;
    }

}
