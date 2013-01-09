package pl.polidea.coderetreat.game;

import junit.framework.Assert;
import org.junit.Test;

public class GameOfLifeTest {
    @Test
    public void testGameSize() {
        // when
        GameOfLife gameOfLife = new GameOfLife(4);

        // then
        Assert.assertEquals(16, gameOfLife.size());
    }

    @Test
    public void testRealGameSize() {
        // when
        GameOfLife gameOfLife = new GameOfLife(4);

        // then
        Assert.assertEquals(36, gameOfLife.realSize());
    }

    @Test
    public void testTableEmptyness(){
        // when
        GameOfLife gameOfLife = new GameOfLife(4);

        // then
        Assert.assertTrue(gameOfLife.isEmpty());
    }
}
