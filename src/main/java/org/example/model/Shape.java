package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Shape {
    RectangularShape shape;
    Point2D p;

    public Shape() {
        shape = new Rectangle2D.Double();
    }

    public RectangularShape getShape() {
        return shape;
    }

    public void createShape(Point point) {
        p = new Point2D.Double(point.x, point.y);
    }

    public void finishShape(Point point) {
        Point2D finishPoint = new Point2D.Double(point.x, point.y);
        shape.setFrameFromDiagonal(p, finishPoint);
    }

    // Добавляем реальную отрисовку формы
    public void draw(Graphics2D g) {
        g.draw(shape);  // Отрисовка контура фигуры
    }
}
