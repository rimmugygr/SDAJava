package patterns.structural.decorator;

import org.apache.log4j.Logger;

public class SportPackage extends CarDecorator{
    protected Logger LOG = Logger.getLogger("Sport package");
    boolean sportSeats;
    boolean sportWheeel;

    public SportPackage(Car car, boolean sportSeats) {
        super(car);
        this.sportSeats = sportSeats;
        this.sportWheeel=false;
    }

    public void addSportWheeel(){
        this.sportWheeel = true;
        LOG.info("add sport wheeel");
    }

    @Override
    public void assamble() {
        super.assamble();
        LOG.info("add sport gift");
    }
}
