package logic;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    Board playerOneShips = new Board();
    Board aiShips = new Board();
    Board playerOneHits = new Board();
    Board aiHits = new Board();
    
    ShipTeam playerOneFleet = new ShipTeam("Player One Fleet");
    ShipTeam aiFleet = new ShipTeam("AI Fleet");
    
    AiPlayer Ai = new AiPlayer();
    
    public int shipsPlaced = 0;
    private int orientation = 1;
    
    public Game(){
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
    
    public void playRound(int x, int y){
        System.out.println("Ai Ships, ai Hits:");
        aiShips.boardDisplay();
        aiHits.boardDisplay();
        
        playerTurn(x, y);
        aiTurn();
    }
    
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
		
	if (shot == true){		
            for ( Ship s : playerOneFleet.getShips() ){
                s.checkHit( (char)(x+97)+Integer.toString(y) ); 
            }	
            System.out.println("AI's shot Hit!");
	}
	else
            System.out.println("AI's shot Missed!");        
    }
}