package games.hangman;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author marco.mangan@gmail.com
 *
 */
public class HangmanClient {

	/**
	 * 
	 */
	public static final String SERVER_HOSTNAME = "localhost";
	
	/**
	 * 
	 */
	public static final int SERVER_PORT = 2002;

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("HangmanClient!");

		// define a palavra
		// observa tentativas do outro jogador

		// OU

		// recebe dica ------
		// tenta adivinhar palavra

		BufferedReader inFromServer = null;
		PrintWriter outToServer = null;

		Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
		inFromServer = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		outToServer = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		System.out.printf("Connected to server %s:%s.\n", SERVER_HOSTNAME,
				SERVER_PORT);
		String message = inFromServer.readLine();
		System.out.println(message);
		outToServer.println("WORD:HANGMAN");
		outToServer.flush();

	}
}
