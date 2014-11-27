package com.word;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class WordTest {
	private static final String testingWord = "test";

	@Test
	public void createWord() {
		String wordToGuess = testingWord;
		Word word = new Word(wordToGuess);
		assertEquals(word.getWordAsString(), wordToGuess);
	}

	@Test
	public void noLetterIsGuessedInNewWord() {
		Word word = new Word(testingWord);
		for (GuessableChar guessableCharacter: word.getWord()) {
			assertFalse(guessableCharacter.isGuessed());
		}
	}

	@Test
	public void letterInWordIsSetToGuessedAfterBeingGuessed() {
		char charToGuess = 't';
		Word word = new Word(testingWord);
		word.guessLetter(charToGuess);
		for (GuessableChar guessableCharacter: word.getWord()) {
			if (guessableCharacter.getChar() == charToGuess){
				assertTrue(guessableCharacter.isGuessed());
			}
		}
	}

}
