package games.hangman;

public class GameStateTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(GameState.CREATED);
		System.out.println(GameState.CREATED.name());
		System.out.println(GameState.CREATED.toString());
		System.out.println(GameState.valueOf("CREATED"));
		//System.out.println(GameState.valueOf("created"));
		//System.out.println(GameState.valueOf("GameState.CREATED"));
		//System.out.println(GameState.valueOf("GameState.created"));
	}

}
