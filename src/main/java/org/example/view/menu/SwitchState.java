package org.example.view.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwitchState extends AbstractAction {

    public SwitchState(String name, Icon icon, Command command) {
        super(name, icon);
        putValue("command",command);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Command com=(Command) getValue("command");
        com.execute();
    }
}
