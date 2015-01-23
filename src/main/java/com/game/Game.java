package com.game;

import com.word.Word;

public class Game {
	private static final int DEFAULT_TRIES_REMAINING = 3;

	private int triesRemaining = DEFAULT_TRIES_REMAINING;
	private final AlphabetLettersGuessed alphabetLettersGuessed = new AlphabetLettersGuessed();
	private final Word wordToGuess;

	public Game(){
		wordToGuess = new Word("test");

	}

	public Game(String newWordToGuess){
		wordToGuess = new Word(newWordToGuess);
	}

	public Word getWordToGuess(){
		return wordToGuess;
	}

	public int getTriesRemaining(){
		return triesRemaining;
	}

	public Object getWordGuessingDisplayForm() {
		return wordToGuess.getGuessingDisplayForm();
	}

	public void guessChar(Character charToGuess) {
		charToGuess = Character.toUpperCase(charToGuess);

		if (canCharBeGuessed(charToGuess)) {
			alphabetLettersGuessed.setGuessed(charToGuess);

			final Word wordToGuessBeforeGuess = wordToGuess;
			wordToGuess.guessLetter(charToGuess);
			if (wordToGuessBeforeGuess == wordToGuess) {
				triesRemaining--;
			}
		}
	}

	public boolean canCharBeGuessed(Character charToGuess) {
		if (!Character.isLetter(charToGuess)){
			System.out.println(i18n.I18n.INVALID_INPUT_MESSAGE);
			return false;
		}

		if (alphabetLettersGuessed.isLetterGuessed(charToGuess)){
			System.out.println(i18n.I18n.LETTER_ALREADY_GUESSED);
			return false;
		}
		return true;
	}


}
