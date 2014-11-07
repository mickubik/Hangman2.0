package com.word;

public class GuessableChar {
	public char characterToGuess;
	private boolean guessed = false;
	
	public GuessableChar(char characterToGuess){
		this.characterToGuess = characterToGuess;
	}

	public char getChar(){
		return characterToGuess;
	}
	
	public boolean isGuessed(){
		return guessed;
	}

	public void setGuessed() {
		guessed = true;		
	}
}
