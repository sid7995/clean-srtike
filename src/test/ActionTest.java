package test;

import com.carrom.cleanstrike.model.CarromBoard;
import com.carrom.cleanstrike.model.CoinType;
import com.carrom.cleanstrike.model.Player;
import com.carrom.cleanstrike.service.Action;
import com.carrom.cleanstrike.serviceimpl.ActionImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class ActionTest {
    CarromBoard carromBoard = new CarromBoard();
    Action action = new ActionImpl();
    @Test
    public void testStrike (){
        Player player1 = new Player("Tom");
        Map<CoinType,Integer> coins= new HashMap<>();
        coins.put(CoinType.BLACK,9);
        coins.put(CoinType.QUEEN,1);
        coins.put(CoinType.STRIKER,1);
        carromBoard.setCoins(coins);

        action.strike(carromBoard,player1);
        Assert.assertEquals(1,player1.getScore());
        Assert.assertEquals(new Integer(8),carromBoard.getCoins().get(CoinType.BLACK));
    }
    @Test
    public void testMultistrike (){
        Player player1 = new Player("Tom");
        Map<CoinType,Integer> coins= new HashMap<>();
        coins.put(CoinType.BLACK,9);
        coins.put(CoinType.QUEEN,1);
        coins.put(CoinType.STRIKER,1);
        carromBoard.setCoins(coins);
        action.multiStrike(player1);
        Assert.assertEquals(2,player1.getScore());
    }
    @Test
    public void testRedStrike (){
        Player player1 = new Player("Tom");
        Map<CoinType,Integer> coins= new HashMap<>();
        coins.put(CoinType.BLACK,9);
        coins.put(CoinType.QUEEN,1);
        coins.put(CoinType.STRIKER,1);
        carromBoard.setCoins(coins);
        action.redStrike(carromBoard,player1);
        Assert.assertEquals(3,player1.getScore());
        Assert.assertEquals(new Integer(0),carromBoard.getCoins().get(CoinType.QUEEN));
    }

    @Test
    public void testStrikerStrike (){
        Player player1 = new Player("Tom");
        Map<CoinType,Integer> coins= new HashMap<>();
        coins.put(CoinType.BLACK,9);
        coins.put(CoinType.QUEEN,1);
        coins.put(CoinType.STRIKER,1);
        carromBoard.setCoins(coins);
        Action action = new ActionImpl();
        action.redStrike(carromBoard,player1);
        action.defunctCoins(carromBoard,player1);
        Assert.assertEquals(1,player1.getScore());
        Assert.assertEquals(1,player1.getNumberOfFouls());
    }


}
