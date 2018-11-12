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
        setLayout(null);
        setSize(630,520);
        setTitle("Pathfinder");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        feld = new int[9][9];
        panels = new JPanel[9][9];

        addGrid();
        addMenu();

        setVisible(true);
    }

    private void addGrid() {
        JPanel grid = new JPanel(null);
        grid.setBounds(10,10,500,500);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                JPanel jPanel = new JPanel();
                jPanel.setBackground(Color.WHITE);
                jPanel.setBounds(i*(500/9),j*(500/9),(500/10),(500/10));

                int finalI = i;
                int finalJ = j;
                jPanel.addMouseListener(new MouseInputListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(modus == 1) {
                            removeStart();
                            e.getComponent().setBackground(Color.GREEN);
                        }
                        else if(modus == 2) {
                            removeEnd();
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
                grid.add(jPanel);
            }
        }
        add(grid);
    }

    private static void removeStart() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(feld[i][j] == 1) {
                    panels[i][j].setBackground(Color.WHITE);
                    feld[i][j] = 0;
                }
            }
        }
    }

    private static void removeEnd() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(feld[i][j] == 2) {
                    panels[i][j].setBackground(Color.WHITE);
                    feld[i][j] = 0;
                }
            }
        }
    }

    public static void gridAkt(int[][] p_feld){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
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

    //fügt auch einen neuen Manager hinzu
    private void addMenu() {
        JPanel menu = new JPanel(null);
        menu.setBounds(510,10,100,200);
        bReset = new JButton("Reset");
        bReset.setBounds(0,0,100,30);
        menu.add(bReset);
        bModus = new JButton("Start setzen");
        bModus.setBounds(0,35,100,30);
        menu.add(bModus);
        bStart = new JButton("Start");
        bStart.setBounds(0,70,100,30);
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
