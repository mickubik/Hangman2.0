package com.game;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void createGameTest() {
		Game game = new Game();
		assertTrue(game.getTriesRemaining() > 0);
		assertTrue(game.getWordToGuess() != null);
	}
}
