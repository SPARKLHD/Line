package model;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MyLine extends MyShape
{
    public MyLine(Color color, int strokeWidth)
    {
        super(color, new Line2D.Double(), strokeWidth);
    }

    @Override
    public void setFrame(Point2D[] points)
    {
        if (points.length < 2)
        {
            throw new IllegalArgumentException("Для определения линии необходимы как минимум две точки.");
        }

        ((Line2D) shape).setLine(points[0], points[1]);
    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setColor(color);
        graphics2D.setStroke(new BasicStroke(strokeWidth));
        graphics2D.draw(shape);
    }
}
