package patterns.structural.adapter;

import org.apache.log4j.Logger;

public class Main {
    private  static final Logger LOG = Logger.getLogger("-adapter-");
    public static void main(String[] args) {
        Jeep jeep = new Jeep("jeep",240);
        Volvo volvo = new Volvo("volvo", 170);
        LOG.info( jeep.getName() +"max speed M:"+ jeep.getSpeed());
        LOG.info( volvo.getName() +"max speed K:"+  volvo.getSpeed());
        LOG.info( volvo.getName() +"max speed M:"+  volvo.getSpeedMPH());
    }
}
