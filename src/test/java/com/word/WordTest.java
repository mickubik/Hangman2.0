package com.word;

import static org.junit.Assert.*;

import org.junit.Test;

import com.word.Word;


public class WordTest {

	@Test
	public void createWord() {
		String wordToGuess = "test";
		Word word = new Word("test");
		assertEquals(word.getWord(), wordToGuess);
	}

}
