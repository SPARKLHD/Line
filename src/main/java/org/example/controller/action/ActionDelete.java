package org.example.controller.action;

import org.example.controller.Controller;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Iterator;

public class ActionDelete implements ActionInterface{
    Controller controller;
    MyShape sampleShape;
    MyShape shape;
    Point2D[] p;
    Model model;



    private void findAndDeleteShape(Point point) {
        p = new Point2D[2];
        Point2D p1 = point;
        p[0] = p1;
        Collection<MyShape> list = model.getList();

        // спользуем итератор для безопасного удаления
        Iterator<MyShape> iterator = list.iterator();
        while (iterator.hasNext()) {
            MyShape x = iterator.next();
            if (x.getShape().contains(p1)) {
                iterator.remove(); // Безопасно удаляем элемент
            }
        }
    }

    @Override
    public void mousePressed(Point point) {
        findAndDeleteShape(point);
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void setSampleShape(MyShape myShape) {
        this.sampleShape = myShape;
    }

    @Override
    public void mouseDragged(Point point) {
        findAndDeleteShape(point);
    }
}
