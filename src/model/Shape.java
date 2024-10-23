package model;

import java.awt.*;

public abstract class Shape
{
    private Point point1;
    private Point point2;
    private Color color;
    private boolean isFilled;
    private int strokeWidth;

    public Shape(Point point1, Point point2)
    {
        this.point1 = point1;
        this.point2 = point2;
        this.color = Color.RED;
        this.isFilled = false;
        this.strokeWidth = 3;
    }

    public Shape(Point point1, Point point2, Color color)
    {
        this.point1 = point1;
        this.point2 = point2;
        this.color = color;
        this.isFilled = false;
        this.strokeWidth = 3;
    }

    public Point getPoint1()
    {
        return point1;
    }

    public void setPoint1(Point point1)
    {
        this.point1 = point1;
    }

    public Point getPoint2()
    {
        return point2;
    }

    public void setPoint2(Point point2)
    {
        this.point2 = point2;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public int getStrokeWidth()
    {
        return strokeWidth;
    }

    public void setStrokeWidth(int strokeWidth)
    {
        this.strokeWidth = strokeWidth;
    }

    public boolean isFilled()
    {
        return isFilled;
    }

    public void setFilled(boolean filled)
    {
        isFilled = filled;
    }
}
