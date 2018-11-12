package com.timelab.de;

public class Main {


    public static void main(String[] args) {
        int[][] meinArray = new int[9][9];
        for(int i=0; i<meinArray.length;i++){
            for(int j = 0; j<meinArray.length;j++){
                meinArray[i][j] = 0;
            }
        }
        meinArray[1][1] = 1;
        meinArray[8][6] = 2;
        meinArray[5][3] = 3;
        new Window();
        Berechnung berechnung = new Berechnung();
        berechnung.arrayAusgeben(meinArray);
        berechnung.methode1(meinArray);
        berechnung.arrayAusgeben(meinArray);
    }
}
