package com.company;

import java.io.IOException;

public class Main {

    //Definition der Statischen Variablen


    public static void main(String[] args) {

        boolean ende = false;
        char[][] spielfeld = new char[8][8];
        int currentX = 0;
        boolean actPlayer = false;

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

    private static boolean setStone(int x, char[][] spielfeld, boolean player){

        for (int y = spielfeld.length -1; y != -11; y--){
            if (spielfeld[y][x -1] == 0){
                if (player){
                    spielfeld[y][x-1] = 'X';
                } else {
                    spielfeld[y][x-1] = 'O';
                }
                break;
            } else if (x == 1){
                return false;
            }
        }
        return true;

    }
}
