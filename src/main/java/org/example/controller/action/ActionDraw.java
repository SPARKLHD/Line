package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class ActionDraw implements ActionInterface{
    MyShape sampleShape;
    MyShape shape;
    Point2D[] p;
    Model model;

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public ActionDraw() {
        p = new Point2D[2];
        sampleShape = new MyShape(new Ellipse2D.Double());
    }

    public ActionDraw(  Model model) {
        shape = new MyShape();
        this.p = new Point2D[2];
        this.model = model;
        sampleShape = new MyShape(new Ellipse2D.Double());
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }
    public void stretchShape(Point point){
        p[1] =(Point2D) point;
        shape.createShape(p);
    }
    public void createShape(Point point){
        p[0] = (Point2D)point;
        shape = sampleShape.clone();
        model.createShape(shape);
    }


    @Override
    public void mousePressed(Point point) {
        createShape(point);
    }

    @Override
    public void mouseDragged(Point point) {
        stretchShape(point);
    }
}
