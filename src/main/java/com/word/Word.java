package com.word;

import java.util.LinkedList;
import java.util.List;

public class Word {
	//private Map<Character, Boolean> lhm = new LinkedHashMap<>();
	private List<GuessableChar> word = new LinkedList<>();

	public Word(String newWord){
		for (char ch: newWord.toCharArray()){

			word.add(new GuessableChar(ch));
		}	
	}

	public String getWord(){
		String wordToReturn = "";
		for ( GuessableChar guessableCharacter: word) {
			wordToReturn += guessableCharacter.characterToGuess;
		}
		return wordToReturn;
	}
}
