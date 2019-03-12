import java.util.*;

public class Board
{
	private int rows = 10;
	private int columns = 10;
	public String[][] grid = new String[columns][rows];

	/*
	gridBuilder sets up the initial grid for use later on
	 */
	public void gridBuilder() 
	{
		for(int i = 0; i<rows; i++)
		    for(int j = 0; j<columns; j++)
		        grid[i][j] = "O";
	}
	
	/*
	gridDisplay prints out the 2d array in an easy to see format
	 */
	public void gridDisplay()
	{
		System.out.println("  A B C D E F G H I J");
		for(int i = 0; i<columns; i++)
		{
			System.out.print(i+" ");
			for(int j = 0; j<rows; j++)
			{
				System.out.print(grid[j][i]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	
	/*
	placeShip plcaes a ship of given width and height at given point
	params x and y are the top left x and y position of ship
	paras width, height are width and height of ship
	*/
	public boolean placeShip(int x, int y, int width, int height){
		
		// if placing out of grid
		if (( x + width > columns) || (y + height > rows)){ 
			// Bad placement.
			return false;
		}
		else{
			// check on if ship already exists in spot
			boolean spaceAvailable = true;
			for(int i = x; i < (x+width); i++){
				for(int j = y; j < (y+height); j++){
					if (grid[i][j] != "O"){
						spaceAvailable = false;
						return false;
					}
				}
			}

			
			// places the shpi in spot
			if (spaceAvailable){
				for(int i = x; i < (x+width); i++){
					for(int j = y; j < (y+height); j++){
						grid[i][j] = "X";
					}
				}
				// Good placement.
				return true;
			}
		}
		return false;
	}


	/**
	 * This method prompts the user to place a ship either vertically or horizontally at a specified keyboard
	 * location on the game grid.
	 * @param shipToPlace, the ship object of the particular ship being placed when called.
	 * @param shipNumber, the index + 1 of the ship thats being passed to differentiate each ship.
	 */
	public void promptToPlaceShip(Ship shipToPlace, String shipName){

		System.out.println("Choosing location for the " + shipName + "...");
		System.out.println(shipName + " specifications: ");
		System.out.println("LENGTH = " + shipToPlace.getShipLength() + " WIDTH = " + shipToPlace.getShipWidth());
		System.out.println("Horizontal [1] or Vertical [2] ?");
		Scanner keyboard = new Scanner(System.in);
		int orientation = keyboard.nextInt();

		boolean goodPlace = false;

		while (goodPlace == false){
			System.out.println("Enter the coordinates of the top left corner of the ship. Eg: a 4");
			Scanner selection = new Scanner(System.in);
			char xChar = selection.next().charAt(0);
			xChar -= 97;
			int x = (int)(xChar);
			int y = selection.nextInt();

			boolean wasGoodPlace = false;

			// If wanted vertical place ship (x, y, L, W).
			if (orientation == 1){
				wasGoodPlace = placeShip(x, y, shipToPlace.getShipLength(), shipToPlace.getShipWidth());
			}
			// Else vertical, place  ship (x, y, W, L).
			else{
				wasGoodPlace = placeShip(x, y, shipToPlace.getShipWidth(), shipToPlace.getShipLength());
			}

			// Check wasGoodPlace condition.
			if (wasGoodPlace == goodPlace){
				System.out.println("Sorry, that was not a valid placement. Try Again.");
				System.out.println("");
			}

			else{
				goodPlace = true;
			}
		}
	}

	/**
	 * shotFired takes an x,y position on the given grid (opponent) and checks if the shot was a hit or miss and
	 * changes the value at the given position based on what the outcome is.
	 * @param x, the x pos of the shot.
	 * @param y, the y pos of the shot.
	 * @return, true if the shot was a hit, false if not.
	 */
	public boolean shotFired(int x, int y){
		if (grid[x][y] == "X"){
			return true;
		}
		return false;
	}
	/*
	 * placeShot takes a true or false value, which is whether or not the shot is hitting anything, along with
	 * x and y position and changes the board based on that information
	 * @param hit, whether the shot hit or not
	 * @param x, the x pos of the shot
	 * @param y, the y pos of the shot
	 * */
	public void placeShot(boolean hit, int x, int y){
		if (hit == true)
			grid[x][y] = "H";
		else
			grid[x][y] = "M";
	}
	/**
	 * checkShot takes an x,y position on the given grid (opponent) and checks if the shot was a hit for the ai
	 * @param x, the x pos of the shot.
	 * @param y, the y pos of the shot.
	 * @return, true if the shot is going to hit an unmarked spot, false if not.
	 */
	public boolean checkShot(int x, int y){
		if (grid[x][y] == "O"){
			return true;
		}
		return false;
	}

}