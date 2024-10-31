package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;

public class Controller {

    //поля для доступа к панели, рамке, модели
    Panel panel;
    Frame frame;
    public Model model;
    ActionDraw actionDraw;


    //конструктор по умолчанию
    public Controller() {
        model = Model.getInstance(); // синглтон для того, чтоб модель точно была единственна
        panel = new Panel(this);
        frame = new Frame(panel);
        model.setCurrentShape(new MyShape()); // ставим сразу фигуру в текущую
        actionDraw = new ActionDraw(model);
        actionDraw.setSampleShape(new MyShape(new Rectangle2D.Double(), Color.cyan));

    }

    //обработка действий мыши: нажатие кнопки
    public void mousePressed(Point point){
         actionDraw.createShape(point);//создаем фигуру в модели

    }

    //обработка действий мыши: перемещение
    public void mouseDragged(Point point){
        actionDraw.stretchShape(point);
    }

    //достаем коллекцию фигур из модели
    public Collection<MyShape> translate(){
        return model.getList();
    }
}
