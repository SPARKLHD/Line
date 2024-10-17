package org.example.model;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Shape {
    RectangularShape shape;

    public Shape() {
        shape = new Rectangle2D.Double();
    }

    public void setFrame(Point2D[] points){
        shape.setFrameFromDiagonal(points[0],points[1]);
    }

    public RectangularShape getShape() {
        return shape;
    }
}
