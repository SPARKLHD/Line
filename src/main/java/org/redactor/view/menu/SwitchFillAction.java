package org.redactor.view.menu;

import org.redactor.controller.Controller;
import org.redactor.model.FillBehavior;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchFillAction extends AbstractAction
{
    private final Controller controller;
    private final FillBehavior fillBehavior;

    public SwitchFillAction(String name, FillBehavior fillBehavior, Controller controller)
    {
        super(name);
        this.controller = controller;
        this.fillBehavior = fillBehavior;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        controller.setFillBehavior(fillBehavior);
    }
}
