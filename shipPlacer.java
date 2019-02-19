import java.util.*;

public class shipPlacer 
{
	private String[] ships = new String[5];
	twoDimensionalGrid twoDimensionalGrid = new twoDimensionalGrid();
	public void shipYard() 
	{
		ships[0] = "Carrier";
		ships[1] = "Battleship";
		ships[2] = "Cruiser";
		ships[3] = "Submarine";
		ships[4] = "Destroyer";
	}
	
	/*
	 With shipChoice the way it's set up is so that in the future when your able to correctly place ships down
	 it will then take that ship off the list by changing its name to "placed" until no ship is left
	 on the list. Every time the user enters a ship it goes into the setGrid method to up that specific
	 ship.
	 */
	public void shipChoice()
	{
		int count = 0;
		Scanner input = new Scanner(System.in);
		while(count < 5) 
		{
			System.out.println("Which Ship do you want to place:");
			for(int i = 0; i<5; i++) 
			{
				if(ships[i] != "placed")
					System.out.println(ships[i]);			
			}
			String ship = input.nextLine();
			twoDimensionalGrid.setGrid(ship);
			count++;
			
			
		}
	}

}
