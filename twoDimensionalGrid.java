import java.util.*;
public class twoDimensionalGrid 
{
	private final int rows = 10;
	private final int columns = 10;
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
        char columnLabel = 65; //Adds the column label from A to J
        for(int i = 0; i < columns; i++)
        {
            System.out.print("   ");
            System.out.print(columnLabel + "");
            columnLabel++;
        }
        System.out.println();

        int rowLabel = 0; //Adds the row label from 0 to 9
		for(int i = 0; i < columns; i++)
		{
            System.out.print(rowLabel + "  ");
			for(int j = 0; j< rows; j++)
			{
				System.out.print(grid[j][i]);
                System.out.print("   ");
			}
            System.out.println();
            rowLabel++;
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
			// check on if ship already exists in spot
			boolean spaceAvailable = true;
			for(int i = x; i < (x+width); i++){
				for(int j = y; j < (y+height); j++){
					if (grid[i][j] != "O"){
						System.out.println("invalid placement");
						spaceAvailable = false;
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
			}
		}
	}
}
