package games.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * @author marco.mangan@gmail.com
 * 
 */
public class Play implements Runnable {

	private GameState state;
	private HangmanGame game;
	private Socket executioner;
	private PrintWriter executionerOut;
	private BufferedReader executionerIn;

	private Socket victim;

	public Play() {
		state = GameState.CREATED;
	}

	@Override
	public void run() {
		state = GameState.FINISHED;
	}

	public void setExecutioner(Socket executioner) {
		if (state != GameState.CREATED) {
			throw new IllegalStateException();
		}
		this.executioner = executioner;
		try {
			executionerOut = new PrintWriter(new OutputStreamWriter(
					executioner.getOutputStream()));
			executionerIn = new BufferedReader(new InputStreamReader(
					executioner.getInputStream()));
System.out.println(1);
			executionerOut.println("EXECUTIONER");
			executionerOut.flush();
System.out.println(2);
			String message = executionerIn.readLine();
			if (message.startsWith("WORD: ")) {
System.out.println(3);
				String word = message.split(":")[1];
				System.out.printf("[%s]",word);
				System.out.flush();
System.out.println(4);				
				game = new HangmanGame(word);
				state = GameState.WAITING;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setVictim(Socket secondSocket) {
		if (state != GameState.WAITING) {
			throw new IllegalStateException();
		}
		state = GameState.ONGOING;
		// TODO: send word to socket
		String word = game.getWord();
	}

}
