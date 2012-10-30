package games.hangman;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
public class HangmanGame {
	private String secretWord;
	private String misses;
	private String word;

	/**
	 * 
	 * @param secretWord
	 */
	public HangmanGame(String secretWord) {
		this.secretWord = secretWord.toLowerCase();
		word = fillString(secretWord.length());
		misses = "";
	}

	/**
	 * 
	 * @return
	 */
	public String getWord() {
		return word;
	}

	private String fillString(int length) {
		String s = "";
		for (int i = 0; i < length; i++) {
			s += "-";
		}
		return s;
	}

	/**
	 * 
	 * @return
	 */
	public String getMisses() {
		return misses;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public boolean tryGuess(char c) {
		String guess = String.format("%c", c).toLowerCase();
		if (secretWord.contains(guess)) {
			word = replace(secretWord, word, guess);
			return true;
		}
		if (misses.isEmpty()) {
		misses += guess;
		} else {			
			misses += "," + guess;
		}
		
		return false;
	}

	private String replace(String s, String w, String g) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == g.charAt(0)) {
				result += s.charAt(i);
			} else {
				result += w.charAt(i);
			}
		}
		return result;
	}

	public boolean isEndOfGame() {
		return win() || lose();
	}

	public boolean lose() {
		return misses.length() >= 11;
		//1,2,3,4,5,6
		//12345678901
		//         11 
	}

	public boolean win() {
		return secretWord.equals(word);
	}

	/**
	 * 
	 * @return
	 */
	public String getSecretWord() {
		if (isEndOfGame()) {
			return secretWord;
		} else {
			return getWord();
		}
	}

}
