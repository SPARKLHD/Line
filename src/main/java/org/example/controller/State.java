package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionInterface;
import org.example.model.FillBehavior;
import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class State {
    MyShape myShape;
    ActionInterface actionInterface;
    Model model;

    public State( Model model) {
        myShape = new MyShape(Color.BLUE, new Rectangle2D.Double(), FillBehavior.NOFILL );
        this.actionInterface = new ActionDraw(model);
        this.model = model;
        actionInterface.setSampleShape(myShape);
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

    public void setColor(Color c) {
        myShape.setColor(c);
        actionInterface.setSampleShape(myShape);
    }

    public void setFb(FillBehavior fb) {
        myShape.setFillBehavior(fb);
        actionInterface.setSampleShape(myShape);
    }

    public ActionInterface getAction() {
        return actionInterface;
    }
}
