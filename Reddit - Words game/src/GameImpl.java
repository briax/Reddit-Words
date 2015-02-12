import java.util.Random;
import java.util.Scanner;

public class GameImpl implements Game {
	
	private Scanner scanner;
	private Player player;
	private StringBuilder sb;
	
	public GameImpl(Player player) {
		this.player = player;
	}

	@Override
	public void assignLettersToPlayer() {
		Random random = new Random();
		char[] letters = new char[10];

		for(int i = 0; i < 10; i++){
			char c = (char)(random.nextInt(26) + 'a');
			letters[i] = c;
		}
		player.addLetters(letters);
	}

	@Override
	public void checkPlayersString() {	
		sb = new StringBuilder();
		scanner = new Scanner(System.in);
		System.out.print("Your word --> ");
		String word = scanner.nextLine();
				
		char[] lettersFromWord = word.toCharArray();
		char[] lettersFromPlayer = player.arrayLetters();
		
		for(int i = 0; i < lettersFromWord.length; i++){
			for(int j = 0; j < lettersFromPlayer.length; j++){
				if(lettersFromPlayer[j] == lettersFromWord[i]){
					sb.append(lettersFromPlayer[j]);
					lettersFromPlayer[j] = 'X';
					break;
				}
			}
		}
		
		System.out.println(sb);
		
		if(!sb.toString().equalsIgnoreCase(word)){
			System.out.println("I am sorry but you cannot spell " + word + " with your letters.");
		}
	}

	@Override
	public void welcomeMessage() {
		scanner = new Scanner(System.in);
		System.out.println("Welcome to Words with enemies!");
		System.out.println("Select an AI difficulty: ");
		System.out.println("1) Easy");
		System.out.print("--> ");
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			System.out.println("You've selected Easy! - Lets begin!");
			break;
		default:
			System.out.println("Please select a viable choice - run the program again.");
			break;
		}
	}
	
	// Not really needed..
	@Override
	public void clearPlayersLetters() {
		char[] emptyArray = {};
		player.addLetters(emptyArray);
	}
}
