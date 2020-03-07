package patterns.structural.decorator;

import org.apache.log4j.Logger;

public class Main {
    private static final Logger LOG = Logger.getLogger("main");

    public static void main(String[] args) {
        Car basicCar= new BasicCar();
        basicCar.assamble();
        LOG.info("===========");
        Car sportCar = new SportPackage(new BasicCar(),true);
        sportCar.assamble();
        LOG.info("===========");
        Car winterCar= new WinterPackage(new BasicCar(),true);
        winterCar.assamble();
        LOG.info("===========");
        Car sportWinterCar = new SportPackage( new WinterPackage(new BasicCar(), true),true);
        sportWinterCar.assamble();
    }
}
