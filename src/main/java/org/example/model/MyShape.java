package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

//класс фигуры
public class MyShape {
    public Color colorDefault = Color.pink;

    RectangularShape shape; //объект прямоугольника
    Color color; //цвет
    FillBehavior fillBehavior = FillBehavior.NOFILL;

    // конструктор по умолчанию
    public MyShape() {
        shape = new Rectangle2D.Double(); //фигура - прямоугольник
        color = colorDefault;
    }

    public MyShape(RectangularShape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }

    public MyShape(Color blue, Rectangle2D.Double aDouble, FillBehavior fillBehavior) {
        color = Color.BLACK;
        shape = new Rectangle2D.Double();
        this.fillBehavior = fillBehavior;
    }

    public MyShape(RectangularShape shape) {
        this.shape = shape;
        this.color = colorDefault;
    }

    //геттер фигуры
    public RectangularShape getShape() {
        return shape;
    }

    //создание фигуры по точкам
    public void createShape(Point2D[] point) {
        shape.setFrameFromDiagonal(point[0], point[1]);
    }

    // Добавляем рисовку фигуры
    public void draw(Graphics2D g) {
        Paint p= g.getPaint();
        g.setColor(color);
        fillBehavior.draw(g,shape);
        g.setPaint(p);
    }


    //метод клонирования
    public MyShape clone(){
        MyShape s = new MyShape(); //создаем новую фигуру

        //ставим все характеристики прошлой
        s.color = this.color;
        s.shape = (RectangularShape) shape.clone();
        s.fillBehavior = this.fillBehavior;

        //возвращаем готовую копию
        return s;
    }

    public void setShape(RectangularShape shape) {
        this.shape = shape;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setFillBehavior(FillBehavior fillBehavior) {
        this.fillBehavior = fillBehavior;
    }

    public FillBehavior getFillBehavior() {
        return fillBehavior;
    }
}
