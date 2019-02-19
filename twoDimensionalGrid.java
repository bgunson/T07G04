import java.util.*;
public class twoDimensionalGrid 
{
	Scanner input = new Scanner(System.in);
	int rows = 11;
	int columns = 11;
	String[][] grid = new String[columns][rows];

	/*
	gridBuilder sets up the initial grid for use later on
	 */
	public void gridBuilder() 
	{
		for(int i = 0; i<rows; i++)
		    for(int j = 0; j<columns; j++)
		        grid[i][j] = "O";
		for(int i = 0; i<rows; i++)
		{
			grid[i][0] = (String.valueOf(i));
		}
		for(int i = 0; i<rows; i++)
		{
			grid[0][i] = (String.valueOf(i));
		}
	}
	
	/*
	gridDisplay prints out the 2d array in an easy to see format.
	Now also includes numbering for the grid
	 */
	public void gridDisplay()
	{
		
		for(int i = 0; i<rows; i++)
		{
			for(int j = 0; j<columns; j++)
			{
				if(i == 10 && j == 1) 
				{
					System.out.print(" ");
					System.out.print(grid[i][j]);
				}
				else  
				{
					if(j == 1) 
					{
						System.out.print("  ");
						System.out.print(grid[i][j]);
					}
					else 
					{
						System.out.print(" ");
						System.out.print(grid[i][j]);
					}
					}
				
			}
			System.out.println();
			}
	}
	
	public String[][] getGrid()
	{
		return grid;
	}
	/*
	 setGrid takes in the users shipChoice from shipPlacer and gives it a length
	 so they can place it within the grid correctly. Right now the input for where
	 the user wants to place it is able to take 2 integers that are in the same line
	 such as 1 3.
    */
	public void setGrid(String ship)
	{
		int length = 0;
		boolean checker = true;
		int[] coords = new int[2]; 
		
		if(ship.equals("Carrier"))
		{
			length = 5;
		}
		if(ship.equals("Battleship"))
		{
			length = 4;
		}
		if(ship.equals("Cruiser"))
		{
			length = 3;
		}
		if(ship.equals("Submarine"))
		{
			length = 3;
		}
		if(ship.equals("Destroyer"))
		{
			length = 2;
		}
		
		
		//length is also a check for if a proper choice was typed
		if(length > 0)
		{
			gridBuilder();
			gridDisplay();
			
			System.out.println("Where would you like to place the " + ship);
			
			//Uses a while statement so it will loop until the ship is correctly placed
			while(checker == true) 
			{
				for (int i = 0; i < coords.length; i++) 
			{
			        coords[i] = (input.hasNext() == true ? input.nextInt():null);
		    }
				
				if(coords[0] <= 10 && coords[1] <= 10 && coords[0] >= 0 && coords[1] >= 0)
				{
				System.out.println("If both coords pass then it goes to placing the ship");
				}
			
			}
	}
}
}