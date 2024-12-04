package org.example.view.menu;

import org.example.model.undomachine.UndoRMachine;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class SwitchRedo extends AbstractAction implements Observer {

    public SwitchRedo(String name, Icon icon, UndoRMachine machine) {
        super(name, icon);
        putValue("machine", machine);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        UndoRMachine m = (UndoRMachine)getValue("machine");
        if (this.isEnabled()) m.execute();
    }

    @Override
    public void update(Observable o, Object arg) {
        UndoRMachine.UndoRedoButtonState buttonState = (UndoRMachine.UndoRedoButtonState) arg;
        this.setEnabled(buttonState.redo);
    }

}
