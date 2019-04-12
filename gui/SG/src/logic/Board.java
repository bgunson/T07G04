package logic;

public abstract class Board {

    /**
     * " " = Empty
     * "G" = Ship part in good condition
     * "D" = Ship part is damaged
     * "F" = Ship has been destroyed
     */
    protected String[][] grid = new String[10][10];

    /**
     * Sets up the initial grid
     */
    protected Board(){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                grid[i][j] = " ";
            }
        }
    }
    
    /**
     * @return grid, returns the String[][] that stores grid information
     */
    public String[][] getGrid(){
        String[][] fGrid = new String[10][10];
            for(int i = 0; i<10; i++)
                for(int j = 0; j<10; j++)
                    fGrid[j][i] = grid[j][i];
        return fGrid;
    }
    
    /**
     * Text display in console for debugging
     */
    public void boardDisplay(){	
        System.out.println("  A B C D E F G H I J");
	for(int i = 0; i<10; i++)
	{
            System.out.print(i+" ");
            
            for(int j = 0; j<10; j++)
            {
                System.out.print(grid[j][i]);
                System.out.print(" ");
            }
        System.out.println();
	}
    }

    //public abstract void placeShip();
    
}