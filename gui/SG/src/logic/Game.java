package logic;

import Audio.AudioController;
import drivers.BattleshipGalactica;

public class Game {

    private ShipsBoard playerShips = new ShipsBoard();
    private ShipsBoard aiShips = new ShipsBoard();
    private HitsBoard playerHits = new HitsBoard();
    private HitsBoard aiHits = new HitsBoard();
    
    private ShipTeam playerFleet = new ShipTeam("Player One Fleet"); // stores the ships in player's fleet
    private ShipTeam aiFleet = new ShipTeam("AI Fleet"); // stoares the ships in ai's fleet
    
    private AiPlayer Ai = new AiPlayer(); // ai stuff
    private String aiLastShot;
    
    private AudioController backgroundMusic1 = new AudioController(BattleshipGalactica.class.getResource("/Resources/Audio/spiderman.mp3").toExternalForm());
    private AudioController shotFired = new AudioController(BattleshipGalactica.class.getResource("/Resources/Audio/shotfired.wav").toExternalForm());
    private AudioController shotFiredEnemy = new AudioController(BattleshipGalactica.class.getResource("/Resources/Audio/shotfiredenemy.wav").toExternalForm());
    
    private int shipsPlaced = 0; // Keeps track of which ship the player is on when placing
    private int orientation = 1; // Keeps track of the orientation currently selected
    
    private String goodPlace;

    /**
     * Sets up the game object
     */
    public Game(){
        Ai.shipPlacer(aiShips, aiFleet);
    }
      /**
     * When this is called  it will start playing the background music
     */
    public void startMusic() 
    {
    	backgroundMusic1.stop();
    	backgroundMusic1.playSong();
    }
    
    /**
     * @return player board
     */
    public ShipsBoard getPlayerShips(){
        return playerShips;
    }
    
    /**
     * @return player one hits board
     */
    public HitsBoard getPlayerHits(){
        return playerHits;
    }
    
    /**
     * @return player shipTeam
     */    
    public ShipTeam getPlayerFleet(){
        return playerFleet;
    }
    
    public ShipTeam getAiFleet() {
    	return aiFleet;
    }
    
    /**
     * 
     * @param x - Top left x position of ship
     * @param y - Top left y position of ship
     */
    public void placeNextShip(int x, int y){
	
        Ship someShip = playerFleet.getShips().get(shipsPlaced);

        boolean a = playerShips.placeShip(x, y, orientation, someShip);
        if (a == true){
            shipsPlaced += 1;
            setGoodPlace(true);
        }
        else
            setGoodPlace(false);
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
        if (shipsPlaced == playerFleet.getShips().size()){
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
                
        boolean valid = playerHits.checkShot(x, y);
        
        if (valid == true){
            playerTurn(x, y);
            aiTurn();
        }
    }
    
    /**
     * Fires a shot at the coordinates below
     * @param x is the x of the button clicked
     * @param y is the y of the button clicked
     */
    public void playerTurn(int x, int y){
        playerShips.updateBoard(playerFleet);
	aiShips.updateBoard(aiFleet);
	
	System.out.println("Your Ships");
	playerShips.boardDisplay();
	System.out.println("Hit/Misses");
	playerHits.boardDisplay();        
        
    	boolean shot = aiShips.shotFired(x,y);
        playerHits.placeShot(shot, x, y);
        
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

	    /**
     * When it's the ai's turn to play this method is run
     */
    public void aiTurn(){
     
        playerShips.updateBoard(playerFleet);
	aiShips.updateBoard(aiFleet);
	
	AiPlayer Ai = new AiPlayer();
	Ai.turn(aiHits);
	int x = Ai.getCoordX();
	int y = Ai.getCoordY();
	AiPlayer.lastTurnX = x;
	AiPlayer.lastTurnY = y;
	
	boolean shot = playerShips.shotFired(x, y);
	aiHits.placeShot(shot, x, y);
	
	shotFiredEnemy.playEffect();
	if (shot){
            for ( Ship s : playerFleet.getShips() ){
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

     /**
     *  This is used for the gui to display whether you are placing vertically or horizonally for the ships
     */
    public String getOrientation(){
        if (orientation == 1)
            return "HORIZONTAL";
        else
            return "VERTICAL";
    }
    
    public String getAiLastShot(){
        return aiLastShot;
    }
        /**
     *  The ai's last shot is recorded
     */
    public void setAiLastShot(boolean shot){
        if (shot) {
            aiLastShot = "The AI hit your ship!";
        	
        	}
        else {
            aiLastShot = "The AI missed its shot!";
            
        }
    }

      /**
     * returns good place
     */
    public String getGoodPlace(){
        return goodPlace;
    }
     /**
     * sets good place
     */
    public void setGoodPlace(boolean good){
        if (good)
            goodPlace = null;
        else
            goodPlace = "That was an invalid ship placement. Please try again.";
    }
    
}
