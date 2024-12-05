package org.redactor.view.menu;

import org.redactor.controller.Controller;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;


public class SwitchColorAction extends AbstractAction
{
    private final Color color;
    private final Controller controller;

    public SwitchColorAction(String name, Color color, Controller controller)
    {
        super(name);
        this.color = color;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        controller.setCurrentColor(color);
    }
}