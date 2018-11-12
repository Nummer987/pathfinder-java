package com.timelab.de;

public class Berechnung {

    public void arrayFuellen(int[][] p_array){
        for(int i=0; i<p_array.length;i++){
            for(int j = 0; j<p_array.length;j++){
                p_array[i][j] = 0;
            }
        }

    }

    public void methode1(int[][] p_array){
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
        int difPosEndeX = positionX - endeX;
        int difPosEndeY = positionY - endeY;

        while(difPosEndeX != 0 && difPosEndeY != 0) {
            if (difPosEndeX >= difPosEndeY) {
                positionX++;
                p_array[positionX][positionY] = 4;
            } else {
                positionY++;
                p_array[positionX][positionY] = 4;
            }
            difPosEndeX = positionX - endeX;
            difPosEndeY = positionY - endeY;
        }

        for(int i=0; i<p_array.length;i++){
            for(int j = 0; j<p_array.length;j++){
                System.out.print(p_array[i][j]+ " ");
            }
            System.out.println();
        }

    }

    public Berechnung(){


    }

}
