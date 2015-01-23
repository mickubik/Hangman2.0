package com.word;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class WordTest {
	private static final String testingWord = "test";

	@Test
	public void createWord() {
		final String wordToGuess = testingWord;
		final Word word = new Word(wordToGuess);
		assertEquals(word.getWordAsString(), wordToGuess);
	}

	@Test
	public void noLetterIsGuessedInNewWord() {
		final Word word = new Word(testingWord);
		for (final GuessableChar guessableCharacter: word.getWord()) {
			assertFalse(guessableCharacter.isGuessed());
		}
	}

	@Test
	public void letterInWordIsSetToGuessedAfterBeingGuessed() {
		final char charToGuess = 't';
		final Word word = new Word(testingWord);
		word.guessLetter(charToGuess);
		for (final GuessableChar guessableCharacter: word.getWord()) {
			if (guessableCharacter.getChar() == charToGuess) {
				assertTrue(guessableCharacter.isGuessed());
			}
		}
	}

}
