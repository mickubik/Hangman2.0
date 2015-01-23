package com.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import i18n.I18n;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
	private static final String TESTING_WORD = "TEST";
	private static final Character LOWERCASE_CHAR_IN_TESTING_WORD = TESTING_WORD.toLowerCase().charAt(1);
	private static final Character LETTER_IN_TESTING_WORD = TESTING_WORD.charAt(1);
	private static final Character LETTER_NOT_IN_TESTING_WORD = 'Z';
	private static final Character INVALID_CHAR = '!';

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void createGameTest() {
		final Game game = new Game();
		assertTrue(game.getTriesRemaining() > 0);
		assertTrue(game.getWordToGuess() != null);
	}

	@Test
	public void initialGuessingWordDisplaysCorrectlyTest() {
		final Game game = new Game(TESTING_WORD);
		String displayWord = "";
		for (int i = 0; i < TESTING_WORD.length(); i++) {
			displayWord += I18n.UNGUESSED_LETTER;
		}
		assertTrue(game.getWordGuessingDisplayForm().equals(displayWord));
	}

	@Test
	public void guessingWordDisplayUpdatesTest() {
		final Game game = new Game(TESTING_WORD);
		final Character letterInWordToGuess = LETTER_IN_TESTING_WORD;
		game.guessChar(letterInWordToGuess);
		final String expectedDisplayedForm = TESTING_WORD.replaceAll("[^" + letterInWordToGuess + "]", I18n.UNGUESSED_LETTER);
		assertTrue(game.getWordGuessingDisplayForm().equals(expectedDisplayedForm));
	}

	@Test
	public void lowercaseLetterGuessedTest() {
		final Game game = new Game(TESTING_WORD);
		final Character letterInWordToGuess = LOWERCASE_CHAR_IN_TESTING_WORD;
		game.guessChar(letterInWordToGuess);
		final String expectedDisplayedForm = TESTING_WORD.replaceAll("[^" + Character.toUpperCase(letterInWordToGuess) + "]", I18n.UNGUESSED_LETTER);
		assertEquals(expectedDisplayedForm, game.getWordGuessingDisplayForm());
	}

	@Test
	public void incorrectLetterGuessedTest() {
		final Game game = new Game(TESTING_WORD);
		final Character letterInWordToGuess = LETTER_NOT_IN_TESTING_WORD;
		final int initialTriesRemaining = game.getTriesRemaining();
		game.guessChar(letterInWordToGuess);
		assertEquals(initialTriesRemaining - 1, game.getTriesRemaining());
	}

	@Test
	public void invalidCharacterGuessedTest() {
		final Game game = new Game(TESTING_WORD);
		final Character invalidCharacter = INVALID_CHAR;
		game.guessChar(invalidCharacter);
		assertTrue(outContent.toString().contains(i18n.I18n.INVALID_INPUT_MESSAGE));
	}

	@Test
	public void letterAlreadyGuessedTest() {
		final Game game = new Game(TESTING_WORD);
		final Character letterInWordToGuess = LETTER_IN_TESTING_WORD;
		game.guessChar(letterInWordToGuess);
		assertFalse(outContent.toString().contains(i18n.I18n.LETTER_ALREADY_GUESSED));
		game.guessChar(letterInWordToGuess);
		assertTrue(outContent.toString().contains(i18n.I18n.LETTER_ALREADY_GUESSED));
	}



	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

}
