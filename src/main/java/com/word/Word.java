package com.word;

import java.util.LinkedList;
import java.util.List;

public class Word {
	private List<GuessableChar> word = new LinkedList<>();

	public Word(String newWord){
		for (char ch: newWord.toCharArray()){
			word.add(new GuessableChar(ch));
		}	
	}

	public String getWordAsString(){
		String wordToReturn = "";
		for (GuessableChar guessableCharacter: word) {
			wordToReturn += guessableCharacter.characterToGuess;
		}
		return wordToReturn;
	}
	
	public List<GuessableChar> getWord(){
		return word;
	}
	
	public void guessLetter(char charToGuess){
		for (GuessableChar guessableCharacter: word) {
			if (guessableCharacter.getChar() == charToGuess){
				guessableCharacter.setGuessed();
			}
		}
	}
}
