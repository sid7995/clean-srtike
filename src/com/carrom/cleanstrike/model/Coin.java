package com.carrom.cleanstrike.model;

public class Coin {
    private CoinType coinType;

    private int numberOfCoins;

    public Coin(CoinType coinType, int numberOfCoins) {
        this.coinType = coinType;
        this.numberOfCoins = numberOfCoins;
    }

    public CoinType getColor() {
        return coinType;
    }

    public void setColor(CoinType coinType) {
        this.coinType = coinType;
    }


}
