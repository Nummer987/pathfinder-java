package com.timelab.de;

public class Berechnung {

    private boolean testeAufHindernis(int[][] p_array, int p_x, int p_y){
        if(p_array[p_x][p_y] != 3) {
            return true;
        }
        else{
            return false;
        }
    }

    public int[][] arrayAusgeben(int[][] p_array){
        return p_array;
    }

    public int[][] methode1(int[][] p_array){
        //Vars
        int startX = 0;
        int startY = 0;
        int endeX = 0;
        int endeY = 0;

        //Es wird nach der Startpostion gesucht
        for(int i=0; i<p_array.length;i++){
            for(int j = 0; j<p_array.length;j++){
                if(p_array[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        //Es wird nach der Endposition gesucht
        for(int i=0; i<p_array.length;i++){
            for(int j = 0; j<p_array.length;j++){
                if(p_array[i][j] == 2){
                    endeX = i;
                    endeY = j;
                }
            }
        }

        int positionX = startX;
        int positionY = startY;
        int difPosEndeX = endeX - positionX;
        int difPosEndeY = endeY - positionY;

        while(difPosEndeX != 0 && difPosEndeY != 0) {
            if (difPosEndeX >= difPosEndeY) {
                positionX = positionX + 1;
                //Testen ob dort ein Hindernis ist
                if(!testeAufHindernis(p_array, positionX, positionY)) {
                    p_array[positionX][positionY] = 5;
                }
                else{
                    p_array[positionX][positionY] = 4;
                }
            } else {
                positionY = positionY + 1;
                //Testen ob dort ein Hindernis ist
                if(!testeAufHindernis(p_array, positionX, positionY)){
                    p_array[positionX][positionY] = 5;
                }
                else{
                    p_array[positionX][positionY] = 4;
                }
            }
            difPosEndeX = endeX - positionX;
            difPosEndeY = endeY - positionY;
        }

        System.out.println("weg berechent!");
        return p_array;
    }

    public Berechnung(){


    }

}
