import java.util.*;

public class Board {
	private int rows = 10;
	private int columns = 10;
	
	public String[][] grid = new String[columns][rows];
	/*
	 * " "  = empty
	 * "G" = ship part in good condition
	 * "D" = ship part is damaged
	 * "F" = Ship destroyed
	 */
	
	/**
	*	Sets up the inital grid
	*/
	public Board(){ // just changed gridBuilder into this
		for(int i = 0; i<rows; i++){
		    for(int j = 0; j<columns; j++)
		        grid[i][j] = " ";
		}
	}
	
	/**
		Temporary text display
	*/
	public void boardDisplay(){
		
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
			
	/**
		placeShip places a ship of given width and height at given point
		params x and y are the top left x and y position of ship
		paras width, height are width and height of ship
	*/
	public boolean placeShip(int x, int y, Ship ship, int orientation){

		int length = ship.shipLength;
		int height, width;
		if (orientation == 1){ // 1 = horizontal, 2 = vertical
			width = length;
			height = 1;
		}
		else{
			width = 1;
			height = length;			
		}
		
		// if placing out of grid
		if (( x + width > columns) || (y + height > rows)){ 
			System.out.println("out of grid");
			// Bad placement.
			return false;
		}
		else{
			// check on if ship already exists in spot
			boolean spaceAvailable = true;
			for(int i = x; i < (x+width); i++){
				for(int j = y; j < (y+height); j++){
					if (grid[i][j] != " "){
						spaceAvailable = false;
						return false;
					}
				}
			}			
			// places the ship in spot
			if (spaceAvailable){
				
				ArrayList<String> coordinates = new ArrayList<String>(); // stores what the coordinates of the ship will be

				for(int i = x; i < (x+width); i++){
					for(int j = y; j < (y+height); j++){
						grid[i][j] = "G";
						coordinates.add( Character.toString((char)(i+97))+Integer.toString(j) ); // stores as "letternumber" ex: A1
					}
				}
				ship.setCoordinates(coordinates); // updates the ships coordinates onces it's been places
				return true; // Good placemnet.
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
		System.out.println("LENGTH = " + shipToPlace.shipLength);
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
				wasGoodPlace = placeShip(x, y, shipToPlace, 1);
			}
			// Else vertical, place ship (x, y, W, L).
			else{
				wasGoodPlace = placeShip(x, y, shipToPlace, 2);
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
	 * shotFired takes an x,y position on the given grid (opponent) and checks if the shot was ahit or miss and
	 * changes the value at the given position based on what the outcome is.
	 * @param x, the x pos of the shot.
	 * @param y, the y pos of the shot.
	 * @return, true if the shot was a hit, false if not.
	 */
	public boolean shotFired(int x, int y){
		if (grid[x][y] == "G"){
			return true;
		}
		return false;
	}
	
	/**
	 * placeShot takes a true or false value, which is whether or not the shot is hitting anything, along with
	 * x and y position and changes the board based on that information
	 * @param hit, whether the shot hit or not
	 * @param x, the x pos of the shot
	 * @param y, the y pos of the shot
	 */
	public void placeShot(boolean hit, int x, int y){
		if (hit == true)
			grid[x][y] = "H";
		else
			grid[x][y] = "M";
	}
	
	/**
	* Updates damaged tiles on ships and sunk ships
	* @param shipTeam is the ships that you are checking
	*/
	public void updateBoard(ShipTeam shipTeam){

		ArrayList<Ship> fleet = shipTeam.getShips();
		
		for ( Ship ship : fleet ){
			for ( String destroyedTile : ship.getDestroyed() ){
				grid[(int)(destroyedTile.charAt(0) - 97)][Integer.valueOf(destroyedTile.substring(1,2))] = "D";
			}
		}
	
		for ( Ship ship : fleet ){
			if (ship.sunk == true){
				for ( String coordinate : ship.getCoordinates() ){
					grid[(int)(coordinate.charAt(0) - 97)][Integer.valueOf(coordinate.substring(1,2))] = "F";
				}
			}
		}
	}

	/**
	 * checkShot takes an x,y position on the given grid (opponent) and checks if the shot was a hit for the ai
	 * @param x, the x pos of the shot.
	 * @param y, the y pos of the shot.
	 * @return, true if the shot is going to hit an unmarked spot, false if not.
	 */
	public boolean checkShot(int x, int y){
		if (grid[x][y] == " "){
			return true;
		}
		return false;
	}
	
}
