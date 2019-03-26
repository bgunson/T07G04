package logic;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    Board playerOneShips;
    Board aiShips;
    Board playerOneHits;
    Board aiHits;
    ShipTeam playerOneFleet = new ShipTeam("Player One Fleet");
    ShipTeam aiFleet = new ShipTeam("AI Fleet");
    AiPlayer Ai = new AiPlayer();
    public int shipsPlaced = 0;
    private int orientation = 1;
    
    public Game(){
        Board playerOneShips = new Board();
        this.playerOneShips = playerOneShips;
        
        Board aiShips = new Board();
        this.aiShips = aiShips;
	
        Board playerOneHits = new Board();		
        this.playerOneHits = playerOneHits;

	Board aiHits = new Board();
        this.aiHits = aiHits;
        
        Ai.shipPlacer(aiShips, aiFleet);
    }
    
    public Board getPlayerOneShips(){
        return playerOneShips;
    }
    
    public ShipTeam getPlayerOneFleet(){
        return playerOneFleet;
    }
    
    public Board getPlayerOneHits(){
        return playerOneHits;
    }
    
    // Constantly gets called by the buttons until all of the ships are placed
    public void placeNextShip(int x, int y){
	
        Ship someShip = playerOneFleet.getShips().get(shipsPlaced);

        boolean a = playerOneShips.placeShip(x, y, orientation, someShip);
        if (a == true)
            shipsPlaced += 1;
    }
    
    public void switchOrientation(){
        if(orientation == 1)
            orientation = 2;
        else
            orientation = 1;
    }
    
    public boolean allShipsPlaced(){
        if (shipsPlaced == playerOneFleet.getShips().size()){
            return true;
        }
        return false;
    }
    

    /**
     * This is what players use on their turn to shoot at the opponents ships, as well as see information like their
     * ships and where they have shot the opponents side of the playing field.
     */
    public static void playTurn(Board playerShips, Board playerHits, Board enemyShips, ShipTeam playerShipTeam, ShipTeam enemyShipTeam){
			
	playerShips.updateBoard(playerShipTeam);
	enemyShips.updateBoard(enemyShipTeam);
		
	System.out.println("Your Ships");
	playerShips.boardDisplay();
	System.out.println("Hit/Misses");
	playerHits.boardDisplay();
	
		System.out.println("Choose an (x,y) for your next shot: ");
		Scanner selection = new Scanner(System.in); 
		char xChar = selection.next().charAt(0);
		int x = (int)(xChar - 97);
		int y = selection.nextInt();
		
		boolean shot = enemyShips.shotFired(x,y);

		// Stores location on where the shot was fired and if it hit
		playerHits.placeShot(shot, x, y);

		if (shot == true){
			
			// If it hit, keep track of which ship it hit
			for ( Ship s : enemyShipTeam.getShips() ){
				s.checkHit( xChar+Integer.toString(y) ); 
			}
			System.out.println("Hit!");
		}
		else
			System.out.println("Miss!");
		
		// If the shot destroyed a ship, update the board to reflect that
	}
	
	/**
	 * playAiTurn what the computer opponent uses to shoot at enemy ships. Since the program uses objects that are
	 * instances in this class, it checks the results of what would happen to the grid, then does the changes
	 * within this class.
	 */
	public static void playAiTurn(Board playerShips, Board playerHits, Board enemyShips, ShipTeam playerShipTeam, ShipTeam enemyShipTeam){

		playerShips.updateBoard(playerShipTeam);
		enemyShips.updateBoard(enemyShipTeam);	
	
		System.out.println("Your Ships");
		playerShips.boardDisplay();
		System.out.println("Hit/Misses");
		playerHits.boardDisplay();

		AiPlayer Ai = new AiPlayer();
		Ai.turn(playerHits);
		int x = Ai.getCoordX();
		int y = Ai.getCoordY();

		boolean shot = enemyShips.shotFired(x, y);
		playerHits.placeShot(shot, x, y);
		
		if (shot == true){
			
			for ( Ship s : enemyShipTeam.getShips() ){
				s.checkHit( Integer.toString(x)+Integer.toString(y) ); 
			}
			
			System.out.println("Hit!");
		}
		else
			System.out.println("Miss!");	
	}
}