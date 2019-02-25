package com.carrom.cleanstrike.service;

import com.carrom.cleanstrike.model.CarromBoard;
import com.carrom.cleanstrike.model.Player;

public interface Action {
    public void strike(CarromBoard board, Player player);
    public void multiStrike(Player player);
    public void redStrike(CarromBoard board, Player player);
    public void defunctCoins(CarromBoard board, Player player);
    public void strikerStrike(CarromBoard board, Player player);


}
