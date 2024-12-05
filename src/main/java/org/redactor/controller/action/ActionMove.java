package org.redactor.controller.action;

import org.redactor.model.Model;
import org.redactor.model.Point;
import org.redactor.model.MyShape;

public class ActionMove implements ActionInterface
{
    private Model model;
    private Point start;
    private MyShape selected;

    public ActionMove(Model model)
    {
        this.model = model;
    }

    @Override
    public void setModel(Model model)
    {
        this.model = model;
    }

    @Override
    public void mousePressed(Point point)
    {
        selected = model.findShape(point);
        start = point;
    }

    @Override
    public void mouseDragged(Point point)
    {
        if (selected != null)
        {
            double deltaX = point.getX() - start.getX();
            double deltaY = point.getY() - start.getY();
            selected.move(deltaX, deltaY);
            start = point;
            model.updateShape(selected);
        }
    }
}