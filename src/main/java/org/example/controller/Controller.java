package org.example.controller;

import org.example.model.Model;
import org.example.view.Frame;
import org.example.view.Panel;

public class Controller {
    Panel panel;
    Frame frame;
    Model model;

    public Controller() {
        panel = new Panel(this);
        frame = new Frame(panel);
        model = new Model();
    }
}
