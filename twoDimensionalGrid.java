import java.util.*;
public class twoDimensionalGrid 
{
	int rows = 10;
	int columns = 10;
	
	String[][] grid = new String[columns][rows];

	public void gridBuilder() {
		
		
		for(int i = 0; i<rows; i++)
		    for(int j = 0; j<columns; j++)
		        grid[i][j] = "O";
		
		
		
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