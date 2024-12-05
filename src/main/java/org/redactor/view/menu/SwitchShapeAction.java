package org.redactor.view.menu;

import javax.swing.*;
import org.redactor.controller.Controller;
import org.redactor.model.ShapeEnum;

import java.awt.event.ActionEvent;

public class SwitchShapeAction extends AbstractAction
{
    private final ShapeEnum shapeType;
    private final Controller controller;

    public SwitchShapeAction(String name, ShapeEnum shapeType, Controller controller)
    {
        super(name);
        this.controller = controller;
        this.shapeType = shapeType;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        controller.setShapeType(shapeType);
    }
}
