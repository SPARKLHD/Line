package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Collection;

public class ActionMove extends ActionInterface {
    MyShape sampleShape;
    MyShape shape;
    Point2D[] p;
    Model model;

    public void setSampleShape(MyShape sampleShape) {}

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {

    }

    @Override
    public ActionInterface myclone() {
        return null;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    public ActionMove(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public ActionMove() {
        p = new Point2D[2];
    }

    @Override
    public void mousePressed(Point point) {
        findShape(point);
    }

    private void findShape(Point point) {
        Point2D p1 = (Point2D) point;
        p[0] = p1;
        Collection<MyShape> list = model.getList();
        for (MyShape x: list){
            if (x.getShape().contains(p1)) {
                shape = x;
            }
        }
    }

    @Override
    public void mouseDragged(Point point) {
        moveShape(point);
    }

    private void moveShape(Point point) {
        p[1] = (Point2D) point;
        if (shape!=null) {
            double deltaX = p[1].getX() - p[0].getX();
            double deltaY = p[1].getY() - p[0].getY();
            double maxX = shape.getShape().getMaxX() + deltaX;
            double maxY = shape.getShape().getMaxY() + deltaY;
            double minX = shape.getShape().getMinX() + deltaX;
            double minY = shape.getShape().getMinY() + deltaY;
            shape.getShape().setFrameFromDiagonal(maxX, maxY, minX, minY);
            p[0] = p[1];
        }
    }

}
