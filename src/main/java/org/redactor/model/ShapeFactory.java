package org.redactor.model;

import java.awt.*;

public class ShapeFactory
{
    public static MyShape createShape(ShapeEnum shapeType, Point point1, Point point2, Color color)
    {
        MyShape shape = switch (shapeType)
        {
            case LINE -> new MyLine(color, 1);
        };

        shape.setPoint1(point1);
        shape.setPoint2(point2);

        return shape;
    }
}