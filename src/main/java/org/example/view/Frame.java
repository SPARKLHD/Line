package org.example.view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Panel panel;

    public Frame(Panel panel) throws HeadlessException {
        setResizable(false);
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,1000);
        setVisible(true);
    }
}
