package com.game;

import com.word.Word;

public class Game {
	private static final int DEFAULT_TRIES_REMAINING = 3;
	
	private int triesRemaining = DEFAULT_TRIES_REMAINING;
	private AlphabetLettersGuessed alphabetLettersGuessed = new AlphabetLettersGuessed();
	private Word wordToGuess;
	
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

	public void guessChar(Character letterInWordToGuess) {
		//TODO add more tests to complete this method.
		//TODO we will want some sort of validity check of guessing chars at some point. Likely here or AlphabetLettersGuessed. Probably the latter.
		//if (!alphabetLettersGuessed.isLetterGuessed(letterInWordToGuess)){
			wordToGuess.guessLetter(letterInWordToGuess);
		//}	
	}

}
