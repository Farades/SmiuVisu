package ru.entel.smiu.visu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton button;
    private JPanel rootPanel;
    private JButton normalButton;
    private JTabbedPane tabbedPane1;
    private JPanel tab1;
    private JPanel tab2;

    private GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

    public MainForm() {
        super("СМИУ ENTEL");
        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(MainForm.this);
            }
        });

        normalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(null);
            }
        });

        pack();
        setVisible(true);
    }
}
