package com.timelab.de;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private JPanel[][] pixelFeld;
    private JButton bReset,bStart;
    private int pixelSize = 30;

    public Window() {
        setLayout(null);
        setVisible(true);
        setSize(400,400);

        pixelFeld = new JPanel[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JPanel jPanel = new JPanel();
                jPanel.setBackground(new Color(1f,1f,1f));
                jPanel.setSize(pixelSize,pixelSize);
                jPanel.setLocation(10+i*(pixelSize+2),10+j*(pixelSize+2));

                pixelFeld[i][j] = jPanel;
                add(pixelFeld[i][j]);
            }
        }

        bReset = new JButton("Reset");
        add(bReset);
        bStart = new JButton("Start");
        add(bStart);

        bReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
