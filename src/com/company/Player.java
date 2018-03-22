package com.company;

public class Player {

    static private int playercount;
    private String name;
    private char stone;
    private int currentplayer;

    public Player(String name, char stone){
        this.name = name;
        this.stone = stone;
        this.playercount = ++playercount;
    }

    public String getName() {
        return name;
    }

    public char getStone() {
        return stone;
    }


}
