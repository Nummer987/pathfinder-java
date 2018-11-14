package com.timelab.de;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager implements ActionListener {
    //vars
    private Berechnung berechnung;

    //constructor
    public Manager() {
        berechnung = new Berechnung();
    }

    //methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Window.bReset) { //clicked reset
            Window.clearGrid();
        } else if(e.getSource() == Window.bStart) { //clicked start
            Window.gridAkt(berechnung.aSternHV(Window.feld));
        }
    }
}
