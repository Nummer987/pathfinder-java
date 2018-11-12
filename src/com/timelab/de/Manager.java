package com.timelab.de;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager implements ActionListener {
    //vars

    //constructor
    public Manager() {

    }

    //methods
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Window.bReset) {
            Window.gridAkt(new int[9][9]);
        } else if(e.getSource() == Window.bStart) {
            Berechnung berechnung = new Berechnung();
            Window.gridAkt(berechnung.methode1(Window.feld));
        }
    }
}
