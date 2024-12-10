package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Collection;

public class ActionMove extends ActionInterface {
    MyShape shape;
    MyShape shapeNew;
    MyShape shapeOld;
    Point2D[] p;
    Model model;

    public ActionMove(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public ActionMove() {
        p = new Point2D[2];
    }

    public void setModel(Model model) {
        this.model = model;
    }

    void findShape(Point point) {
        Point2D p1 = (Point2D) point;
        p[0] = p1;
        Collection<MyShape> list = model.getList();
        for (MyShape x : list) {
            if (x.getShape().contains(p1)) shape = x;
        }
        shapeOld = shape.clone();
        shapeNew = shape;
    }

    @Override
    public void mousePressed(Point point) {
        findShape(point);
    }

    public void moveShape(Point point) {
        p[1] = point;
        if (shape != null) {
            double deltaX = p[1].getX() - p[0].getX();
            double deltaY = p[1].getY() - p[0].getY();

            Shape currentShape = shape.getShape();

            if (currentShape instanceof Rectangle2D) {
                Rectangle2D rect = (Rectangle2D) currentShape;
                double maxX = rect.getMaxX() + deltaX;
                double maxY = rect.getMaxY() + deltaY;
                double minX = rect.getMinX() + deltaX;
                double minY = rect.getMinY() + deltaY;
                rect.setFrameFromDiagonal(minX, minY, maxX, maxY);
            } else if (currentShape instanceof Line2D) {
                Line2D line = (Line2D) currentShape;
                Point2D p1 = line.getP1();
                Point2D p2 = line.getP2();
                line.setLine(
                        p1.getX() + deltaX, p1.getY() + deltaY,
                        p2.getX() + deltaX, p2.getY() + deltaY
                );
                shape.setShape(line);  // Обновляем линию
            } else {
                throw new UnsupportedOperationException("Unsupported shape type: " + currentShape.getClass());
            }

            p[0] = p[1];  // Обновляем исходную точку
        }
    }

    @Override
    public void mouseDragget(Point point) {
        moveShape(point);
    }

    @Override
    public void setSampleShape(MyShape myShape) {
        // Здесь можно оставить или реализовать поведение для образца
    }

    void changeShape(MyShape shape, MyShape shape1) {
        ArrayList<MyShape> list = (ArrayList<MyShape>) model.getList();
        int index = list.indexOf(shape);
        list.remove(index);
        list.add(index, shape1);
        setChanged();
        notifyObservers();
    }

    @Override
    public void execute() {
        changeShape(shapeOld, shapeNew);
    }

    @Override
    public void unexecute() {
        changeShape(shapeNew, shapeOld);
    }

    @Override
    public ActionInterface myclone() {
        ActionMove ad = new ActionMove(model);
        ad.shape = this.shape;
        ad.shapeNew = this.shapeNew;
        ad.shapeOld = this.shapeOld;
        ad.p = this.p;
        return ad;
    }
}
