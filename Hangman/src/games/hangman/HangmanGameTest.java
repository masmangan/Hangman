package games.hangman;

import static org.junit.Assert.*;

import org.junit.Test;

public class HangmanGameTest {

	@Test
	public void testSimpleWord() {
		HangmanGame game = new HangmanGame("hangman");
		String actual = game.getWord();
		String expected = "-------";
		assertEquals(expected, actual);		
	}

	@Test
	public void testSimpleMisses() {
		HangmanGame game = new HangmanGame("hangman");
		String actual = game.getMisses();
		String expected = "";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSimpleFirstTry() {
		HangmanGame game = new HangmanGame("hangman");
		boolean actual = game.tryGuess('E');
		boolean expected = false;
		assertEquals(expected, actual);
	}	
	
}
