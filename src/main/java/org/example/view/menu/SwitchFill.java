package org.example.view.menu;

import org.example.controller.State;
import org.example.model.FillBehavior;

public class SwitchFill implements Command{
    State state;
    FillBehavior fb;

    public SwitchFill(FillBehavior fb,State state) {
        this.state = state;
        this.fb = fb;
    }

    @Override
    public void execute() {
        state.setFb(fb);
    }

    @Override
    public void unexecute() {

    }
}
