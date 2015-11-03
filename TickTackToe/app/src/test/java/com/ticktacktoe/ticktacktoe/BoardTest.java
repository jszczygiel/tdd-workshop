package com.ticktacktoe.ticktacktoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoardTest {

    @Test
    public void testIfBoardWasCreated(){
        Board board=new Board(1);

        assertNotNull(board);
    }

    @Test
    public void testIfBoardHasColumnAndRowsSet(){
        int a = 3;

        Board board = new Board(a);


        assertEquals(a,board.getCol());
        assertEquals(a, board.getRow());
    }

    @Test
    public void testIfRowAndColAreEqual() {
        int a = 3;

        Board board = new Board(a);

        assertEquals(board.getCol(), board.getRow());
    }

}
