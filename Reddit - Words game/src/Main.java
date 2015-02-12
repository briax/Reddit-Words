public class Main {
	public static void main(String[] args) {
		
		Player player1 = new PlayerImpl();
		Game game = new GameImpl(player1);
		
		
		
		//game.welcomeMessage();
		
		game.assignLettersToPlayer();
		
		player1.getLetters();
		
		game.checkPlayersString();
	}
}
