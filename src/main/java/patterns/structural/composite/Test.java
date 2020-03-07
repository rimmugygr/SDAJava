package patterns.structural.composite;

import org.apache.log4j.Logger;

public class Test {
    static final Logger LOGGER = Logger.getLogger("Test");
    public static void main(String[] args) {
        Shape circle= new Circle();
        circle.draw();
        Shape triangle= new Triangle();
        triangle.draw();
        Drawing drawing= new Drawing();
        drawing.addShapes(circle);
        drawing.addShapes(triangle);
        drawing.draw();
    }
}
