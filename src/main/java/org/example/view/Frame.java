package org.example.view;

import org.example.controller.Controller;
import org.example.controller.State;
import org.example.controller.action.ActionDelete;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;
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
//    Controller controller; //доступ к контроллеру для кнопок
        State state;

    public Frame(Panel panel, State state) {
        this.panel = panel;
        this.state = state;
        ArrayList <Action> menuItem = new ArrayList<Action>();
        menuItem.add(new SwitchState("Rectangle",null,new SwitchShape(state,new Rectangle2D.Double())));
        menuItem.add(new SwitchState("Ellipse",null,new SwitchShape(state, new Ellipse2D.Double())));
        JMenu menu = new JMenu("shape");
        menu.add(menuItem.get(0));
        menu.add(menuItem.get(1));
        JMenuBar menuBar = new JMenuBar(); //верхняя полоса для меню
        setJMenuBar(menuBar); //установка созданного меню
        menuBar.add(menu);


        /////////////////////////////////////////////////
        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(1000,1000); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
