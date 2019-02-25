package com.carrom.cleanstrike.serviceimpl;

import com.carrom.cleanstrike.model.CarromBoard;
import com.carrom.cleanstrike.model.CoinType;
import com.carrom.cleanstrike.model.Player;
import com.carrom.cleanstrike.service.Action;
import com.carrom.cleanstrike.serviceimpl.ActionImpl;
import com.carrom.cleanstrike.util.FoulsUtility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartGame {

    static Action action = new ActionImpl();
    static FoulsUtility fouls = new FoulsUtility();
    static boolean gameOn = true;

    public static void start(CarromBoard carromBoard, Player player1, Player player2){
        int turnNumber =0;
        List<String> commands = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/malviyas/Downloads/carrom board/src/input"))) {
            while (br.ready()) {
                commands.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (gameOn && turnNumber<commands.size()){
            for(String command:commands) {
                Player currentPlayer = null;
                currentPlayer = getCurrentPlayer(player1, player2, turnNumber);

                playCommand(carromBoard, command, currentPlayer,turnNumber);

                fouls.consecutiveNone(player1, player2, turnNumber);
                fouls.threeFouls(player1, player2);
                turnNumber++;
                if(carromBoard.getCoins().get(CoinType.BLACK)==0 && !((player1.getScore()>5 && player1.getScore()>(player2.getScore()-3)) || (player2.getScore()>5 && player2.getScore()>(player1.getScore()-3)))){
                    draw();
                }
               isGameOn(player1, player2);
                if(!gameOn){
                    break;
                }
            }
            if(!((player1.getScore()>5 && player1.getScore()>(player2.getScore()-3)) || (player2.getScore()>5 && player2.getScore()>(player1.getScore()-3)))){
                draw();
            }else if(gameOn){
                isGameOn(player1, player2);
            }
        }

    }

    private static void draw() {
        System.out.println("Game is draw");
        gameOn=false;
    }

    private static void playCommand(CarromBoard carromBoard, String command, Player currentPlayer,int turnNumber) {
        switch (command) {
            case "strike":
                action.strike(carromBoard, currentPlayer);
                break;
            case "multiStrike":
                action.multiStrike(currentPlayer);
                break;
            case "redStrike":
                action.redStrike(carromBoard, currentPlayer);
                break;
            case "strikerStrike":
                action.strikerStrike(carromBoard, currentPlayer);
                break;
            case "defunctCoin":
                action.defunctCoins(carromBoard, currentPlayer);
                break;
            case "none":
                fouls.setFoul(turnNumber,1);
                break;
        }
    }

    private static void  isGameOn(Player player1, Player player2) {
        if((player1.getScore()>5 && player1.getScore()>(player2.getScore()-3)) || (player2.getScore()>5 && player2.getScore()>(player1.getScore()-3))){
            if(player1.getScore()>player2.getScore()){
                System.out.println("winner = " + player1.getName());
                System.out.println(player1.getScore()+ " "+ player2.getScore());
            }
            else {
                System.out.println("winner = " + player2.getName());
                System.out.println(player1.getScore()+ " "+ player2.getScore());
            }
            gameOn=false;
        }
    }

    private static Player getCurrentPlayer(Player player1, Player player2, int turnNumber) {
        Player currentPlayer;
        if(turnNumber%2==0){
            currentPlayer=player1;
        }
        else {
            currentPlayer = player2;
        }
        return currentPlayer;
    }
}

