package logic;

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
    *	Sets up the initial grid
    */
    public Board(){ // just changed gridBuilder into this
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++)
                grid[i][j] = " ";
            }
    }
	
    /**
     * Temporary text display
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
     * placeShip places a ship of given width and height at given point
     * @params x and y are the top left x and y position of ship
     * @params width, height are width and height of ship
     */
    public boolean placeShip(int x, int y, int orientation, Ship ship){

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
     * shotFired takes an x,y position on the given grid (opponent) and checks if the shot was ahit or miss and
     * changes the value at the given position based on what the outcome is.
     * @param x, the x position of the shot.
     * @param y, the y position of the shot.
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
