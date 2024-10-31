package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    Panel panel; //для доступа к панели
    Controller controller;
    public Frame(Panel panel, Controller controller) throws HeadlessException {
        this.controller = controller;
       JMenuBar menuBar = new JMenuBar();
       setJMenuBar(menuBar);
       JMenu menu = new JMenu("shape");
       menuBar.add(menu);
       JMenuItem itemRec = new JMenuItem("rectangle");
       JMenuItem itemEll = new JMenuItem("ellipse");
       menu.add(itemRec);
       menu.add(itemEll);
       itemRec.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               controller.setRectangle();
           }
       });
       itemEll.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               controller.setEllipse();
           }
       });
        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(1000,1000); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
