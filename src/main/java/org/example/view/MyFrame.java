package org.example.view;

import org.example.Controller;
import org.example.controller.action.ActionDraw;
import org.example.controller.action.ActionMove;
import org.example.view.MyPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyFrame extends JFrame {
    MyPanel panel;
    Controller controller;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public MyFrame(MyPanel panel) {
        /////////////////////////////// menu /////////////////////
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        JMenu action = new JMenu("Action");
        JMenuItem draw = new JMenuItem("Draw");
        JMenuItem move = new JMenuItem("Move");
        action.add(draw);
        action.add(move);
        menuBar.add(action);
        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionDraw());
            }
        });
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setActionInterface(new ActionMove());
            }
        });

        this.panel = panel;
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
}
