package com.timelab.de;

import java.util.ArrayList;
import java.util.List;

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
                //Test for Barrier
                if (!testeAufHindernis(p_array, positionX, positionY)) {
                       p_array[positionX][positionY] = 5;
                } else {
                    p_array[positionX][positionY] = 4;
                }
            } else if (difPosEndeX < difPosEndeY) {
                positionY = positionY + 1;
                //Test for barrier
                if (!testeAufHindernis(p_array, positionX, positionY)) {
                    p_array[positionX][positionY] = 5;
                } else {
                    p_array[positionX][positionY] = 4;
                }
            } else {
                positionX = positionX + 1;
                positionY = positionY + 1;

                if(positionX != endeX && positionY != endeY){
                    if (!testeAufHindernis(p_array, positionX, positionY)) {
                    p_array[positionX][positionY] = 5;
                    } else {
                    p_array[positionX][positionY] = 4;
                    }
                }
            }
            //Calculate new Diff
            difPosEndeX = endeX - positionX;
            difPosEndeY = endeY - positionY;
        }
        System.out.println("Weg berechent!");
        return p_array;
    }

    public Berechnung(){


    }

    public int[][] aSternHV(int p_feld[][]) {
        int[] start = new int[2]; //saves x/y coordinate
        int[] end = new int[2]; //saves x/y coordinate
        int[] actualBestCoord = new int[2]; //saves x/y coordinate
        int[][] pathField = new int[p_feld.length][p_feld.length];

        int[][] openList = new int[p_feld.length][p_feld.length], closedList = new int[p_feld.length][p_feld.length];

        //pathfield/openlist/closedlist set all fields to -1
        for (int i = 0; i < p_feld.length; i++) {
            for (int j = 0; j < p_feld.length; j++) {
                pathField[i][j] = -1;
                openList[i][j] = -1;
                closedList[i][j] = -1;
            }
        }

        //save start coords
        for (int i = 0; i < p_feld.length; i++) {
            for (int j = 0; j < p_feld.length; j++) {
                if(p_feld[i][j] == 1) {
                    start[0] = i; //x-coord
                    start[1] = j; //y-coord

                    actualBestCoord[0] = i;
                    actualBestCoord[1] = j;
                    pathField[actualBestCoord[0]][actualBestCoord[1]] = distToDest(actualBestCoord[0],actualBestCoord[1],end[0],end[1]);
                    break;
                }
            }
        }

        //save end coords
        for (int i = 0; i < p_feld.length; i++) {
            for (int j = 0; j < p_feld.length; j++) {
                if(p_feld[i][j] == 2) {
                    end[0] = i; //x-coord
                    end[1] = j; //y-coord
                    break;
                }
            }
        }



        openList[start[0]][start[1]] = distToDest(start[0],start[1],end[0],end[1]);


        int bestCoord[] = new int[2];
        int dist = 0; //just for saving
        boolean wayOut = true; //if there ist still a way out from the actual position without going back
        int actualDist;
        int test = 0;
        int distWent = 0;

        while (test < 100) {
            wayOut = false;
            dist = 10000;

            actualBestCoord[0] = posOfSmallestValue(openList)[0];
            actualBestCoord[1] = posOfSmallestValue(openList)[1];
            actualDist = openList[actualBestCoord[0]][actualBestCoord[1]];

            //go left (x-1|y)
            if(actualBestCoord[0]-1 > -1 && actualBestCoord[0]-1 < p_feld.length && p_feld[actualBestCoord[0]-1][actualBestCoord[1]] == 0 && pathField[actualBestCoord[0]-1][actualBestCoord[1]] == -1 && closedList[actualBestCoord[0]-1][actualBestCoord[1]] == -1) {
                pathField[actualBestCoord[0]-1][actualBestCoord[1]] = distWent+distToDest(actualBestCoord[0]-1,actualBestCoord[1],end[0],end[1]);
                openList[actualBestCoord[0]-1][actualBestCoord[1]] = distWent+distToDest(actualBestCoord[0]-1,actualBestCoord[1],end[0],end[1]);
                wayOut = true;
                System.out.println("go left POSSIBLE");
            }
            //go right (x+1|y)
            if(actualBestCoord[0]+1 > -1 && actualBestCoord[0]+1 < p_feld.length && p_feld[actualBestCoord[0]+1][actualBestCoord[1]] == 0 && pathField[actualBestCoord[0]+1][actualBestCoord[1]] == -1 && closedList[actualBestCoord[0]+1][actualBestCoord[1]] == -1) {
                pathField[actualBestCoord[0]+1][actualBestCoord[1]] = distWent+distToDest(actualBestCoord[0]+1,actualBestCoord[1],end[0],end[1]);
                openList[actualBestCoord[0]+1][actualBestCoord[1]] = actualDist+distToDest(actualBestCoord[0]+1,actualBestCoord[1],end[0],end[1]);
                wayOut = true;
                System.out.println("go right POSSIBLE");
            }
            //go up (x|y-1)
            if(actualBestCoord[1]-1 > -1 && actualBestCoord[1]-1 < p_feld.length && p_feld[actualBestCoord[0]][actualBestCoord[1]-1] == 0 && pathField[actualBestCoord[0]][actualBestCoord[1]-1] == -1 && closedList[actualBestCoord[0]][actualBestCoord[1]-1] == -1) {
                pathField[actualBestCoord[0]][actualBestCoord[1]-1] = distWent+distToDest(actualBestCoord[0],actualBestCoord[1]-1,end[0],end[1]);
                openList[actualBestCoord[0]][actualBestCoord[1]-1] = distWent+distToDest(actualBestCoord[0],actualBestCoord[1]-1,end[0],end[1]);
                wayOut = true;
                System.out.println("go up POSSIBLE");
            }
            //go down (x|y+1)
            if(actualBestCoord[1]+1 > -1 && actualBestCoord[1]+1 < p_feld.length && p_feld[actualBestCoord[0]][actualBestCoord[1]+1] == 0 && pathField[actualBestCoord[0]][actualBestCoord[1]+1] == -1 && closedList[actualBestCoord[0]][actualBestCoord[1]+1] == -1) {
                pathField[actualBestCoord[0]][actualBestCoord[1]+1] = distWent+distToDest(actualBestCoord[0],actualBestCoord[1]+1,end[0],end[1]);
                openList[actualBestCoord[0]][actualBestCoord[1]+1] = distWent+distToDest(actualBestCoord[0],actualBestCoord[1]+1,end[0],end[1]);
                wayOut = true;
                System.out.println("go down POSSIBLE");
            }

            distWent++;

            //set actualBestCoord in the cloesed list an removes it from openlist
            closedList[actualBestCoord[0]][actualBestCoord[1]] = openList[actualBestCoord[0]][actualBestCoord[1]];
            openList[actualBestCoord[0]][actualBestCoord[1]] = -1;

            test++;
        }

        arrayAusgeben(openList);
        arrayAusgeben(closedList);
        return p_feld;
    }

    private int distToDest(int ax, int ay, int bx, int by) {
        int destX = ax-bx;
        int destY = ay-by;
        if(destX < 0)
            destX = destX*-1;
        if(destY < 0)
            destY = destY*-1;

        return destX+destY;
    }

    private int[] posOfSmallestValue(int[][] list) {
        int smallest = 1000;
        int[] pos = new int[2];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if(smallest > list[i][j] && list[i][j] > -1) {
                    smallest = list[i][j];
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        return pos;
    }

}
