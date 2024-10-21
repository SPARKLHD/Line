package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
    Shape currentShape;
    Collection<Shape> shapes; //сюда складываем все фигуры


    public Model(){
        shapes = new ArrayList<>();
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }

    public Shape getCurrentShape() {
        return currentShape;
    }

    public Collection<Shape> getList() {
        return shapes;
    }

    public void add(Shape currentShape){
        shapes.add(currentShape);
    }

}
