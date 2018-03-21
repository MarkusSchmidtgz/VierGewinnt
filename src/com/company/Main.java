package com.company;

import java.io.IOException;

public class Main {

    //Definition der Statischen Variablen


    public static void main(String[] args) {

        boolean ende = false;
        char[][] spielfeld = new char[8][8];
        int currentX = 0;
        boolean actPlayer = false;
        int winningStoneCount = 4;

        System.out.println("Herzlich willkomen zu Vier gewinnt \nSpieler ein besitzt den Stein X und Spieler 2 den Stein O (wie Otto)");
        System.out.println("Die Spalten und Reihen angabe wird wie folgt angegeben Spalte:Reihe zum Beispiel 1:1 für den ersten Stein oben links \n");

        while (!ende) {


            int zaehler = 0;

            try {

                boolean correctvalues = false;

                while (!correctvalues) {
                    System.out.print("Spieler ");
                    if (actPlayer){ System.out.print(2);} else {System.out.print(1);}

                    System.out.print(" bitte geben Sie die Spalte an: ");
                    for (char c; (c = (char) System.in.read()) != '\r' && c != '\n'; zaehler++) {

                        if (zaehler == 0 && c >= '1' && c <= '8') {

                            currentX = c - 48;

                            if (!setStone(currentX,spielfeld,actPlayer)){
                                break;
                            }

                            continue;

                        } else {
                            System.out.println("Fehler bei der Eingabe");
                        }

                    }
                    actPlayer = !actPlayer;
                    if (isOver(spielfeld,winningStoneCount)){
                        System.out.print("\nSpieler ");
                        if (actPlayer){ System.out.print(2);} else {System.out.print(1);}
                        System.out.println(" gewinnt mit folgendem Brett:");
                        printSpielfeld(spielfeld);
                        System.exit(0);
                    }
                    correctvalues = true;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            printSpielfeld(spielfeld);
        }



    }

    private static void printSpielfeld(char[][] varSpielfeld){

        System.out.println("12345678");

        for (int i = 0;i != varSpielfeld[0].length;i++){
            for (int t = 0;t != varSpielfeld.length;t++)

                if (varSpielfeld[i][t] != 0) {
                    System.out.print(varSpielfeld[i][t]);
                } else {
                    System.out.print(".");
                }
                System.out.println();
        }

        System.out.println("12345678");
    }

    private static boolean setStone(int row, char[][] spielfeld, boolean player){

        for (int colum = spielfeld.length -1; colum >= 0; colum--){
            if (spielfeld[colum][row -1] == 0){
                if (player){
                    spielfeld[colum][row-1] = 'X';
                } else {
                    spielfeld[colum][row-1] = 'O';
                }
                break;
            } else if (colum == 0){
                System.out.println("Hier kann der Stein nicht eingelegt werder!");
                return false;
            }
        }
        return true;
    }

    private static boolean isOver(char[][] spielfeld, int winningStoneCount) {

        //Schräg von Links nach rechts
        for (int colum = winningStoneCount; colum <= spielfeld[0].length; colum++) {

            for (int currentrow = 0; currentrow <= spielfeld.length; currentrow++) {

                int blockcountX = 0;
                int blockcountO = 0;

                for (int aktcolum = colum, aktrow = currentrow; aktcolum <= spielfeld[0].length -1 && aktrow <= spielfeld.length -1; aktcolum++, aktrow++) {
//                    if (aktcolum == 8 || aktrow == 8){
//                        int testz = 0;
//                    }
                    if (spielfeld[aktcolum][aktrow] == 'X') {
                        blockcountX++;
                    } else {
                        blockcountX = 0;
                    }

                    if (spielfeld[aktcolum][aktrow] == 'O') {
                        blockcountO++;
                    } else {
                        blockcountO = 0;
                    }

                    if (blockcountO == 4 || blockcountX == 4) {
                        return true;
                    }
                }
            }
        }

        //Schräg von rechts nach links
        for (int colum = winningStoneCount; colum <= spielfeld[0].length -1; colum++) {

            for (int currentrow = spielfeld[0].length -1; currentrow>= 0; currentrow--) {

                int blockcountX = 0;
                int blockcountO = 0;

                for (int aktcolum = colum, aktrow = currentrow; aktcolum >= 0 && aktrow >= 0; aktcolum--, aktrow--) {
//                    if (aktcolum == 8 || aktrow == 8){
//                        int testz = 0;
//                    }
                    if (spielfeld[aktcolum][aktrow] == 'X') {
                        blockcountX++;
                    } else {
                        blockcountX = 0;
                    }

                    if (spielfeld[aktcolum][aktrow] == 'O') {
                        blockcountO++;
                    } else {
                        blockcountO = 0;
                    }

                    if (blockcountO == 4 || blockcountX == 4) {
                        return true;
                    }
                }
            }
        }

        //Vertikal
        for (int colum = 0; colum <= spielfeld[0].length -1; colum++) {

            int blockcountX = 0;
            int blockcountO = 0;

            for (int aktrow = 0; aktrow <= spielfeld[0].length -1; aktrow++) {

                if (spielfeld[aktrow][colum] == 'X') {
                    blockcountX++;
                } else {
                    blockcountX = 0;
                }

                if (spielfeld[aktrow][colum] == 'O') {
                    blockcountO++;
                } else {
                    blockcountO = 0;
                }

                if (blockcountO == 4 || blockcountX == 4) {
                    return true;
                }

            }
        }

        //Horizontal

        for (int aktrow = 0; aktrow <= spielfeld[0].length -1; aktrow++) {


            for (int colum = 0; colum <= spielfeld[0].length -1; colum++) {


                int blockcountX = 0;
                int blockcountO = 0;

                if (spielfeld[colum][aktrow] == 'X') {
                    blockcountX++;
                } else {
                    blockcountX = 0;
                }

                if (spielfeld[colum][aktrow] == 'O') {
                    blockcountO++;
                } else {
                    blockcountO = 0;
                }

                if (blockcountO == 4 || blockcountX == 4) {
                    return true;
                }

            }
        }

        return false;
    }
}
