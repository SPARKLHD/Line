package org.example.controller;

import org.example.model.Model;
import org.example.model.Shape;
import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;
import java.util.Collection;

public class Controller {
    Panel panel;
    Frame frame;
    public Model model;

    public Controller() {
        panel = new Panel(this);
        frame = new Frame(panel);
        model = new Model();
    }

    public void mousePressed(Point point){
        Shape newShape = new Shape();
        newShape.createShape(point);
        model.setCurrentShape(newShape);
    }

    public void mouseDragged(Point point){
        Shape current = model.getCurrentShape();
        current.finishShape(point);
        panel.repaint();
    }

    public void mouseReleased(Point point){
        Shape current = model.getCurrentShape();
        current.finishShape(point);
        model.add(current);
        panel.repaint();
        model.setCurrentShape(null);
    }


    public Collection<Shape> translate(){
        return model.getList();
    }
}
