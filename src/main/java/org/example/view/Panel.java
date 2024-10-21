package org.example.view;

import org.example.controller.Controller;
import org.example.model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collection;

public class Panel extends JPanel {

    private final Controller controller; //для доступа к контроллеру

    //передаем контроллер в конструктор
    public Panel(Controller controller) {
        this.controller = controller;  //ссылка на контроллер

        //слушатели мыши
        addMouseListener(new MouseAdapter() {
            @Override
            //на нажатие
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                controller.mousePressed(e.getPoint()); //управление через контроллер
            }

            //на отпускание кнопки
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                controller.mouseReleased(e.getPoint()); //управление через контроллер
            }
        });

        //слушатель движения мыши
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                controller.mouseDragged(e.getPoint()); //управление через контроллер
                repaint(); // обновлние панели при каждом перемещении мыши
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Рисуем все фигуры из модели
        Collection<Shape> shapes = controller.translate();
        for (Shape shape : shapes) {
            shape.draw(g2); // Отрисовка каждой фигуры
        }

        // Отрисовка текущей фигуры, если она есть
        Shape currentShape = controller.model.getCurrentShape();
        if (currentShape != null) {
            currentShape.draw(g2);
        }
    }
}
