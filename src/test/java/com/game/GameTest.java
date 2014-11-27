package com.game;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.word.Constants;

public class GameTest {
	private static final String testingWord = "test";
	
	@Test
	public void createGameTest() {
		Game game = new Game();
		assertTrue(game.getTriesRemaining() > 0);
		assertTrue(game.getWordToGuess() != null);
	}
	
	@Test
	public void initialGuessingWordDisplaysCorrectlyTest(){
		Game game = new Game(testingWord);
		String displayWord = "";
		for (int i = 0; i < testingWord.length(); i++){
			displayWord += Constants.unguessedChar;
		}
		assertTrue(game.getWordGuessingDisplayForm().equals(displayWord));
	}
	
	@Test
	public void guessingWordDisplayUpdatesTest(){
		Game game = new Game(testingWord);
		Character letterInWordToGuess = testingWord.charAt(0);
		game.guessChar(letterInWordToGuess);
		String expectedDisplayedForm = testingWord.replaceAll("[^" + letterInWordToGuess + "]", Constants.unguessedChar);
		assertTrue(game.getWordGuessingDisplayForm().equals(expectedDisplayedForm));
	}
}
