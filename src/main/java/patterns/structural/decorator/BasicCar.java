package patterns.structural.decorator;


import org.apache.log4j.Logger;

public class BasicCar implements Car {
    protected final Logger LOG = Logger.getLogger("BasicCar");
    @Override
    public void assamble() {
        LOG.info("BasicCar");
    }
}
