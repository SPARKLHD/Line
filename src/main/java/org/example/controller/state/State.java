package org.example.controller.state;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import org.example.model.Model;
import org.example.controller.action.*;
import org.example.model.FillBehavior;
import org.example.model.MyShape;

public class State {
    Model model;
    MyShape sampleShape;
    ActionInterface action;

    public State(Model model) {
        this.model = model;
        action = new ActionDraw(model);
        sampleShape = new MyShape(Color.BLUE, new Rectangle2D.Double(), FillBehavior.NOFILL);
        action.setSampleShape(sampleShape);
    }

    public State() {
    }

    public void setAction(ActionInterface action) {
        this.action = action;
        action.setModel(model);
    }

    public ActionInterface getAction() {
        return action;
    }

    public MyShape getSampleShape() {
        return sampleShape;
    }

    public void setSampleShape(MyShape sampleShape) {
        this.sampleShape = sampleShape;
        action.setSampleShape(sampleShape);
    }

    // Изменяем метод на работу с любыми Shape
    public void setShape(Shape shape) {
        sampleShape.setShape(shape);
        action.setSampleShape(sampleShape);
    }

    public void setColor(Color c) {
        sampleShape.setColor(c);
        action.setSampleShape(sampleShape);
    }

    public void setFb(FillBehavior fb) {
        sampleShape.setFillBehavior(fb);
        action.setSampleShape(sampleShape);
    }
}
