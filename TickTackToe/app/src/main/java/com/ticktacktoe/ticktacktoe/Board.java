package com.ticktacktoe.ticktacktoe;

public class Board {

    public static final int EMPTY_FIELD_SIGN = -1;

    private final int row;
    private final int col;

    private final int[][] boardMatrix;

    public Board(int dimension) {
        this.row = dimension;
        this.col = dimension;
        this.boardMatrix = new int[row][col];
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < col; b++) {
                this.boardMatrix[a][b] = EMPTY_FIELD_SIGN;
            }
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setFieldSign(int row, int column, int playerIndex) {
        boardMatrix[row][column] = playerIndex;
    }

    public int getFieldSign(int row, int column) {
        return boardMatrix[row][column];
    }

    private int getWinnerSign() {
        for (int b = 0; b < col-1; b++) {
        int index = EMPTY_FIELD_SIGN;
            for (int a = 0; a < row-1; a++) {
                if(this.boardMatrix[a][b] != this.boardMatrix[a][b+1]) {
                    break;
                }
                index = this.boardMatrix[a][b];
            }
            if(index != EMPTY_FIELD_SIGN) {
                return index;
            }
        }
        return EMPTY_FIELD_SIGN;
    }
}
