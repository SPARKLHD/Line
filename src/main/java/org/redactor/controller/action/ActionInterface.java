package org.redactor.controller.action;

import org.redactor.model.Model;

import java.awt.*;

public interface ActionInterface
{
    void setModel(Model model);
    void mousePressed(org.redactor.model.Point point);
    void mouseDragged(org.redactor.model.Point point);
}
