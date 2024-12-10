package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ActionDraw extends ActionInterface {
    private MyShape sampleShape;
    private MyShape shape;
    private Point2D[] p;
    private Model model;

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    void deleteShape() {
        ArrayList<MyShape> list = (ArrayList<MyShape>) model.getList();
        shape = list.remove(list.size() - 1);
        setChanged();
        notifyObservers();
    }

    @Override
    public void execute() {
        model.createCurrentShape(shape);
        setChanged();
        notifyObservers();
    }

    @Override
    public void unexecute() {
        deleteShape();
        setChanged();
        notifyObservers();
    }

    @Override
    public ActionInterface myclone() {
        ActionDraw ad = new ActionDraw(model);
        ad.setSampleShape(sampleShape); // Клонируем пример фигуры
        ad.shape = this.shape;          // Текущее состояние фигуры
        ad.p = this.p;
        return ad;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ActionDraw() {
        p = new Point2D[2];
        sampleShape = new MyShape(Color.BLUE, new Ellipse2D.Double());
    }

    public ActionDraw(Model model) {
        this.shape = new MyShape();
        this.p = new Point2D[2];
        this.model = model;
        sampleShape = new MyShape(Color.BLUE, new Ellipse2D.Double());
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    public void stretchShape(Point point) {
        p[1] = (Point2D) point;

        try {
            // Получаем внутреннюю фигуру из MyShape
            Shape innerShape = shape.getShape();

            if (innerShape instanceof Rectangle2D) {
                Rectangle2D rect = (Rectangle2D) innerShape;
                rect.setFrame(p[0].getX(), p[0].getY(), p[1].getX() - p[0].getX(), p[1].getY() - p[0].getY());  // Растягиваем прямоугольник
            } else if (innerShape instanceof Ellipse2D) {
                Ellipse2D ellipse = (Ellipse2D) innerShape;
                double width = p[1].getX() - p[0].getX();
                double height = p[1].getY() - p[0].getY();
                shape.setShape(new Ellipse2D.Double(p[0].getX(), p[0].getY(), width, height));  // Создаем новый эллипс
            } else if (innerShape instanceof Line2D) {
                Line2D line = (Line2D) innerShape;
                line.setLine(p[0], p[1]);  // Растягиваем линию
            } else {
                throw new UnsupportedOperationException("Unsupported shape type for stretching: " + innerShape.getClass());
            }
        } catch (UnsupportedOperationException e) {
            System.err.println("Unsupported shape type for stretching: " + e.getMessage());
        }
    }

    public void createShape(Point point) {
        p[0] = (Point2D) point;
        shape = sampleShape.clone();
        model.createCurrentShape(shape);
    }

    @Override
    public void mousePressed(Point point) {
        createShape(point);
    }

    @Override
    public void mouseDragget(Point point) {
        stretchShape(point);
    }
}
