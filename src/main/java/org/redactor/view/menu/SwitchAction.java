package org.redactor.view.menu;

import org.redactor.controller.Controller;
import org.redactor.model.ActionType;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchAction extends AbstractAction
{
    private final ActionType actionType;
    private final Controller controller;

    public SwitchAction(String name, ActionType actionType, Controller controller)
    {
        super(name);
        this.actionType = actionType;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        controller.setActionType(actionType);
    }
}