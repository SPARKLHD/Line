package org.example.view.menu;
import org.example.controller.State;

import java.awt.geom.RectangularShape;

public class SwitchShape implements Command {
    State state;
    RectangularShape shape;

    public SwitchShape(State state, RectangularShape shape) {
        this.state = state;
        this.shape = shape;
    }

    @Override
    public void execute() {
        state.setRectangularShape(shape);
    }

    @Override
    public void unexecute() {

    }
}
