package games.hangman;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
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
	public void testSimpleFirstTryFalse() {
		HangmanGame game = new HangmanGame("hangman");
		boolean actual = game.tryGuess('e');
		boolean expected = false;
		assertEquals(expected, actual);
	}	

	@Test
	public void testSimpleFirstTryTrue() {
		HangmanGame game = new HangmanGame("hangman");
		boolean actual = game.tryGuess('h');
		boolean expected = true;
		assertEquals(expected, actual);
	}	

	@Test
	public void testSimpleFirstTryTrueUpperCase() {
		HangmanGame game = new HangmanGame("hangman");
		boolean actual = game.tryGuess('H');
		boolean expected = true;
		assertEquals(expected, actual);
	}	
	
	
	@Test
	public void testSimpleFirstTryMisses() {
		HangmanGame game = new HangmanGame("hangman");
		game.tryGuess('e');	
		String actual = game.getMisses();
		String expected = "e";
		assertEquals(expected, actual);
	}	
	
	@Test
	public void testSimpleFirstTryTrueMisses() {
		HangmanGame game = new HangmanGame("hangman");
		game.tryGuess('h');
		String actual = game.getMisses();
		String expected = "";
		assertEquals(expected, actual);
	}	

	@Test
	public void testSimpleUpdateWord() {
		HangmanGame game = new HangmanGame("java");
		game.tryGuess('a');	
		String actual = game.getWord();
		String expected = "-a-a";
		assertEquals(expected, actual);
	}	
	
}
