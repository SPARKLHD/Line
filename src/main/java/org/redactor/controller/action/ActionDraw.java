package org.redactor.controller.action;


import org.redactor.model.Model;
import org.redactor.model.MyShape;
import org.redactor.model.ShapeFactory;

import java.awt.*;

public class ActionDraw implements ActionInterface {
    private Model model;
    private MyShape shape;

    public ActionDraw(Model model) {
        this.model = model;
    }


    @Override
    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void mousePressed(org.redactor.model.Point point) {

        shape = ShapeFactory.createShape(model.getCurrentShapeType(),point, point, model.getCurrentColor());
        shape.setFillBehavior(model.getFillBehavior());
        shape.setStrokeWidth(model.getStrokeWidth());
        model.addShape(shape);
    }

    @Override
    public void mouseDragged(org.redactor.model.Point point) {
        shape.setPoint2(point);
        model.updateShape(shape);
    }
}
