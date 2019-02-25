package com.carrom.cleanstrike.model;

import java.util.HashMap;
import java.util.Map;

public class CarromBoard {


    private Map<CoinType,Integer> coins;

    public Map<CoinType, Integer> getCoins() {
        return coins;
    }

    public void setCoins(Map<CoinType, Integer> coins) {
        this.coins = coins;
    }



    public static CarromBoard initialize() {
        CarromBoard carromBoard = new CarromBoard();
        Map<CoinType,Integer> coins= new HashMap<>();
        coins.put(CoinType.BLACK,9);
        coins.put(CoinType.QUEEN,1);
        coins.put(CoinType.STRIKER,1);
        carromBoard.setCoins(coins);
        return carromBoard;
    }
}
