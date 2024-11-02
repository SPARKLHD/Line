package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;

public interface ActionInterface {
    void mousePressed(Point point);
    void mouseDragged(Point point);
    void setSampleShape(MyShape myShape);

    void setModel(Model model);
}
