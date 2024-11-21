package org.example.controller.action;

import org.example.model.Model;
import org.example.model.MyShape;

import java.awt.*;

//интерфейс действий
public interface ActionInterface {

    //нажатие
    void mousePressed(Point point);
    //удерживание
    void mouseDragged(Point point);

    //установить фигуру
    void setSampleShape(MyShape myShape);

    //установить модель
    void setModel(Model model);
}
