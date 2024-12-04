package org.example.controller;

//import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionInterface;
import org.example.controller.state.State;
import org.example.model.Model;
import org.example.model.MyShape;
import org.example.model.undomachine.UndoMachine;
import org.example.view.MyFrame;
import org.example.view.MyPanel;

import java.awt.*;
import java.util.Collection;

public class Controller {
    //RectangularShape shape;
    Model model;
    MyPanel panel;
    MyFrame frame;
    State state;
    UndoMachine undoMachine;

    public Controller() {
        undoMachine = new UndoMachine();
        model = new Model();
        state = new State(model);
        panel = new MyPanel(this);

        //model.addObserver(panel);
        frame = new MyFrame(panel,state,undoMachine);

    }



    public void mousePressed(Point point) {
        state.getAction().mousePressed(point);
        ActionInterface ai = state.getAction().myclone();
        ai.addObserver(panel);
        undoMachine.add(ai);
    }

    public void mouseDragget(Point point) {
        state.getAction().mouseDragget(point);
    }

    public Collection<MyShape> translate() {
        return model.getList();
    }


}
