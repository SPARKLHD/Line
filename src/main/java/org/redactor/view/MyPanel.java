package org.redactor.view;

import java.awt.*;
import javax.swing.*;
import org.redactor.model.MyShape;
import java.util.Collection;



public class MyPanel extends JPanel
{
    Contro


    public MyPanel(ModuleLayer.Controller controller)
    {
        this.controller = controller;
        controller.setupMouseListeners(this);
    }

    public MyPanel(ModuleLayer.Controller controller) {

    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        Collection<MyShape> shapes = controller.getShape();

        for (MyShape shape : shapes)
        {
            shape.draw(graphics2D);
        }
    }
}