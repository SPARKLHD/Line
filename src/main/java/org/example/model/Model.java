package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
    Shape currentShape;
    Collection<Shape> list;


    public Model(){
        list = new ArrayList<>();
    }

    public void setCurrentShape(Shape currentShape){
        this.currentShape = currentShape;
    }
}
