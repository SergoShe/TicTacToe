package test;

import gameplay.Position;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PositionTest {
    Position position;
    @Before
    public void setUp(){
        position = new Position(8);
    }

    @Test
    public void testGetRow() {
        int excepted = 2;
        int actual = position.getRow();
        Assert.assertEquals(excepted,actual);
    }

    @Test
    public void testGetColumn() {
        int excepted = 1;
        int actual = position.getColumn();
        Assert.assertEquals(excepted,actual);
    }
}