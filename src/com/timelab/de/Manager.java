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
         //TODO
        } else if(e.getSource() == Window.bStart) {
            //TODO

            Berechnung berechnung = new Berechnung();
            berechnung.arrayAusgeben(Window.feld);
            Window.gridAkt(berechnung.methode1(Window.feld));
        }
    }
}
