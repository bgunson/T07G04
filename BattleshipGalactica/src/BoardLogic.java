/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipgalactica;
import java.util.*;

public class BoardLogic
{
	private final int rows = 10;
	private final int columns = 10;
	
	public String[][] grid = new String[columns][rows];
	/* Maybe something like this?
	 * " "  = empty
	 * "G" = ship part in good condition
	 * "D" = ship part is damaged
	 * "F" = Ship destroyed
	 */
	
	// Creates and fills out the empty board
	public BoardLogic(){ // just changed gridBuilder into this
		for(int i = 0; i<rows; i++){
		    for(int j = 0; j<columns; j++)
		        grid[i][j] = " ";
		}
	}
	
	// temp will replace with GUI
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
	
	
	/*
	On the map, ships that sink will be a different color so this changes
	it from being a bunch of destroyed parts to sunken parts
	["D","D","G"] --> gets hit --> ["D","D","D"] --> ["F","F","F"]	
	*/
	public void updateDestroyedShips( ShipTeam shipTeam ){
		
		ArrayList<Ship> fleet = shipTeam.getShips();
		
		for ( Ship s : fleet ){
			if (s.sunk == true){
				for ( String a : s.getCoordinates() ){
					grid[(int)a.charAt(0) - 97][(int)a.charAt(1) - 97] = "F"; // haven't tested if works
				}
			}
		}
	}
		
	/*
	placeShip places a ship of given width and height at given point
	params x and y are the top left x and y position of ship
	paras width, height are width and height of ship
	*/
	public boolean placeShip(int x, int y, int length, int orientation){
		/*
			Also once placed: ship.placedShip( String[] wherePlaced )
		*/
		int height, width;
		// 1 = horizontal, 2 = vertical
		if (orientation == 1){
			width = length;
			height = 1;
		}
		else{
			width = 1;
			height = length;			
		}
		
		// if placing out of grid
		if (( x + width > columns) || (y + height > rows)){ 
			//System.out.println("out of grid");
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
				for(int i = x; i < (x+width); i++){
					for(int j = y; j < (y+height); j++){
						grid[i][j] = "G";
					}
				}
				// Good placemnet.
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
				wasGoodPlace = placeShip(x, y, shipToPlace.shipLength, 1);
			}
			// Else vertical, place ship (x, y, W, L).
			else{
				wasGoodPlace = placeShip(x, y, shipToPlace.shipLength, 2);
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
	
	public void placeShot(boolean hit, int x, int y){
		if (hit == true)
			grid[x][y] = "H";
		// update Ship that got hit
		else
			grid[x][y] = "M";
	}
	
	
	
	/*
		Ignore, idk probs won't use
		
		
		
		Updates the board based on the coordinates and destroyed arrays
		for each ship in ShipTeam
	
	public void updateBoard(ShipTeam shipTeam){
		
		ArrayList<Ship> fleet = shipTeam.getShips();
		
		for (Ship ship : fleet){
			String[] coordinates = ship.getCoordinates();
				
			// if ship sunk
			if (ship.sunk == true){
				for (String coordinate : coordinates)
						grid[(int)(coordinate.substring(0,1) -= 97)][coordinate.substring(1,2)] = "F";
			}
			// if ship still alive	
			else{
				for (String coordinate : coordinates)
						grid[(int)(String.valueOf(coordinate.substring(0,1) -= 97))][String.parseInt(coordinate.substring(1,2))] = "G";
				String[] destroyed = ship.getDestroyed();			
				for (String destroyedTile : destroyed)
					grid[destroyedTile.substring(0,1)) -= 97][Integer.parseInt(destroyedTile.substring(1,2))] = "D";				
			// char c=s.charAt(0)
			}
		}
			
	}
	*/

}
