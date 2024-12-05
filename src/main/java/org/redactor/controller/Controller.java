import org.redactor.controller.State;
import org.redactor.controller.action.ActionDraw;
import org.redactor.controller.action.ActionInterface;
import org.redactor.controller.action.ActionMove;
import org.redactor.model.ActionType;
import org.redactor.model.FillBehavior;
import org.redactor.model.Model;
import org.redactor.model.ShapeEnum;
import org.redactor.view.MyFrame;
import org.redactor.view.MyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Controller
{
    private final Model model;
    private static Controller instance;
    private final State currentState;
    private ActionInterface currentAction;

    public Controller()
    {
        model = new Model();
        MyPanel panel = new MyPanel(this);
        MyFrame myFrame = new MyFrame(panel,this);
        currentState = new State();
        currentAction = new ActionDraw(model);
        currentState.actionInterface = currentAction;

    }

    public static Controller getInstance()
    {
        if (instance == null)
        {
            instance = new Controller();
        }

        return instance;
    }

    public void setupMouseListeners(JPanel panel)
    {
        panel.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent event)
            {
                currentState.myShape = model.findShape(createPoint(event.getPoint()));
                currentAction.mousePressed(createPoint(event.getPoint()));
                panel.repaint();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent event)
            {
                currentAction.mouseDragged(createPoint(event.getPoint()));
                panel.repaint();
            }
        });
    }

    public void setFillBehavior(FillBehavior fillBehavior)
    {
        model.setFillBehavior(fillBehavior);
    }

    public void setCurrentColor(Color color)
    {
        model.setCurrentColor(color);
    }

    public void setStrokeWidth(int width)
    {
        model.setStrokeWidth(width);
    }

    public void setActionType(ActionType actionType)
    {
        switch (actionType)
        {
            case DRAW ->
            {
                currentAction = new ActionDraw(model);
                currentState.actionInterface = currentAction;
            }
            case MOVE ->
            {
                currentAction = new ActionMove(model);
                currentState.actionInterface = currentAction;
            }
        }
    }

    public void setShapeType(ShapeEnum shapeType)
    {
        model.setCurrentShapeType(shapeType);
    }

    public model.Point createPoint(java.awt.geom.Point2D point2D)
    {
        return new model.Point(point2D.getX(), point2D.getY());
    }

    public Collection<MyShape> getShapes()
    {
        return model.getShapes();
    }
}
