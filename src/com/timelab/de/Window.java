package com.timelab.de;
import javafx.geometry.Orientation;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class Window extends JFrame {

    public static JButton bReset,bStart,bModus;
    private JSlider jSlider;
    private static JPanel[][] panels;
    private JPanel grid;

    public static int feld[][];
    private int modus = 1; //1 start, 2 ende, 3 hindernis

    public Window() {
        setLayout(null);
        setSize(640,520);
        setTitle("Pathfinder");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addMenu();
        makeNewGrid(100);

        setVisible(true);
    }

    private void makeNewGrid(int p_size) {
        feld = new int[p_size][p_size];
        panels = new JPanel[p_size][p_size];
        addGrid(p_size);
    }

    private void addGrid(int p_size) {
        grid = new JPanel(null);
        grid.setBounds(10,10,500,500);
        addGridPixels(p_size);
        add(grid);
    }

    private void addGridPixels(int p_size) {
        for (int i = 0; i < p_size; i++) {
            for (int j = 0; j < p_size; j++) {
                JPanel jPanel = new JPanel();
                jPanel.setBackground(Color.WHITE);
                jPanel.setBounds(i*(500/p_size),j*(500/p_size),(500/(p_size+1)),(500/(p_size+1)));

                int finalI = i;
                int finalJ = j;
                jPanel.addMouseListener(new MouseInputListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(modus == 1) {
                            removeStart(p_size);
                            e.getComponent().setBackground(Color.GREEN);
                        }
                        else if(modus == 2) {
                            removeEnd(p_size);
                            e.getComponent().setBackground(Color.RED);
                        }
                        else if(modus == 3)
                            e.getComponent().setBackground(Color.BLACK);

                        feld[finalI][finalJ] = modus;
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
                System.out.println(panels);
                grid.add(jPanel);
            }
        }
    }

    private static void removeStart(int p_gridSize) {
        for (int i = 0; i < p_gridSize; i++) {
            for (int j = 0; j < p_gridSize; j++) {
                if(feld[i][j] == 1) {
                    panels[i][j].setBackground(Color.WHITE);
                    feld[i][j] = 0;
                }
            }
        }
    }

    private static void removeEnd(int p_gridSize) {
        for (int i = 0; i < p_gridSize; i++) {
            for (int j = 0; j < p_gridSize; j++) {
                if(feld[i][j] == 2) {
                    panels[i][j].setBackground(Color.WHITE);
                    feld[i][j] = 0;
                }
            }
        }
    }

    public static void gridAkt(int[][] p_feld){
        for (int i = 0; i < p_feld.length; i++) {
            for (int j = 0; j < p_feld.length; j++) {
                feld[i][j] = p_feld[i][j];
                if(p_feld[i][j] == 0)
                    panels[i][j].setBackground(Color.WHITE);
                else if(p_feld[i][j] == 1)
                    panels[i][j].setBackground(Color.GREEN);
                else if(p_feld[i][j] == 2)
                    panels[i][j].setBackground(Color.RED);
                else if(p_feld[i][j] == 3)
                    panels[i][j].setBackground(Color.BLACK);
                else if(p_feld[i][j] == 4)
                    panels[i][j].setBackground(Color.YELLOW);
            }
        }
    }

    public static void clearGrid() {
        for (int i = 0; i < feld.length; i++) {
            for (int j = 0; j < feld.length; j++) {
                feld[i][j] = 0;
                panels[i][j].setBackground(Color.WHITE);
            }
        }
    }

    //also addsa new Manager
    private void addMenu() {
        JPanel menu = new JPanel(null);
        menu.setBounds(520,10,100,200);

        bReset = new JButton("Reset");
        bReset.setBounds(0,0,100,30);
        menu.add(bReset);

        bModus = new JButton("Start setzen");
        bModus.setBounds(0,35,100,30);
        menu.add(bModus);

        bStart = new JButton("Start");
        bStart.setBounds(0,70,100,30);
        menu.add(bStart);

        jSlider = new JSlider(JSlider.HORIZONTAL,4,20,4);
        jSlider.setBounds(0,105,100,30);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                //
            }
        });
        menu.add(jSlider);

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
