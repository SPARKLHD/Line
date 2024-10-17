package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
    RectangularShape currentShape;
    Collection<RectangularShape> shapes;

    public Model(RectangularShape currentShape, Collection<RectangularShape> shapes) {
        this.currentShape = currentShape;
        this.shapes = new ArrayList<>();
    }

    public Collection<RectangularShape> getShapes() {
        return shapes;
    }

    public void startShape(Point first){
        currentShape = new Rectangle(first);
        shapes.add(currentShape);
    }

    public void stopShape(Point second){
        currentShape.
    }
}
