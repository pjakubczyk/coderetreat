package pl.polidea.coderetreat.game;

import org.junit.Test;

import static junit.framework.Assert.*;

public class GameOfLifeTest {
    @Test
    public void testGameSize() {
        // when
        GameOfLife gameOfLife = new GameOfLife(4);

        // then
        assertEquals(16, gameOfLife.size());
    }

    @Test
    public void testRealGameSize() {
        // when
        GameOfLife gameOfLife = new GameOfLife(4);

        // then
        assertEquals(36, gameOfLife.realSize());
    }

    @Test
    public void testTableEmptyness() {
        // when
        GameOfLife gameOfLife = new GameOfLife(4);

        // then
        assertTrue(gameOfLife.isEmpty());
    }

    @Test
    public void testLoafGame() {
        // when
        GameOfLife gameOfLife = new GameOfLife(GameOfLife.TYPE.LOAF);
        int size = gameOfLife.size();

        // then
        // first row
        assertFalse("0,0", gameOfLife.get(0, 0));
        assertTrue("0,1", gameOfLife.get(0, 1));
        assertTrue("0,2", gameOfLife.get(0, 2));
        assertFalse("0,3", gameOfLife.get(0, 3));
        // second row
        assertTrue("1,0", gameOfLife.get(1, 0));
        assertFalse("1,1", gameOfLife.get(1, 1));
        assertFalse("1,2", gameOfLife.get(1, 2));
        assertTrue("1,3", gameOfLife.get(1, 3));
        // third row
        assertFalse("2,0", gameOfLife.get(2, 0));
        assertTrue("2,1", gameOfLife.get(2, 1));
        assertFalse("2,2", gameOfLife.get(2, 2));
        assertTrue("2,3", gameOfLife.get(2, 3));
        // fourth row
        assertFalse("3,0", gameOfLife.get(3, 0));
        assertFalse("3,1", gameOfLife.get(3, 1));
        assertTrue("3,2", gameOfLife.get(3, 2));
        assertFalse("3,3", gameOfLife.get(3, 3));
    }
}
