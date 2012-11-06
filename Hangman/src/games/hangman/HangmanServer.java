package games.hangman;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author marco.mangan@gmail.com
 * 
 */
public class HangmanServer {
	public static final int LISTENING_PORT = 2002;

	public static void main(String[] args) throws Exception {
		System.out.println("HangmanServer!");
		ServerSocket serverSocket = new ServerSocket(LISTENING_PORT);
		System.out.printf("HangmanServer started on %s:%d.\n", InetAddress
				.getLocalHost().getHostAddress(), LISTENING_PORT);
		while (!Thread.interrupted()) {
			Play p = new Play();		
			Socket firstSocket = serverSocket.accept();
			p.setExecutioner(firstSocket);
			System.out.printf("First player (Executor) is on! Waiting second player...\n");
			Socket secondSocket = serverSocket.accept();
			p.setVictim(secondSocket);
			System.out.printf("Second player (Victim) is on!\n");
			Thread t = new Thread(p);
			t.start();
			System.out.printf("Game started!\n");
		}
	}
}
