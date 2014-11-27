package com.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AlphabetLettersGuessedTest {
	private static final int SIZE_OF_ALPHABET = 26;

	@Test
	public void createAlphabetLettersGuessedTest() {
		AlphabetLettersGuessed alphabetLettersGuessed = new AlphabetLettersGuessed();
	}

	@Test
	public void initalizeAlphabetLetterGuessedMapTest() {
		AlphabetLettersGuessed alphabetLettersGuessed = new AlphabetLettersGuessed();
		assertEquals(alphabetLettersGuessed.getAlphabetLetterGuesssedMap().size(), SIZE_OF_ALPHABET);
	}

	@Test
	public void noLettersInitiallyGuessedTest(){
		AlphabetLettersGuessed alphabetLettersGuessed = new AlphabetLettersGuessed();
		for (char letterInAlphabet : alphabetLettersGuessed.THE_ALPHABET){
			assertFalse(alphabetLettersGuessed.isLetterGuessed(letterInAlphabet));
		}
	}

	@Test
	public void letterGetsSetToGuessed(){
		char letterToGuess = 'C';
		AlphabetLettersGuessed alphabetLettersGuessed = new AlphabetLettersGuessed();
		alphabetLettersGuessed.setGuessed(letterToGuess);
		assertTrue(alphabetLettersGuessed.isLetterGuessed(letterToGuess));
	}

}
