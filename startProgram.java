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

		playerOneGrid.gridDisplay();

		// Now repeat for computer(auto place)/player 2 and start game.



	}

}
