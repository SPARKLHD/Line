package org.example.controller;

import org.example.controller.action.ActionInterface;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.undomachine.UndoRMachine;

import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;

import java.util.Collection;
public class Controller {

    //поля для доступа к панели, рамке, модели
    Model model;
    Panel panel;
    Frame frame;
    State state;
    UndoRMachine undoRMachine;
    //конструктор по умолчанию
    public Controller() {
        undoRMachine = new UndoRMachine();
        model = new Model();
        state = new State(model);
        panel = new Panel(this);

        //model.addObserver(panel);
        frame = new Frame(panel,state, undoRMachine);

    }



    //обработка действий мыши: нажатие кнопки
    public void mousePressed(Point point){
         state.getActionInterface().mousePressed(point);
        ActionInterface ai = state.getAction().myclone();
            undoRMachine.add(ai);
    }

    //обработка действий мыши: перемещение
    public void mouseDragged(Point point){
        state.getActionInterface().mouseDragged(point);
    }

    //достаем коллекцию фигур из модели
    public Collection<MyShape> translate(){
        return model.getList();
    }


    public void deleteAll() {
        model.deleteAll();
        panel.repaint();
    }
}
