package org;

import org.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Scene {
    private final List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public Shape.Hit hit (Ray ray){
        for (Shape shape : shapes){
            Shape.Hit hit = shape.hit(ray);

            if (hit.hit()){
                return hit;
            }
        }
        return new Shape.Hit(false);
    }
}
