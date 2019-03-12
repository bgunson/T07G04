import java.util.Scanner;
import java.util.ArrayList;

public class Game {

	public static void start(){

		System.out.println("Welcome to BattleShip Galactica!");

		// Create game board for player 1.
		Board playerOneShips = new Board();
		playerOneShips.gridBuilder();
		Board playerOneHits = new Board();
		playerOneHits.gridBuilder();

		Board aiShips = new Board();
		aiShips.gridBuilder();
		Board aiHits = new Board();
		aiHits.gridBuilder();

		System.out.println("Player 1 place ships");
		ShipTeam playerOneFleet = new ShipTeam("Player One Fleet");
		playerOneFleet.placeAllShips(playerOneShips);

		ShipTeam aiFleet = new ShipTeam("AI Fleet");;

		AiPlayer Ai = new AiPlayer();
		System.out.println("AI has placed its ships...");
		Ai.shipPlacer(aiShips, aiFleet);

		
		int i = 1;
		while((playerOneFleet.isEveryShipDestroyed() == false)||(aiFleet.isEveryShipDestroyed() == false)){

			i++;
			if ( i%2 == 0 ){
				System.out.println("PLAYER 1 TURN");
				playTurn(playerOneShips, playerOneHits, aiShips);
			}
			else{
				System.out.println("PLAYER 2 TURN");
				//playTurn(aiShips, aiHits, playerOneShips);
				playAiTurn(aiShips, aiHits, playerOneShips);
			}
		}
		if(playerOneFleet.isEveryShipDestroyed() == true) {
			System.out.println("PLAYER 2 WINS!");
		}
		else {
			System.out.println("PLAYER 1 WINS!");
		}
	}
	/**
	 * This is what players use on their turn to shoot at the opponents ships, as well as see information like their
	 * ships and where they have shot the opponents side of the playing field.
	 */
	public static void playTurn(Board playerShips, Board playerHits, Board enemyShips){
			
		System.out.println("Your Ships");
		playerShips.gridDisplay();
		System.out.println("Hit/Misses");
		playerHits.gridDisplay();
	
		System.out.println("Choose an (x,y) for your next shot: ");
		// Needs to check if input is an actual coord on the grid.
		Scanner selection = new Scanner(System.in);

		char xChar = selection.next().charAt(0);
		xChar -= 97;
		int x = (int)(xChar);
		int y = selection.nextInt();

		boolean shot = enemyShips.shotFired(x, y);
		playerHits.placeShot(shot, x, y);
		
		if (shot == true){
			enemyShips.placeShot(shot, x, y);
			System.out.println("Hit!");
		}
		else
			System.out.println("Miss!");
		
	}
	/**
	 * playAiTurn what the computer opponent uses to shoot at enemy ships. Since the program uses objects that are
	 * instances in this class, it checks the results of what would happen to the grid, then does the changes
	 * within this class.
	 */
	public static void playAiTurn(Board playerShips, Board playerHits, Board enemyShips){
		
		System.out.println("Your Ships");
		playerShips.gridDisplay();
		System.out.println("Hit/Misses");
		playerHits.gridDisplay();
	

		AiPlayer Ai = new AiPlayer();
		Ai.turn(playerHits);
		int x = Ai.getCoordX();
		int y = Ai.getCoordY();

		boolean shot = enemyShips.shotFired(x, y);
		playerHits.placeShot(shot, x, y);
		
		if (shot == true){
			enemyShips.placeShot(shot, x, y);
			System.out.println("Hit!");
		}
		else
			System.out.println("Miss!");
		
	}
}
