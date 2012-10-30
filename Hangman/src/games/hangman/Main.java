package games.hangman;

import java.util.Scanner;

/**
 * http://en.wikipedia.org/wiki/Hangman_%28game%29
 * 
 * @author marco.mangan@gmail.com
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hangman!");
		Scanner teclado = new Scanner(System.in);
		System.out.printf("Secret Word:");
		String segredo = teclado.next();
		
		HangmanGame game = new HangmanGame(segredo);

		while (!game.isEndOfGame()) {
			System.out.printf("Word: %s\n", game.getWord());
			System.out.printf("Guess: ");
			String entrada = teclado.next();
			char letra = entrada.charAt(0);
			game.tryGuess(letra);
			System.out.printf("Misses: %s\n", game.getMisses());
		}
		
		if (game.win()) {
			System.out.println("Parabéns!");
			System.out.printf("A palavra é: %s!", game.getSecretWord());
		}
		if (game.lose()) {
			System.out.println("Que pena!");
			System.out.printf("A palavra é: %s!", game.getSecretWord());			
		}

	}

}
