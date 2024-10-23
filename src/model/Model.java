package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Model
{
    private Shape current;
    private final Collection<Shape> shapes;

    public Model(Shape shape)
    {
        this.current = shape;
        this.shapes = new ArrayList<>();
    }

    public Collection<Shape> getShapes()
    {
        return shapes;
    }

    public Shape getCurrent()
    {
        return current;
    }

    public void createShape(Point point1, Color color, boolean isFilled, int strokeWidth)
    {
        current = new Rectangle(point1, point1);
        current.setColor(color);
        current.setFilled(isFilled);
        current.setStrokeWidth(strokeWidth);
        shapes.add(current);
    }

    public void stretchShape(Point point2)
    {
        current.setPoint2(point2);
    }
}