package patterns.structural.composite;

import org.apache.log4j.Logger;

public class Triangle implements Shape {
    Logger LOGGER = Logger.getLogger("Triangle");
    @Override
    public void draw() {
        LOGGER.info("Draw");
    }
}
