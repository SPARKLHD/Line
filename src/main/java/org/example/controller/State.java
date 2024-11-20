package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionInterface;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class State {
    RectangularShape shape;
    MyShape myShape;
    ActionInterface actionInterface;
    Model model;

    public State( Model model) {
        myShape = new MyShape(new Rectangle2D.Double(), Color.pink);
        this.actionInterface = new ActionDraw(model);
        this.model = model;
    }

    public void setRectangularShape(RectangularShape shape) {

       // this.shape = shape;
        myShape.setShape(shape);
        actionInterface.setSampleShape(myShape);
    }

    public void setAction(ActionInterface actionInterface) {

        this.actionInterface = actionInterface;
        this.actionInterface.setModel(model);
    }

    public ActionInterface getActionInterface() {
        return actionInterface;
    }
}
