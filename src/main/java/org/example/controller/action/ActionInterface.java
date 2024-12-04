package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.util.Observable;

//интерфейс действий
public abstract class ActionInterface extends Observable {
    public abstract void mousePressed(Point point);
    public   abstract void mouseDragged(Point point);
    public abstract void setModel(Model m);
    public abstract void setSampleShape(MyShape myShape);
    public abstract void execute();
    public abstract void unexecute();
    public abstract ActionInterface myclone();
}
