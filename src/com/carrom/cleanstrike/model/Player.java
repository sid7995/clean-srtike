package com.carrom.cleanstrike.model;

public class Player {
    private String name;
    private  int score;
    private int numberOfFouls;


    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.numberOfFouls=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfFouls() {
        return numberOfFouls;
    }

    public void setNumberOfFouls(int numberOfFouls) {
        this.numberOfFouls = numberOfFouls;
    }
}
