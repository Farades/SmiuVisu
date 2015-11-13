package ru.entel.smiu.visu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton button;
    private JPanel rootPanel;

    public MainForm() {
        super("СМИУ ENTEL");
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(MainForm.this, "You clicked");
            }
        });

        setVisible(true);
    }
}
