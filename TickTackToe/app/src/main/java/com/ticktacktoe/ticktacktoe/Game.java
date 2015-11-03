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

    public void nextPlayer() {
        turn++;
    }

    public Player getCurrentPlayer() {
        if (turn == -1) {
            return null;
        }
        return players[turn % players.length];
    }
}
