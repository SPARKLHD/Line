package controller;

import java.awt.*;
import view.Frame;
import view.Panel;
import model.Model;
import model.Point;
import model.Rectangle;
import java.util.Collection;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.stream.Collectors;

public class Controller
{
    private final Model model;

    public Controller()
    {
        model = new Model(new Rectangle(Point.ZERO, Point.ZERO));
        Panel panel = new Panel(this);
        new Frame(panel);
    }

    public Point createPoint(Point2D point2D)
    {
        return new Point(point2D.getX(), point2D.getY());
    }

    public void createShape(Point point, Color color, boolean isFilled)
    {
        model.createShape(point, color, isFilled);
    }

    public void stretchShape(Point point)
    {
        model.stretchShape(point);
    }

    public Collection<Shape> translate()
    {
        return model.getShapes().stream().map(shape->
        {
            Rectangle2D.Double rect = new Rectangle2D.Double();
            rect.setFrameFromDiagonal(shape.getPoint1().x(), shape.getPoint1().y(), shape.getPoint2().x(), shape.getPoint2().y());
            return rect;
        }).collect(Collectors.toList());
    }

    public Rectangle getCurrentShape()
    {
        return (Rectangle) model.getCurrent();
    }

    public Model getModel()
    {
        return model;
    }
}