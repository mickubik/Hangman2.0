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
	
	public Word getWordToGuess(){
		return wordToGuess;
	}
	
	public int getTriesRemaining(){
		return triesRemaining;
	}

}
