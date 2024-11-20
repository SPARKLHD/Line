package org.example.view;
import org.example.controller.State;
import org.example.controller.action.ActionDelete;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;
import org.example.view.menu.SwitchAction;
import org.example.view.menu.SwitchShape;
import org.example.view.menu.SwitchState;
import javax.swing.*;
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
        ArrayList <Action> menuItemAction = new ArrayList<Action>();
        menuItemAction.add(new SwitchState("Draw",null, new SwitchAction(state, new ActionDraw())));
        menuItemAction.add(new SwitchState("Move",null,new SwitchAction(state, new ActionMove())));
        menuItemAction.add(new SwitchState("Delete",null,new SwitchAction(state, new ActionDelete())));

        ArrayList <Action> menuItemShape = new ArrayList<Action>();
        menuItemShape.add(new SwitchState("Rectangle",null,new SwitchShape(state,new Rectangle2D.Double())));
        menuItemShape.add(new SwitchState("Ellipse",null,new SwitchShape(state, new Ellipse2D.Double())));


        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuAction = new JMenu("Action");
        menuBar.add(menuAction);
        for (Action s: menuItemAction){menuAction.add(s);}

        JMenu menuShape = new JMenu("Shape");
        menuBar.add(menuShape);
        for (Action s: menuItemShape){menuShape.add(s);}

        JButton deleteAll = new JButton("DeleteAll");
        deleteAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAll();
            }
        });




        /////////////////////////////////////////////////
        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(1000,1000); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
