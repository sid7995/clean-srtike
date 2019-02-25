package com.carrom.cleanstrike.util;


import com.carrom.cleanstrike.model.Player;

public class FoulsUtility{

    int[] consecutiveFouls = new int[1000];

    public  void threeFouls(Player player1, Player player2) {
        if(player1.getNumberOfFouls()>=3){
            player1.setScore(player1.getScore()-1);
            player1.setNumberOfFouls(0);
        }
        if(player2.getNumberOfFouls()>=3){
            player2.setScore(player2.getScore()-1);
            player2.setNumberOfFouls(0);
        }
    }
    public void consecutiveNone(Player player1, Player player2, int turnNumber) {
        if(turnNumber>=4&& getFoul(turnNumber-2)==1 && getFoul(turnNumber-4)==1){
            if(turnNumber%2==0){
                player1.setScore(player1.getScore()-1);
                player1.setNumberOfFouls(player1.getNumberOfFouls()+1);
            }else {
                player2.setScore(player2.getScore()-1);
                player2.setNumberOfFouls(player2.getNumberOfFouls()+1);
            }
            setFoul(turnNumber,0);
        }
    }

    public void setFoul(int turnNum,int value) {
        consecutiveFouls[turnNum]=value;
    }

    public int getFoul(int turnNum){
        return consecutiveFouls[turnNum];
    }


}
