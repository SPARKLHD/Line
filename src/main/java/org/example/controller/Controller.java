package org.example.controller;

import org.example.model.Model;
import org.example.model.Shape;
import org.example.view.Frame;
import org.example.view.Panel;
import java.awt.*;
import java.util.Collection;

public class Controller {
    //поля для доступа к панели, рамке, модели
    Panel panel;
    Frame frame;
    public Model model;


    //конструктор по умолчанию
    public Controller() {
        panel = new Panel(this);
        frame = new Frame(panel);
        model = new Model();
    }

    //обработка действий мыши: нажатие кнопки
    public void mousePressed(Point point){
        Shape newShape = new Shape(); //создаем новый объект фигуры
        newShape.createShape(point); // ставим начальную точку в месте нажатия мыши
        model.setCurrentShape(newShape); //в модели ставим текущим эту фигуру
    }

    //обработка действий мыши: перемещение
    public void mouseDragged(Point point){
        Shape current = model.getCurrentShape(); //получаем текущую фигуру
        current.finishShape(point); //на каждое изменение положения зажатой мыши обновляем вторую точку
        panel.repaint(); // и перерисовываем в панели
    }

    //обработка действий мыши: отпускание кнопки
    public void mouseReleased(Point point){
        Shape current = model.getCurrentShape(); //получаем текущую фигуру
        //TODO нужно ли заключительное обновление????
        // current.finishShape(point); //устанавливаем последнюю точку
        model.add(current); // добавляем фигуру в коллекцию модели
        panel.repaint(); //перерисовываем снова
        model.setCurrentShape(null); // фигура закончена, больше изменять её нельзя, ставим нулевой указатель
    }


    //достаем коллекцию фигур из модели
    public Collection<Shape> translate(){
        return model.getList();
    }
}
