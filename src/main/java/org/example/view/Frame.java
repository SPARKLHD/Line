package org.example.view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Panel panel;

    public Frame(Panel panel) throws HeadlessException {
        setVisible(true);
        setResizable(false);
        setSize(1000,1000);
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
