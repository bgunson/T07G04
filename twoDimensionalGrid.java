import java.util.*;
public class twoDimensionalGrid 
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
		
		for(int i = 0; i<columns; i++)
		{
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
	public void placeShip(int x, int y, int width, int height){
		
		// if placing out of grid
		if (( x + width > columns) || (y + height > rows)){ 
			System.out.println("invalid placement");
		}
		else{
			// check if ship already exists in spot
			boolean spaceAvailable = true;
			for(int i = x; i < (x+width); i++){
				for(int j = y; j < (y+height); j++){
					if (grid[i][j] != "O"){
						System.out.println("invalid placement");
						spaceAvailable = false;
					}
				}
			}
			
			// places the ship in spot
			if (spaceAvailable){
				for(int i = x; i < (x+width); i++){
					for(int j = y; j < (y+height); j++){
						grid[i][j] = "X";
					}
				}
			}
		}
	}
	
}
