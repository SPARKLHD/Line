package view;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame
{
    public Frame(Panel panel)
    {
        setTitle("Redactor");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JButton colorButton = new JButton("Сменить цвет");
        colorButton.addActionListener(_ ->
        {
            Color newColor = JColorChooser.showDialog(null, "Выберите цвет", Color.BLUE);

            if (newColor != null)
            {
                panel.setCurrentColor(newColor);
            }
        });

        JSpinner strokeWidthSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 10, 1));
        strokeWidthSpinner.addChangeListener(_ -> panel.setStrokeWidth((int) strokeWidthSpinner.getValue()));

        JCheckBox fillCheckBox = new JCheckBox("Заливка");
        fillCheckBox.addActionListener(_ -> panel.setFilled(fillCheckBox.isSelected()));

        controlPanel.add(colorButton);
        controlPanel.add(new JLabel("Толщина линии:"));
        controlPanel.add(strokeWidthSpinner);
        controlPanel.add(fillCheckBox);

        add(controlPanel, BorderLayout.NORTH);
        add(panel);

        setVisible(true);
    }
}
