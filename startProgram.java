import java.util.Scanner;
import java.util.ArrayList;

public class startProgram {
	public static void main(String[] args) {
		
		//Runs the other class to build and display the 2d array
		twoDimensionalGrid testBoard = new twoDimensionalGrid();
		testBoard.gridBuilder();

		Ship largeShip = new Ship(4, 1);
		Ship mediumShip = new Ship(3, 1);
		Ship smallShip = new Ship(2, 1);

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
		
		/* if you wanna test the method for yourself
		Scanner reader = new Scanner(System.in);
		for(int q = 2; q>0; q--){
			System.out.println("\n");
			
			System.out.println("input back to back in this order: x, y, width, height");
			int x = reader.nextInt();
			int y = reader.nextInt();
			int w = reader.nextInt();
			int h = reader.nextInt();
			
			twoDimensionalGrid.placeShip(x, y, w, h); 
			twoDimensionalGrid.gridDisplay();
		}
		*/
	}
}
