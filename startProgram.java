import java.util.Scanner;
import java.util.ArrayList;

public class startProgram {

	public static void main(String[] args){

		System.out.println("Welcome to BattleShip Galactica!");

		// Create game board for player 1.
		twoDimensionalGrid playerOneGrid = new twoDimensionalGrid();
		playerOneGrid.gridBuilder();

		// Create ship fleet for player 1.
		ShipTeam playerOneShips = new ShipTeam("Player One Fleet");

		// Prompt player one to select locations for all their ships
		playerOneShips.placeAllShips(playerOneGrid);

		// Main game loop, one player game shooting at your own board.
		while (playerOneShips.isEveryShipDestroyed() == false){
			System.out.println("");
			playerOneGrid.gridDisplay();
			System.out.println("Choose an (x,y) for your next shot: ");
			// Needs to check if input is an actual coord on the grid.
			Scanner selection = new Scanner(System.in);
			char xChar = selection.next().charAt(0);
			xChar -= 97;
			int x = (int)(xChar);
			int y = selection.nextInt();

			boolean shot = playerOneGrid.shotFired(x, y);
			if (shot == true){
				System.out.println("Good Hit!");
				playerOneShips.goodHit();
			}
			else{
				System.out.println("Miss!");
			}



		}
		System.out.println("GAME OVER!");



	}

}
