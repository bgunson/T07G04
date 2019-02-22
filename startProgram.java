import java.util.Scanner;
import java.util.ArrayList;

public class startProgram {
	public static void main(String[] args) {
		
		//Runs the other class to build and display the 2d array
		twoDimensionalGrid testBoard = new twoDimensionalGrid();
		testBoard.gridBuilder();

		Ship largeShip = new Ship(4);
		Ship mediumShip = new Ship(3);
		Ship smallShip = new Ship(2);

		ArrayList<Ship> shipList = new ArrayList<Ship>();
		shipList.add(largeShip);
		shipList.add(mediumShip);
		shipList.add(smallShip);

		for (Ship ships : shipList){
			testBoard.gridDisplay();
			testBoard.promptToPlaceShip(ships, shipList.indexOf(ships) + 1);
			System.out.println("");

		}
		System.out.println("Ending test board: ");
		testBoard.gridDisplay();
		
		
	}
}
