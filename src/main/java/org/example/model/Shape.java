package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

//класс фигуры
public class Shape {
    RectangularShape shape; //объект прямоугольника
    Point2D p; // начальная точка в 2х мерном пространстве

    // конструктор по умолчанию
    public Shape() {
        shape = new Rectangle2D.Double();
    }

    //геттер фигуры
    public RectangularShape getShape() {
        return shape;
    }

    //метод для определения первой точки
    public void createShape(Point point) {
        p = new Point2D.Double(point.x, point.y);
    }

    //метод для определения второй точки
    public void finishShape(Point point) {
        Point2D finishPoint = new Point2D.Double(point.x, point.y);
        shape.setFrameFromDiagonal(p, finishPoint); //устанавливаем размер по диагонали
    }

    // Добавляем рисовку фигуры
    public void draw(Graphics2D g) {
        g.draw(shape);
    }
}
