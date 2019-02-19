import java.util.*;
public class twoDimensionalGrid 
{
	int rows = 10;
	int columns = 10;
	String[][] grid = new String[columns][rows];

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
		
		for(int i = 0; i<rows; i++)
		{
			for(int j = 0; j<columns; j++)
			{
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
			}
		}
}