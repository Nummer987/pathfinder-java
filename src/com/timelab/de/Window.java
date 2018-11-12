package com.timelab.de;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

    public static int feld[][];
    public static JButton bReset,bStart;

    public Window() {
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);

        feld = new int[9][9];
    }

    private void addGrid() {
        JPanel grid = new JPanel(new GridLayout(9,9,2,2));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JPanel jPanel = new JPanel();
                jPanel.setBackground(new Color(1f,1f,1f));
                int finalI = i;
                int finalJ = j;
                jPanel.addMouseListener(new MouseInputListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        feld[finalI][finalJ] = 1;
                        e.getComponent().setBackground(new Color(1f,1f,0f,0f));
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }

                    @Override
                    public void mouseDragged(MouseEvent e) {

                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {

                    }
                });

                grid.add(jPanel);
            }
        }
        add(grid);
    }

    //fügt auch einen neuen Manager hinzu
    private void addMenu() {
        JPanel menu = new JPanel(new GridLayout(2,1));
        bReset = new JButton("Reset");
        menu.add(bReset);
        bStart = new JButton("Start");
        menu.add(bStart);
        add(menu);

        Manager manager = new Manager();
        bReset.addActionListener(manager);
        bStart.addActionListener(manager);
    }
}
