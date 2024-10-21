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

    public void createShape(Point point1, Color color, boolean isFilled)
    {
        current = new Rectangle(point1, point1, color);
        current.setFilled(isFilled);
        shapes.add(current);
    }

    public void stretchShape(Point point2)
    {
        current.setPoint2(point2);
    }
}