package org.example.view.menu;
import org.example.controller.State;
import org.example.controller.action.ActionInterface;

public class SwitchAction implements Command{
    State state;
    ActionInterface actionInterface;

    public SwitchAction(State state, ActionInterface actionInterface) {
        this.state = state;
        this.actionInterface = actionInterface;
    }

    @Override
    public void execute() {
        state.setAction(actionInterface);
    }

    @Override
    public void unexecute() {

    }
}
