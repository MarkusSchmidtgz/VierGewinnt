package com.company;

import java.io.IOException;

public class UI {

    public void welcomePlayer(){
        System.out.println("Herzlich willkomen zu Vier gewinnt \nSpieler ein besitzt den Stein X und Spieler 2 den Stein O (wie Otto)");
        System.out.println("Die Spalten und Reihen angabe wird wie folgt angegeben Spalte:Reihe zum Beispiel 1:1 für den ersten Stein oben links \n");
    }

    public int getRow(Player player, Spielfeld spielfeld){

        int zaehler = 0;
        boolean correctvalues = false;
        int currentX = 0;

        try {

            while (!correctvalues) {
                System.out.print("Spieler"+ player.getName() + "mit Stein" + player.getStone() + " bitte geben Sie die Spalte an: ");
                for (char c; (c = (char) System.in.read()) != '\r' && c != '\n' && currentX != 0; zaehler++) {

                    if (zaehler == 0 && c >= '1' && c <= '8') {

                        currentX = c - 48;

                        if (!spielfeld.setStone(currentX,player)){
                            break;
                        }

                        continue;

                    } else {
                        System.out.println("Fehler bei der Eingabe");
                    }

                }
                correctvalues = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return currentX;
    }

}
