package org.example.model;

import java.awt.*;
import java.awt.geom.*;
import java.awt.Shape;

public class MyShape {
    private Color color;
    private Shape shape;
    private FillBehavior fillBehavior;

    public MyShape(Color color, Shape shape) {
        this.color = color;
        this.shape = shape;
        this.fillBehavior = FillBehavior.NOFILL;
    }

    public MyShape() {
        this.color = Color.BLACK;
        this.shape = new Rectangle2D.Double(); // По умолчанию — прямоугольник
        this.fillBehavior = FillBehavior.NOFILL;
    }

    public MyShape(Color color, Shape shape, FillBehavior fillBehavior) {
        this.color = color;
        this.shape = shape;
        this.fillBehavior = fillBehavior;
    }

    public void setFrame(Point2D[] points) {
        if (shape instanceof Rectangle2D) {
            ((Rectangle2D) shape).setFrameFromDiagonal(points[0], points[1]);
        } else if (shape instanceof Line2D) {
            ((Line2D) shape).setLine(points[0], points[1]);
        } else {
            throw new UnsupportedOperationException("Cannot set frame for this shape");
        }
    }

    public void draw(Graphics2D g) {
        Paint paint = g.getPaint();
        g.setColor(color);

        if (shape instanceof Line2D) {
            g.draw(shape); // Рисуем линию
        } else if (shape instanceof RectangularShape) {
            fillBehavior.draw(g, (RectangularShape) shape); // Используем поведение заполнения для RectangularShape
        } else {
            throw new UnsupportedOperationException("Unsupported shape type: " + shape.getClass());
        }

        g.setPaint(paint);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public FillBehavior getFillBehavior() {
        return fillBehavior;
    }

    public void setFillBehavior(FillBehavior fillBehavior) {
        this.fillBehavior = fillBehavior;
    }

    public MyShape clone() {
        MyShape s = new MyShape();
        s.setColor(this.color);
        s.fillBehavior = this.fillBehavior;

        if (this.shape instanceof Rectangle2D) {
            Rectangle2D rect = (Rectangle2D) this.shape;
            s.setShape(new Rectangle2D.Double(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight()));
        } else if (this.shape instanceof Line2D) {
            Line2D line = (Line2D) this.shape;
            s.setShape(new Line2D.Double(line.getP1(), line.getP2()));
        } else if (this.shape instanceof Ellipse2D) {
            Ellipse2D ellipse = (Ellipse2D) this.shape;
            s.setShape(new Ellipse2D.Double(ellipse.getX(), ellipse.getY(), ellipse.getWidth(), ellipse.getHeight()));
        } else {
            throw new UnsupportedOperationException("Cloning not supported for this shape type: " + shape.getClass());
        }

        return s;
    }
}
