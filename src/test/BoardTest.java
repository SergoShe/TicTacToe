package test;

import gameplay.Board;
import gameplay.Position;
import gameplay.Sign;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void testInitTable() {
        Sign[][] excepted = {{Sign.SIGN_EMPTY, Sign.SIGN_EMPTY, Sign.SIGN_EMPTY},
                {Sign.SIGN_EMPTY, Sign.SIGN_EMPTY, Sign.SIGN_EMPTY},
                {Sign.SIGN_EMPTY, Sign.SIGN_EMPTY, Sign.SIGN_EMPTY}};
        board.setSign(new Position(1),Sign.SIGN_X);
        board.setSign(new Position(5),Sign.SIGN_O);
        board.setSign(new Position(9),Sign.SIGN_X);
        board.initTable();
        Sign[][] actual = board.getTable();
        Assert.assertArrayEquals(excepted,actual);
    }

    @Test
    public void testSetSign() {
        Position pos = new Position(5);
        board.setSign(pos,Sign.SIGN_X);
        Sign excepted = Sign.SIGN_X;
        Sign actual = board.getSign(pos);
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void testGetSign() {
        Sign excepted = Sign.SIGN_EMPTY;
        Sign actual = board.getSign(new Position(5));
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void testGetTable() {
        Sign[][] excepted = {{Sign.SIGN_EMPTY, Sign.SIGN_EMPTY, Sign.SIGN_EMPTY},
                {Sign.SIGN_EMPTY, Sign.SIGN_EMPTY, Sign.SIGN_EMPTY},
                {Sign.SIGN_EMPTY, Sign.SIGN_EMPTY, Sign.SIGN_EMPTY}};
        Sign[][] actual = board.getTable();
        Assert.assertArrayEquals(excepted,actual);
    }

    @Test
    public void testGetCountEmpty_1() {
        int excepted = 9;
        int actual = board.getCountEmpty();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void testGetCountEmpty_2() {
        board.setSign(new Position(1),Sign.SIGN_X);
        board.setSign(new Position(5),Sign.SIGN_O);
        board.setSign(new Position(9),Sign.SIGN_X);
        int excepted = 6;
        int actual = board.getCountEmpty();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void testCheckWin_1() {
        board.setSign(new Position(4),Sign.SIGN_X);
        board.setSign(new Position(5),Sign.SIGN_X);
        board.setSign(new Position(6),Sign.SIGN_X);
        Assert.assertTrue(board.checkWin(new Position(5)));
    }

    @Test
    public void testCheckWin_2() {
        board.setSign(new Position(1),Sign.SIGN_X);
        board.setSign(new Position(4),Sign.SIGN_X);
        board.setSign(new Position(7),Sign.SIGN_X);
        Assert.assertTrue(board.checkWin(new Position(5)));
    }

    @Test
    public void testCheckWin_3() {
        board.setSign(new Position(1),Sign.SIGN_X);
        board.setSign(new Position(5),Sign.SIGN_X);
        board.setSign(new Position(9),Sign.SIGN_X);
        Assert.assertTrue(board.checkWin(new Position(5)));
    }

    @Test
    public void testCheckWin_4() {
        board.setSign(new Position(3),Sign.SIGN_X);
        board.setSign(new Position(5),Sign.SIGN_X);
        board.setSign(new Position(7),Sign.SIGN_X);
        Assert.assertTrue(board.checkWin(new Position(5)));
    }

    @Test
    public void testCheckWin_5() {
        board.setSign(new Position(3),Sign.SIGN_X);
        board.setSign(new Position(7),Sign.SIGN_X);
        board.setSign(new Position(4),Sign.SIGN_X);
        Assert.assertFalse(board.checkWin(new Position(4)));
    }

    @Test
    public void testCheckWin_6() {
        board.setSign(new Position(1),Sign.SIGN_X);
        board.setSign(new Position(5),Sign.SIGN_X);
        board.setSign(new Position(8),Sign.SIGN_X);
        Assert.assertFalse(board.checkWin(new Position(8)));
    }

}