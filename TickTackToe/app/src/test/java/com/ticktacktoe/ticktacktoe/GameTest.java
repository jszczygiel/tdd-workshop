package com.ticktacktoe.ticktacktoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer();

        assertEquals(playerOne, game.getCurrentPlayer());
    }

    @Test
    public void testPlayerTwoStartsSecondTurn() {
        Player playerOne = new Player();
        Player playerTwo = new Player();

        Board board = new Board(3);

        Game game = new Game(board, playerOne, playerTwo);
        game.nextPlayer();
        game.nextPlayer();

        assertEquals(playerTwo, game.getCurrentPlayer());
    }
}
