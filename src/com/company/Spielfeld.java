package com.company;

public class Spielfeld {

    private char[][] spielfeld = new char[8][8];
    private int winningStoneCount = 4;


    public Spielfeld(char[][] spielfeld,int winningStoneCount){
        this.spielfeld = spielfeld;
        this.winningStoneCount = winningStoneCount;
    }

    public void printspielfeld(){

        StringBuffer strbuff = new StringBuffer();

        //Orientierung Drucken
        strbuff.append("12345678\n");

        for (int i = 0;i != spielfeld[0].length;i++){
            for (int t = 0;t != spielfeld.length;t++)

                if (spielfeld[i][t] != 0) {
                    strbuff.append(spielfeld[i][t]);
                } else {
                    //Leere Felder Drucken
                    strbuff.append(".");
                }
            strbuff.append('\n');
        }
        //Orientierung Drucken
        strbuff.append("12345678");
        System.out.println(strbuff.toString());
    }

    public boolean setStone(int row, Player player){

        for (int colum = spielfeld.length -1; colum >= 0; colum--){
            if (spielfeld[colum][row] == 0){

                    spielfeld[colum][row] = player.getStone();

                break;
            } else if (colum == 0){
                System.out.println("\nHier kann der Stein nicht eingelegt werden!\n");
                return false;
            }
        }

        //Wenn es möglich war den Stein zusetzen
        return true;
    }

    public boolean isOver(Player player) {

        //Schräg von Links nach rechts

        for (int currentrow = winningStoneCount; currentrow <= spielfeld.length - 1; currentrow++) {

            for (int colum = 0; colum <= spielfeld[0].length; colum++) {

//                if (colum == 7){
//                    int test = 0;
//                }

                int blockcount = 0;
//                int blockcountO = 0;

                for (int aktcolum = colum, aktrow = currentrow; aktcolum <= spielfeld[0].length - 1 && aktrow >= 0; aktcolum++, aktrow--) {
                    if (aktcolum == 8 || aktrow == 8) {
                        int testz = 0;
                    }
                    if (spielfeld[aktrow][aktcolum] == player.getStone()) {
                        blockcount++;
                    } else {
                        blockcount = 0;
                    }

                    if (blockcount == winningStoneCount) {
                        return true;
                    }

                }
            }
        }

        //Schräg von rechts nach links

        for (int currentrow = winningStoneCount; currentrow <= spielfeld.length - 1; currentrow++) {

            for (int colum = spielfeld[0].length - 1; colum >= 0; colum--) {

                int blockcount = 0;

                for (int aktcolum = colum, aktrow = currentrow; aktcolum >= 0 && aktrow >= 0; aktcolum--, aktrow--) {

                    if (spielfeld[aktrow][aktcolum] == player.getStone()) {
                        blockcount++;
                    } else {
                        blockcount = 0;
                    }


                    if (blockcount == winningStoneCount) {
                        return true;
                    }

                }
            }
        }

        //Vertikal
        for (int colum = 0; colum <= spielfeld[0].length -1; colum++) {

            int blockcount = 0;

            for (int aktrow = 0; aktrow <= spielfeld[0].length -1; aktrow++) {

                if (spielfeld[aktrow][colum] == player.getStone()) {
                    blockcount++;
                } else {
                    blockcount = 0;
                }

                if (blockcount == winningStoneCount) {
                    return true;
                }

            }
        }

        //Horizontal

        for (int aktrow = 0; aktrow <= spielfeld[0].length -1; aktrow++) {

            int blockcount = 0;

            for (int colum = 0; colum <= spielfeld[0].length -1; colum++) {

                if (aktrow == 7) {
                    int test = 0;
                }
                if (spielfeld[aktrow][colum] == player.getStone()) {
                    blockcount++;
                } else {
                    blockcount = 0;
                }

                if (blockcount == winningStoneCount) {
                    return true;
                }

            }
        }

        //Keine Gewinnmöglichkeit gefunden
        return false;
    }

}
