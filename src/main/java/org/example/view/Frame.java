package org.example.view;
import org.example.controller.State;
import org.example.controller.action.ActionDelete;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;
import org.example.view.menu.SwitchAction;
import org.example.view.menu.SwitchColor;
import org.example.view.menu.SwitchShape;
import org.example.view.menu.SwitchState;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Frame extends JFrame {
    Panel panel; //для доступа к панели
        State state;

    public Frame(Panel panel, State state) {
        this.panel = panel;
        this.state = state;
        ArrayList <Action> menuItem = new ArrayList<Action>();
        menuItem.add(new SwitchState("Draw",null, new SwitchAction(state, new ActionDraw())));
        menuItem.add(new SwitchState("Move",null,new SwitchAction(state, new ActionMove())));
        menuItem.add(new SwitchState("Delete",null,new SwitchAction(state, new ActionDelete())));
        menuItem.add(new SwitchState("Rectangle",null,new SwitchShape(state,new Rectangle2D.Double())));
        menuItem.add(new SwitchState("Ellipse",null,new SwitchShape(state, new Ellipse2D.Double())));
        menuItem.add(new SwitchState("ChooseColor",null,new SwitchColor(state)));

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
