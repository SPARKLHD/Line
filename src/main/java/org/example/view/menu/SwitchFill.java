package org.example.view.menu;

import org.example.controller.State;

public class SwitchFill implements Command{
    State state;

    public SwitchFill(State state) {
        this.state = state;
    }

    @Override
    public void execute() {

    }

    @Override
    public void unexecute() {

    }


}
