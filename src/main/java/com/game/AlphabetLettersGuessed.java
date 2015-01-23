package com.game;

import java.util.LinkedHashMap;
import java.util.Map;


public class AlphabetLettersGuessed {
	private final Map<Character, Boolean> alphabetLetterGuesssedMap = new LinkedHashMap<>();
	protected static final char[] THE_ALPHABET = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

	public AlphabetLettersGuessed() {
		initalizeAlphabetLetterGuessedMap();
	}

	/*
	 * Initialize Alphabet map to false as no letters have been guessed
	 */
	private void initalizeAlphabetLetterGuessedMap() {
		for (final char letterInAlphabet : THE_ALPHABET) {
			alphabetLetterGuesssedMap.put(letterInAlphabet, false);
		}
	}

	protected Map<Character, Boolean> getAlphabetLetterGuesssedMap() {
		return alphabetLetterGuesssedMap;
	}

	public boolean isLetterGuessed(char charToGuess) {
		return alphabetLetterGuesssedMap.get(charToGuess);
	}

	public void setGuessed(char letterToGuess) {
		alphabetLetterGuesssedMap.put(letterToGuess, true);
	}

}
