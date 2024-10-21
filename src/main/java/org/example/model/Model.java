package org.example.model;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.Collection;

public class Model {
    Shape currentShape; //текущая фигура
    Collection<Shape> shapes; //сюда складываем все фигуры

    //конструктор по умолчанию
    public Model(){
        shapes = new ArrayList<>();
    }

    //для установки текущей фигура
    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }

    //получаем текущую фигуру
    public Shape getCurrentShape() {
        return currentShape;
    }

    //для получения коллекции фигур
    public Collection<Shape> getList() {
        return shapes;
    }

    //добавление в коллекцию
    public void add(Shape currentShape){
        shapes.add(currentShape);
    }

}
