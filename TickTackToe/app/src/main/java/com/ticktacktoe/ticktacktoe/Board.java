package com.ticktacktoe.ticktacktoe;

public class Board {
    private final int row;
    private final int col;

    public Board(int dimension) {
        this.row = dimension;
        this.col = dimension;

    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
