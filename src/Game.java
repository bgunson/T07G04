import java.util.Scanner;
import java.util.ArrayList;

public class Game {

	public static void start(){

		System.out.println("Welcome to BattleShip Galactica!");

		// Create game board for player 1.
		Board playerOneShips = new Board();
		//playerOneShips.gridBuilder();
		Board playerOneHits = new Board();
		//playerOneHits.gridBuilder();

		Board playerTwoShips = new Board();
		//playerTwoShips.gridBuilder();
		Board playerTwoHits = new Board();
		//playerTwoHits.gridBuilder();		

		System.out.println("Player 1 place ships");
		ShipTeam playerOneFleet = new ShipTeam("Player One Fleet");
		playerOneFleet.placeAllShips(playerOneShips);

		System.out.println("Player 2 place ships");
		ShipTeam playerTwoFleet = new ShipTeam("Player Two Fleet");
		playerOneFleet.placeAllShips(playerTwoShips);


		
		int i = 1;
		while((playerOneFleet.isEveryShipDestroyed() == false)||(playerTwoFleet.isEveryShipDestroyed() == false)){

			i++;
			if ( i%2 == 0 ){
				System.out.println("PLAYER 1 TURN");
				playTurn(playerOneShips, playerOneHits, playerTwoShips);
			}
			else{
				System.out.println("PLAYER 2 TURN");
				playTurn(playerTwoShips, playerTwoHits, playerOneShips);
			}
		}
	}

	public static void playTurn(Board playerShips, Board playerHits, Board enemyShips){
			
		System.out.println("Your Ships");
		playerShips.boardDisplay();
		System.out.println("Hit/Misses");
		playerHits.boardDisplay();
	
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
}
