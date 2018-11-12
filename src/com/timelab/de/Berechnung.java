package com.timelab.de;

public class Berechnung {

    //Test a field as an Barrier
    private boolean testeAufHindernis(int[][] p_array, int p_x, int p_y){
        if(p_array[p_x][p_y] != 3) {
            return true;
        }
        else{
            return false;
        }
    }
    //Prints the Array in the Console
    public void arrayAusgeben(int[][] p_array){
        for(int i=0; i<p_array.length;i++){
            for(int j = 0; j<p_array.length;j++){
                System.out.print(p_array[i][j] + " ");

            }
            System.out.println();

        }
        System.out.println();
    }

    //First Pathfinding Solution
    public int[][] methode1(int[][] p_array){
        //Vars
        int startX = 0;
        int startY = 0;
        int endeX = 0;
        int endeY = 0;

        //Searching for Startposition
        for(int i=0; i<p_array.length;i++){
            for(int j = 0; j<p_array.length;j++){
                if(p_array[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }
        //Search for Endposition
        for(int i=0; i<p_array.length;i++){
            for(int j = 0; j<p_array.length;j++){
                if(p_array[i][j] == 2){
                    endeX = i;
                    endeY = j;
                }
            }
        }
        //Current positions equals Startposition
        int positionX = startX;
        int positionY = startY;

        //Calculate Dif between current position and endposition
        int difPosEndeX = endeX - positionX;
        int difPosEndeY = endeY - positionY;

        while(difPosEndeX != 0 && difPosEndeY != 0) {
            if (difPosEndeX > difPosEndeY) {
                positionX = positionX + 1;
                //Testen ob dort ein Hindernis ist
                if (!testeAufHindernis(p_array, positionX, positionY)) {
                       p_array[positionX][positionY] = 5;
                } else {
                    p_array[positionX][positionY] = 4;
                }
            } else if (difPosEndeX < difPosEndeY) {
                positionY = positionY + 1;
                //Testen ob dort ein Hindernis ist
                if (!testeAufHindernis(p_array, positionX, positionY)) {
                    p_array[positionX][positionY] = 5;
                } else {
                    p_array[positionX][positionY] = 4;
                }
            } else {
                positionX = positionX + 1;
                positionY = positionY + 1;
                if (!testeAufHindernis(p_array, positionX, positionY)) {
                    p_array[positionX][positionY] = 5;
                } else {
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
