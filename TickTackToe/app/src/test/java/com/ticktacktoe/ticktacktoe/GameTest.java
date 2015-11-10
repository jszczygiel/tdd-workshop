package com.ticktacktoe.ticktacktoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class GameTest {

    @Test
    public void testIfGameHasTwoPlayers() {
        Board board = new Board(3);

        Player playerOne = new Player();
        Player playerTwo = new Player();

        Game game = new Game(board, playerOne, playerTwo);

        assertEquals(2, game.getPlayersCount());
    }

    @Test
    public void testIfGameHasBoardAndPlayers() {
        Board board = new Board(3);
        Player player = new Player();
        Player playerTwo = new Player();

        Game game = new Game(board, player, playerTwo);

        assertNotNull(game.getBoard());
        assertNotNull(game.getPlayerOne());
        assertNotNull(game.getPlayerTwo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfGameHasNoPlayers() {
        Board board = new Board(3);
        Game game = new Game(board, null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfGamePlayersAreDifferent() {
        Player player = new Player();
        Game game = new Game(null, player, player);
    }

    @Test
    public void testIfGameHasntStartedThereIsNoCurrentPlayer() {
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);

        assertNull(game.getCurrentPlayer());
    }

    @Test
    public void testPlayerOneShouldStartTheGame() {
        int row = 0;
        int column = 1;

        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(row, column);

        assertEquals(playerOne, game.getCurrentPlayer());
    }

    @Test
    public void testPlayerTwoStartsSecondTurn() {
        int row = 0;
        int column = 1;

        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(row, column);
        game.nextPlayer(row + 1, column);

        assertEquals(playerTwo, game.getCurrentPlayer());
    }

    @Test
    public void testIfSignWasPlacedOnBoard() {
        int row = 0;
        int column = 1;
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(row, column);

        assertTrue(game.isSignPlaced(row, column));
    }

    @Test
    public void testIfASignIsAssignedToPlayerOne() {
        int row = 0;
        int column = 1;
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(row, column);

        assertEquals(playerOne, game.getPlayerOnPosition(row, column));
    }

    @Test
    public void testIfASignIsAssignedToPlayerTwo() {
        int row = 0;
        int column = 1;
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(row, column);
        game.nextPlayer(row + 1, column + 1);

        assertEquals(playerTwo, game.getPlayerOnPosition(row + 1, column + 1));
    }

    @Test(expected = IllegalStateException.class)
    public void testSignShouldNotBePlaceOnTakenPosition() {
        int row = 0;
        int column = 1;
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(row, column);
        game.nextPlayer(row, column);
    }

    @Test
    public void testIfPlayerWonByHavingNInColumn() {
        int n = 3;
        int columnPlayerOne = 1;
        int columnPlayerTwo = 0;
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(0, columnPlayerOne);
        game.nextPlayer(0, columnPlayerTwo);
        game.nextPlayer(1, columnPlayerOne);
        game.nextPlayer(1, columnPlayerTwo);
        game.nextPlayer(2, columnPlayerOne);

        assertEquals(playerOne, game.getWinningPlayer());
    }

    @Test(expected = IllegalStateException.class)
    public void testIfPlayerCanMoveAfterGameFinish() {
        int n = 3;
        int columnPlayerOne = 1;
        int columnPlayerTwo = 0;
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer(0, columnPlayerOne);
        game.nextPlayer(0, columnPlayerTwo);
        game.nextPlayer(1, columnPlayerOne);
        game.nextPlayer(1, columnPlayerTwo);
        game.nextPlayer(2, columnPlayerOne);
        game.nextPlayer(2, columnPlayerTwo);
    }
}
