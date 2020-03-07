package patterns.structural.composite;

import org.apache.log4j.Logger;

public class Circle implements Shape {
    static final Logger LOGGER = Logger.getLogger("Circle");
    @Override
    public void draw() {
        LOGGER.info("Draw");

    }
}
