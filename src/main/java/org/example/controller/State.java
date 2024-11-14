package org.example.controller;

import org.example.controller.action.ActionInterface;

import java.awt.geom.RectangularShape;

public class State {
    RectangularShape shape;
    ActionInterface actionInterface;

    public void setRectangularShape(RectangularShape shape) {
        this.shape = shape;
    }

    public void setAction(ActionInterface actionInterface) {
        this.actionInterface = actionInterface;
    }
}
