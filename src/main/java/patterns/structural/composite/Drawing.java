package patterns.structural.composite;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class Drawing implements Shape {
    static final Logger LOGGER = Logger.getLogger("Drawing");
    private List<Shape> shapes;

    public void removeShapes(Shape shapes) {
        this.shapes.remove(shapes);
    }

    public void addShapes(Shape shapes) {
        this.shapes.add(shapes);
    }

    public Drawing() {
        this.shapes = new ArrayList<>();
    }

    @Override
    public void draw() {
        LOGGER.info("Drawing:");
        shapes.forEach(Shape::draw);
    }
}
