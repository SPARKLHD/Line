package org.redactor.view;

import org.redactor.controller.Controller;
import org.redactor.controller.action.ActionDraw;
import org.redactor.controller.action.ActionMove;

import java.awt.*;
import org.redactor.view.menu.*;
import javax.swing.*;
import org.redactor.model.ActionType;
import org.redactor.model.ShapeEnum;
import org.redactor.model.FillBehavior;
import org.redactor.controller.Controller;

public class MyFrame extends JFrame
{
    private final Controller controller;

    public MyFrame(Panel panel, Controller controller)
    {
        this.controller = controller;

        setTitle("Redactor");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setJMenuBar(createMenuBar());

        add(panel);
        setVisible(true);
    }
    private JMenuBar createMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();

        // Меню для выбора формы
        JMenu shapeMenu = new JMenu("Фигура");
        shapeMenu.add(new SwitchShapeAction("Линия", ShapeEnum.LINE, controller));
        menuBar.add(shapeMenu);

        // Меню для выбора заливки
        JMenu fillMenu = new JMenu("Заливка");
        fillMenu.add(new SwitchFillAction("Закрасить", FillBehavior.FILL, controller));
        fillMenu.add(new SwitchFillAction("Без закраски", FillBehavior.EMPTY, controller));
        menuBar.add(fillMenu);

        // Меню для выбора действия (Рисовать / Двигать)
        JMenu actionMenu = new JMenu("Действие");
        actionMenu.add(new SwitchAction("Двигать", ActionType.MOVE, controller));
        actionMenu.add(new SwitchAction("Рисовать", ActionType.DRAW, controller));
        menuBar.add(actionMenu);

        // Меню для выбора цвета
        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem chooseColorItem = new JMenuItem("зменить цвет");
        chooseColorItem.addActionListener(event ->
        {
            Color selectedColor = JColorChooser.showDialog(this, "Выберите цвет", Color.RED);

            if (selectedColor != null)
            {
                controller.setCurrentColor(selectedColor);
            }
        });
        colorMenu.add(chooseColorItem);
        menuBar.add(colorMenu);

        // Меню для изменения толщины линии
        JMenu strokeWidthMenu = new JMenu("Толщина");
        JSlider strokeWidthSlider = new JSlider(1, 10, 1);
        strokeWidthSlider.setMajorTickSpacing(1);
        strokeWidthSlider.setPaintTicks(true);
        strokeWidthSlider.setPaintLabels(true);

        strokeWidthSlider.addChangeListener(event -> controller.setStrokeWidth(strokeWidthSlider.getValue()));

        JMenuItem strokeWidthItem = new JMenuItem("зменить толщину");
        strokeWidthItem.addActionListener(event -> JOptionPane.showMessageDialog(this, strokeWidthSlider, "Выберите толщину", JOptionPane.PLAIN_MESSAGE));
        strokeWidthMenu.add(strokeWidthItem);
        menuBar.add(strokeWidthMenu);

        return menuBar;
    }
}
