package com.ticktacktoe.ticktacktoe;

public class Game {

    private final Player[] players;
    private final Board board;
    private int turn = -1;

    public Game(Board board, Player playerOne, Player playerTwo) {
        if (playerOne == null || playerTwo == null) {
            throw new IllegalArgumentException("Players cannot be null");
        }

        if (playerOne.equals(playerTwo)) {
            throw new IllegalArgumentException("Players should not be same");
        }

        players = new Player[2];
        players[0] = playerOne;
        players[1] = playerTwo;
        this.board = board;
    }

    public int getPlayersCount() {
        return players.length;
    }

    public Board getBoard() {
        return board;
    }

    public Player getPlayerOne() {
        return players[0];
    }

    public Player getPlayerTwo() {
        return players[1];
    }

    public void nextPlayer(int row, int column) {
        turn++;
        if (board.getFieldSign(row, column) != Board.EMPTY_FIELD_SIGN) {
            throw new IllegalStateException("Field already taken");
        }
        board.setFieldSign(row, column, getPlayerIndex());
        if(board) {
            throw new IllegalStateException("There was winner");
        }
    }

    private int getPlayerIndex() {
        return turn % players.length;
    }

    public Player getCurrentPlayer() {
        return turn == -1 ? null : players[getPlayerIndex()];
    }

    public boolean isSignPlaced(int row, int column) {
        return board.getFieldSign(row, column) != Board.EMPTY_FIELD_SIGN;
    }

    public Player getPlayerOnPosition(int row, int column) {
        int sign = board.getFieldSign(row, column);
        return sign == Board.EMPTY_FIELD_SIGN ? null : players[sign];
    }

    public Player getWinningPlayer() {
        return getCurrentPlayer();
    }
}
