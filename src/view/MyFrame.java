package view;

import java.awt.*;
import view.menu.*;
import javax.swing.*;
import model.ActionType;
import model.ShapseEnum;
import model.FillBehavior;
import controller.Controller;

public class MyFrame extends JFrame
{
    private final Controller controller;

    public MyFrame(MyPanel panel, Controller controller)
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

        JMenu shapeMenu = new JMenu("Фигура");
        shapeMenu.add(new SwitchShapeAction("Линия", ShapseEnum.LINE, controller));
        shapeMenu.add(new SwitchShapeAction("Овал", ShapseEnum.ELLIPSE, controller));
        shapeMenu.add(new SwitchShapeAction("Прямоугольник", ShapseEnum.RECTANGLE, controller));
        menuBar.add(shapeMenu);

        JMenu fillMenu = new JMenu("Заливка");
        fillMenu.add(new SwitchFillAction("Закрасить", FillBehavior.FILL, controller));
        fillMenu.add(new SwitchFillAction("Без закраски", FillBehavior.EMPTY, controller));
        menuBar.add(fillMenu);

        JMenu actionMenu = new JMenu("Действие");
        actionMenu.add(new SwitchAction("Двигать", ActionType.MOVE, controller));
        actionMenu.add(new SwitchAction("Рисовать", ActionType.DRAW, controller));
        menuBar.add(actionMenu);

        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem chooseColorItem = new JMenuItem("Изменить цвет");
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

        JMenu strokeWidthMenu = new JMenu("Толщина");
        JSlider strokeWidthSlider = new JSlider(1, 10, 1);
        strokeWidthSlider.setMajorTickSpacing(1);
        strokeWidthSlider.setPaintTicks(true);
        strokeWidthSlider.setPaintLabels(true);

        strokeWidthSlider.addChangeListener(event -> controller.setStrokeWidth(strokeWidthSlider.getValue()));

        JMenuItem strokeWidthItem = new JMenuItem("Изменить толщину");
        strokeWidthItem.addActionListener(event -> JOptionPane.showMessageDialog(this, strokeWidthSlider, "Выберите толщину", JOptionPane.PLAIN_MESSAGE));
        strokeWidthMenu.add(strokeWidthItem);
        menuBar.add(strokeWidthMenu);

        return menuBar;
    }
}