package org.example.view;

import org.example.controller.Controller;
import org.example.controller.action.ActionDelete;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class Frame extends JFrame {
    Panel panel; //для доступа к панели
    Controller controller; //доступ к контроллеру для кнопок

    public Frame(Panel panel, Controller controller) throws HeadlessException {
        this.controller = controller;

        JMenuBar menuBar = new JMenuBar(); //верхняя полоса для меню
        setJMenuBar(menuBar); //установка созданного меню

        //создаем кнопку для смены фигуры в меню
        JMenu menu = new JMenu("shape");
        menuBar.add(menu); //добавляем в полосу

///////////////////////////////

        //выпадающий список из кнопки
        JMenuItem itemRec = new JMenuItem("rectangle");
        JMenuItem itemEll = new JMenuItem("ellipse");
        menu.add(itemRec);
        menu.add(itemEll);

        //слушатели для кнопок
        itemRec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.setActionInterface(new ActionDraw());
                controller.setRectangle();
           }
        });
        itemEll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               controller.setActionInterface(new ActionDraw());
               controller.setEllipse();
           }
        });

//////////////////////////////////////////

        //создаем кнопку для смены действия СОЗДАТЬ/ПЕРЕТАЩИТЬ/УДАЛИТЬ
        JMenu menu1 = new JMenu("action");
        menuBar.add(menu1);

        //создаем выпадающие кнопки из action
        JMenuItem actionDraw = new JMenuItem("draw");
        JMenuItem actionMove = new JMenuItem("move");
        JMenuItem actionDelete = new JMenuItem("delete");
        menu1.add(actionDraw);
        menu1.add(actionMove);
        menu1.add(actionDelete);

        //слушатели для кнопок
        actionMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionMove());
            }
        });
        actionDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionDraw());
            }
        });

        actionDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionDelete());
            }
        });




///////////////////////////////////

        JMenuItem deleteAll = new JMenuItem("Delete all");
        menuBar.add(deleteAll);
        deleteAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deleteAll();
            }
        });


        //настройки окна
        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(1000,1000); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
