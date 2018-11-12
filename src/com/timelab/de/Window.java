package com.timelab.de;
import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

    public static int feld[][];
    public static JButton bReset,bStart,bModus;
    private static JPanel[][] panels;
    private int modus = 1; //1 start, 2 ende, 3 hindernis

    public Window() {
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);

        feld = new int[9][9];
        panels = new JPanel[9][9];

        addGrid();
        addMenu();
    }

    private void addGrid() {
        JPanel grid = new JPanel(new GridLayout(9,9,2,2));
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JPanel jPanel = new JPanel();
                jPanel.setBackground(Color.WHITE);
                int finalI = i;
                int finalJ = j;
                jPanel.addMouseListener(new MouseInputListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        feld[finalI][finalJ] = modus;
                        if(modus == 1)
                            e.getComponent().setBackground(Color.GREEN);
                        else if(modus == 2)
                            e.getComponent().setBackground(Color.RED);
                        else if(modus == 3)
                            e.getComponent().setBackground(Color.BLACK);
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

                panels[i][j] = jPanel;
                grid.add(jPanel);
            }
        }
        add(grid);
    }

    public static void gridAkt(int[][] p_feld){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(p_feld[i][j] == 0)
                    panels[i][j].setBackground(Color.WHITE);
                else if(p_feld[i][j] == 1)
                    panels[i][j].setBackground(Color.GREEN);
                else if(p_feld[i][j] == 2)
                    panels[i][j].setBackground(Color.RED);
                else if(p_feld[i][j] == 3)
                    panels[i][j].setBackground(Color.BLACK);
            }
        }
    }

    //fügt auch einen neuen Manager hinzu
    private void addMenu() {
        JPanel menu = new JPanel(new GridLayout(3,1));
        bReset = new JButton("Reset");
        menu.add(bReset);
        bModus = new JButton("Start setzen");
        menu.add(bModus);
        bStart = new JButton("Start");
        menu.add(bStart);
        add(menu);

        Manager manager = new Manager();
        bReset.addActionListener(manager);
        bStart.addActionListener(manager);
        bModus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bModus.getText().equals("Start setzen")) {
                    modus = 2;
                    bModus.setText("Ende setzen");
                }
                else if(bModus.getText().equals("Ende setzen")) {
                    modus = 3;
                    bModus.setText("Hindernis setzen");
                }
                else {
                    modus = 1;
                    bModus.setText("Start setzen");
                }
            }
        });
    }
}
