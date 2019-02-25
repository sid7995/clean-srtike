package com.carrom.cleanstrike;

import com.carrom.cleanstrike.model.CarromBoard;
import com.carrom.cleanstrike.model.Player;
import com.carrom.cleanstrike.serviceimpl.StartGame;

public class Load {

    public static void main(String[] args) {
        CarromBoard carromBoard = CarromBoard.initialize();
        Player player1 = new Player("Tom");
        Player player2 = new Player("Jerry");
        StartGame.start(carromBoard,player1,player2);
    }
}
