package com.carrom.cleanstrike.serviceimpl;

import com.carrom.cleanstrike.model.CarromBoard;
import com.carrom.cleanstrike.model.CoinType;
import com.carrom.cleanstrike.model.Player;
import com.carrom.cleanstrike.service.Action;

public class ActionImpl implements Action {

    @Override
    public void strike(CarromBoard board, Player player) {
        int number = board.getCoins().get(CoinType.BLACK);
        board.getCoins().put(CoinType.BLACK,number-1);
        player.setScore(player.getScore()+1);
    }

    @Override
    public void multiStrike( Player player) {
        player.setScore(player.getScore()+2);
    }

    @Override
    public void redStrike(CarromBoard board, Player player) {
        int number = board.getCoins().get(CoinType.QUEEN);
        board.getCoins().put(CoinType.QUEEN,number-1);
        player.setScore(player.getScore()+3);
    }

    @Override
    public void defunctCoins(CarromBoard board, Player player) {
        int number = board.getCoins().get(CoinType.BLACK);
        board.getCoins().put(CoinType.BLACK,number-1);
        player.setScore(player.getScore()-2);
        player.setNumberOfFouls(player.getNumberOfFouls()+1);
    }

    @Override
    public void strikerStrike(CarromBoard board, Player player) {
        player.setScore(player.getScore()-1);
        player.setNumberOfFouls(player.getNumberOfFouls()+1);
    }


}
