package org.example.view.menu;

import org.example.controller.State;

import javax.swing.*;
import java.awt.*;

public class SwitchColor implements Command{
    State state;
    Color c;

    public SwitchColor(State state) {
        this.state = state;
    }



    @Override
    public void execute() {
        c = JColorChooser.showDialog(null,"Choose color", Color.black);
        state.setColor(c);
    }
}
