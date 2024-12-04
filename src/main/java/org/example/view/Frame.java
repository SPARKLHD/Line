package org.example.view;
import org.example.controller.State;
import org.example.controller.action.ActionDelete;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;
import org.example.model.FillBehavior;
import org.example.model.undomachine.UndoRMachine;
import org.example.view.menu.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Frame extends JFrame {
    Panel panel; //для доступа к панели
    State state;
    UndoRMachine undoRMachine;

    public Frame(Panel panel, State state, UndoRMachine undoRMachine) {
        this.panel = panel;
        this.undoRMachine = undoRMachine;
        this.state = state;
        ArrayList <Action> menuItem = new ArrayList<Action>();
        menuItem.add(new SwitchState("Draw",null, new SwitchAction(state, new ActionDraw())));
        menuItem.add(new SwitchState("Move",null,new SwitchAction(state, new ActionMove())));
        menuItem.add(new SwitchState("Delete",null,new SwitchAction(state, new ActionDelete())));
        menuItem.add(new SwitchState("Rectangle",null,new SwitchShape(state,new Rectangle2D.Double())));
        menuItem.add(new SwitchState("Ellipse",null,new SwitchShape(state, new Ellipse2D.Double())));
        menuItem.add(new SwitchState("ChooseColor",null,new SwitchColor(state)));
        menuItem.add(new SwitchState("Fill",null,new SwitchFill(FillBehavior.FILL,state)));
        menuItem.add(new SwitchState("NoFill",null,new SwitchFill(FillBehavior.NOFILL,state)));
        menuItem.add(new SwitchUndo("undo", null, undoRMachine)); // `SwitchUndo`
        menuItem.add(new SwitchRedo("redo", null, undoRMachine)); // `SwitchRedo`
        undoRMachine.addObserver((SwitchUndo)menuItem.get(menuItem.size()-3));
        undoRMachine.addObserver((SwitchRedo)menuItem.get(menuItem.size()-2));
        undoRMachine.notifyMenu();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        int i=0;
        JMenu menuAction = new JMenu("Action");
        menuBar.add(menuAction);
        for(i=0;i<3;i++)
         menuAction.add(menuItem.get(i));
        JMenu menuShape = new JMenu("Shape");
        menuBar.add(menuShape);
        int j;
        for(j=i;j<i+2;j++)
            menuShape.add(menuItem.get(j));
        i=j;
        JMenu menuColor = new JMenu("Color");
        menuBar.add(menuColor);
        menuColor.add(menuItem.get(i++));
        JToolBar jToolBar = new JToolBar();

        this.add(jToolBar, BorderLayout.NORTH);
        for(Action x:menuItem)
            jToolBar.add(x);



        /////////////////////////////////////////////////
        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(1000,1000); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
