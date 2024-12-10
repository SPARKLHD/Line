package org.example.view.menu;

import org.example.controller.state.State;
import java.awt.Shape;

public class SwitchShape implements Command {
    Shape shape;
    State state;

    public SwitchShape(Shape shape, State state) {
        this.shape = shape;
        this.state = state;
    }

    @Override
    public void execute() {
        state.setShape(shape); // Передаем любую форму в state
    }
}
