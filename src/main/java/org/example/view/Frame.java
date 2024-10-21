package org.example.view;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    Panel panel; //для доступа к панели

    public Frame(Panel panel) throws HeadlessException {
        setVisible(true); //видимость
        setResizable(false); //запрет изменения размера окна
        setSize(1000,1000); //размер окна
        add(panel); //добавление панели
        setDefaultCloseOperation(EXIT_ON_CLOSE); //кнопка закрытия
    }
}
