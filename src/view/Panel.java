package view;

import java.awt.*;
import model.Point;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import controller.Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;

public class Panel extends JPanel
{
    private final Controller controller;
    private Color currentColor = Color.RED;
    private int strokeWidth = 3;

    public Panel(Controller controller)
    {
        this.controller = controller;

        addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent event)
            {
                Point one = controller.createPoint(event.getPoint());
                controller.createShape(one, currentColor, controller.getCurrentShape().isFilled());
            }
        });

        addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                Point two = controller.createPoint(event.getPoint());
                controller.stretchShape(two);
                repaint();
            }
        });
    }

    public void setCurrentColor(Color color)
    {
        this.currentColor = color;
    }

    public void setStrokeWidth(int width)
    {
        this.strokeWidth = width;
        repaint();
    }

    public void setFilled(boolean filled)
    {
        controller.getCurrentShape().setFilled(filled);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setStroke(new BasicStroke(strokeWidth));

        List<java.awt.Shape> shapes = new ArrayList<>(controller.translate());
        List<model.Shape> modelShapes = new ArrayList<>(controller.getModel().getShapes());

        for (int i = 0; i < shapes.size(); i++)
        {
            java.awt.Shape shape = shapes.get(i);
            model.Shape modelShape = modelShapes.get(i);

            graphics2D.setColor(modelShape.getColor());

            if (modelShape.isFilled())
            {
                graphics2D.fill(shape);
            }
            else
            {
                graphics2D.draw(shape);
            }
        }
    }
}