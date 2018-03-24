package com.company;

public class Main {

    //Definition der Statischen Variablen


    public static void main(String[] args) {

        //Variablen Initalisieren
        boolean ende = false;

        //Objekte Initalisieren
        Spielfeld spielfeld = new Spielfeld(new char[8][8], 4);
        UI userinterface = new UI();
        Player[] Players = new Player[]{new Player("Markus", 'X'), new Player("David", 'O')};

        //Spieler Willkomen heißen
        userinterface.welcomePlayer();

        while (!ende) {

            for (Player player : Players) {
                while (!spielfeld.setStone(userinterface.getcolumn(player, spielfeld), player)) ;
                spielfeld.printspielfeld();
                ende = spielfeld.isOver(player);
                if (ende) {
                    break;
                }
            }

        }
    }
}
