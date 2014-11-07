package com.word;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class WordTest {

	@Test
	public void createWord() {
		String wordToGuess = "test";
		Word word = new Word("test");
		assertEquals(word.getWordAsString(), wordToGuess);
	}

	@Test
	public void noLetterIsGuessedInNewWord() {
		Word word = new Word("test");
		for (GuessableChar guessableCharacter: word.getWord()) {
			assertFalse(guessableCharacter.isGuessed());
		}
	}

	@Test
	public void letterInWordIsSetToGuessedAfterBeingGuessed() {
		char charToGuess = 't';
		Word word = new Word("test");
		word.guessLetter(charToGuess);
		for (GuessableChar guessableCharacter: word.getWord()) {
			if (guessableCharacter.getChar() == charToGuess){
				assertTrue(guessableCharacter.isGuessed());
			}
		}
	}

}
