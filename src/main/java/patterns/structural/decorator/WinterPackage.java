package patterns.structural.decorator;

import org.apache.log4j.Logger;

public class WinterPackage extends CarDecorator {
    protected Logger LOG = Logger.getLogger("WinterPackage");
    boolean seatsHeated;

    public WinterPackage(Car car, boolean seatsHeated) {
        super(car);
        this.seatsHeated = seatsHeated;
    }

    @Override
    public void assamble() {
        super.assamble();
        LOG.info("add winter package");
    }
}
