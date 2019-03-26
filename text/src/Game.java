import java.util.Scanner;
import java.util.ArrayList;

public class Game {

	public static void start(){

		System.out.println("Welcome to BattleShip Galactica!");

		// Stores location of ships and if ships are good/damaged/sunk
		Board playerOneShips = new Board();
		///Board playerTwoShips = new Board(); PLAYER 2 CODE
		Board aiShips = new Board();
		
		// Stores what the playwe knows about the opponents board
		Board playerOneHits = new Board();		
		///Board playerTwoHits = new Board(); PLAYER TWO CODE
		Board aiHits = new Board();
		
		System.out.println("Player 1 place ships");
		ShipTeam playerOneFleet = new ShipTeam("Player One Fleet");
		playerOneFleet.placeAllShips(playerOneShips);

		ShipTeam aiFleet = new ShipTeam("AI Fleet");
		AiPlayer Ai = new AiPlayer();
		System.out.println("AI has placed its ships...");
		Ai.shipPlacer(aiShips, aiFleet);
		
		/* TWO PLAYER CODE
		System.out.println("Player 2 place ships");
		ShipTeam playerTwoFleet = new ShipTeam("Player Two Fleet");
		playerTwoFleet.placeAllShips(playerTwoShips);
		*/
		
		
		int turnTracker = 1;
		//while((playerOneFleet.isEveryShipDestroyed() == false)&&(playerTwoFleet.isEveryShipDestroyed() == false)){ // PLAYER TWO CODE
		while((playerOneFleet.isEveryShipDestroyed() == false)&&(aiFleet.isEveryShipDestroyed() == false)){
			turnTracker++;
			if ( turnTracker%2 == 0 ){
				System.out.println("PLAYER 1 TURN");
				playTurn(playerOneShips, playerOneHits, aiShips, playerOneFleet, aiFleet);

				// playTurn(playerOneShips, playerOneHits, playerTwoShips, playerOneFleet, playerTwoFleet); // 
			}
			else{
				System.out.println("AI TURN");
				playAiTurn(aiShips, aiHits, playerOneShips, aiFleet, playerOneFleet);
			
				/* PLAYER TWO CODE
				System.out.println("PLAYER 2 TURN");
				playTurn(playerTwoShips, playerTwoHits, playerOneShips, playerTwoFleet, playerOneFleet);
				*/
			}
		}
	}

	/**
	 * This is what players use on their turn to shoot at the opponents ships, as well as see information like their
	 * ships and where they have shot the opponents side of the playing field.
	 */
	public static void playTurn(Board playerShips, Board playerHits, Board enemyShips, ShipTeam playerShipTeam, ShipTeam enemyShipTeam){
			
		playerShips.updateBoard(playerShipTeam);
		enemyShips.updateBoard(enemyShipTeam);
		
		System.out.println("Your Ships");
		playerShips.boardDisplay();
		System.out.println("Hit/Misses");
		playerHits.boardDisplay();
	
		System.out.println("Choose an (x,y) for your next shot: ");
		Scanner selection = new Scanner(System.in); 
		char xChar = selection.next().charAt(0);
		int x = (int)(xChar - 97);
		int y = selection.nextInt();
		
		boolean shot = enemyShips.shotFired(x,y);

		// Stores location on where the shot was fired and if it hit
		playerHits.placeShot(shot, x, y);

		if (shot == true){
			
			// If it hit, keep track of which ship it hit
			for ( Ship s : enemyShipTeam.getShips() ){
				s.checkHit( xChar+Integer.toString(y) ); 
			}
			System.out.println("Hit!");
		}
		else
			System.out.println("Miss!");
		
		// If the shot destroyed a ship, update the board to reflect that
	}
	
	/**
	 * playAiTurn what the computer opponent uses to shoot at enemy ships. Since the program uses objects that are
	 * instances in this class, it checks the results of what would happen to the grid, then does the changes
	 * within this class.
	 */
	public static void playAiTurn(Board playerShips, Board playerHits, Board enemyShips, ShipTeam playerShipTeam, ShipTeam enemyShipTeam){

		playerShips.updateBoard(playerShipTeam);
		enemyShips.updateBoard(enemyShipTeam);	
	
		System.out.println("Your Ships");
		playerShips.boardDisplay();
		System.out.println("Hit/Misses");
		playerHits.boardDisplay();

		AiPlayer Ai = new AiPlayer();
		Ai.turn(playerHits);
		int x = Ai.getCoordX();
		int y = Ai.getCoordY();

		boolean shot = enemyShips.shotFired(x, y);
		playerHits.placeShot(shot, x, y);
		
		if (shot == true){
			
			for ( Ship s : enemyShipTeam.getShips() ){
				s.checkHit( Integer.toString(x)+Integer.toString(y) ); 
			}
			
			System.out.println("Hit!");
		}
		else
			System.out.println("Miss!");	
	}
}




