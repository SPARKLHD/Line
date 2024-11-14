package org.example.controller;

import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionInterface;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;

public class Controller {

    //поля для доступа к панели, рамке, модели
    Panel panel;
    Frame frame;
    public Model model;

    State state;
    //конструктор по умолчанию
    public Controller() {

        model = Model.getInstance(); // синглтон для того, чтоб модель точно была единственна
        state =new State(model);
        panel = new Panel(this);
        frame = new Frame(panel, state);
        model.setCurrentShape(new MyShape()); // ставим сразу фигуру в текущую


    }



    //обработка действий мыши: нажатие кнопки
    public void mousePressed(Point point){
         state.getActionInterface().mousePressed(point);
    }

    //обработка действий мыши: перемещение
    public void mouseDragged(Point point){
        state.getActionInterface().mouseDragged(point);
    }

    //достаем коллекцию фигур из модели
    public Collection<MyShape> translate(){
        return model.getList();
    }

//    public void setRectangle() {
//        actionInterface.setSampleShape(new MyShape(new Rectangle2D.Double(),model.getCurrentShape().getColor()));
//    }
//
//    public void setEllipse() {
//        actionInterface.setSampleShape(new MyShape(new Ellipse2D.Double(), model.getCurrentShape().getColor()));
//    }

    public void deleteAll() {
        model.deleteAll();
        panel.repaint();
    }
}
