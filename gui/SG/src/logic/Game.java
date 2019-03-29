package logic;

public class Game {

    private Board playerOneShips = new Board(); // shows the player ships
    private Board aiShips = new Board(); // shows the ai ships
    private Board playerOneHits = new Board(); // shows the player hits
    private Board aiHits = new Board(); // shows the ai hits
    
    private ShipTeam playerOneFleet = new ShipTeam("Player One Fleet"); // stores the ships in player's fleet
    private ShipTeam aiFleet = new ShipTeam("AI Fleet"); // stoares the ships in ai's fleet
    
    private AiPlayer Ai = new AiPlayer(); // ai stuff
    private String aiLastShot;
    
    private int shipsPlaced = 0; // keeps track of which ship the player is on when placing
    private int orientation = 1; // keeps track of the orientation
    
    // sets up game object
    public Game(){
        Ai.shipPlacer(aiShips, aiFleet);
    }
    
    /**
     * @return player board
     */
    public Board getPlayerOneShips(){
        return playerOneShips;
    }
    
    /**
     * @return player shipTeam
     */    
    public ShipTeam getPlayerOneFleet(){
        return playerOneFleet;
    }
    
    /**
     * @return player one hits board
     */
    public Board getPlayerOneHits(){
        return playerOneHits;
    }
    
    public ShipTeam getAiFleet() {
    	return aiFleet;
    }
    
    /**
     * Constantly gets called by the buttons until all of the ships are placed
     * @params x, y are the x y of the button which got pressed
     */
    public void placeNextShip(int x, int y){
	
        Ship someShip = playerOneFleet.getShips().get(shipsPlaced);

        boolean a = playerOneShips.placeShip(x, y, orientation, someShip);
        if (a == true)
            shipsPlaced += 1;
    }
    
    /**
     * Switches the orientation of the ship
     */
    public void switchOrientation(){
        if(orientation == 1)
            orientation = 2;
        else
            orientation = 1;
    }
    
    /**
     * @return returns true if all ships are placed, false if there are ships not placed
     */
    public boolean allShipsPlaced(){
        if (shipsPlaced == playerOneFleet.getShips().size()){
            return true;
        }
        return false;
    }
    
    /**
     * Fires a shot at the coordinates below, then runs the AI's turn
     * @param x is the x of the button clicked
     * @param y is the y of the button clicked
     */
    public void playRound(int x, int y){
        System.out.println("Ai Ships, ai Hits:");
        aiShips.boardDisplay();
        aiHits.boardDisplay();
        
        playerTurn(x, y);
        aiTurn();
    }
    
    /**
     * Fires a shot at the coordinates below
     * @param x is the x of the button clicked
     * @param y is the y of the button clicked
     */
    public void playerTurn(int x, int y){
        playerOneShips.updateBoard(playerOneFleet);
	aiShips.updateBoard(aiFleet);
		
	System.out.println("Your Ships");
	playerOneShips.boardDisplay();
	System.out.println("Hit/Misses");
	playerOneHits.boardDisplay();        
        
    	boolean shot = aiShips.shotFired(x,y);
        playerOneHits.placeShot(shot, x, y);
        
        if (shot == true){
            // If it hit, keep track of which ship it hit
            for ( Ship s : aiFleet.getShips() ){
		s.checkHit( (char)(x+97)+Integer.toString(y) ); 
            }
            System.out.println("Player's shot Hit!");
	}
	else
            System.out.println("Player's shot Missed!");
    }

    public void aiTurn(){
     
        playerOneShips.updateBoard(playerOneFleet);
	aiShips.updateBoard(aiFleet);
	
	AiPlayer Ai = new AiPlayer();
	Ai.turn(aiHits);
	int x = Ai.getCoordX();
	int y = Ai.getCoordY();

	boolean shot = playerOneShips.shotFired(x, y);
	aiHits.placeShot(shot, x, y);
		
	if (shot){
            for ( Ship s : playerOneFleet.getShips() ){
                s.checkHit( (char)(x+97)+Integer.toString(y) ); 
            }	
            System.out.println("AI's shot Hit!");
            setAiLastShot(true);
	}
	else{
        System.out.println("AI's shot Missed!");
        setAiLastShot(false);

    }

    }

    public String getOrientation(){
        if (orientation == 1)
            return "HORIZONTAL";
        else
            return "VERTICAL";
    }

    public String getAiLastShot(){
        return aiLastShot;
    }

    public void setAiLastShot(boolean shot){
        if (shot)
            aiLastShot = "The AI hit your ship!";
        else
            aiLastShot = "The AI missed its shot!";
    }


}