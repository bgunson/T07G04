package logic;

import java.util.Random;
import java.util.ArrayList;

public class AiPlayer {

	private Random rand = new Random();
	private int coordX;
	private int coordY;
	static boolean hitLastTurn = false;
	private boolean shipDestroyedLastTurn = false;
	static int lastTurnX;
	static int lastTurnY;
	static int lastHitX;
	static int lastHitY;
	/**
	 * shipPlacer will randomly place the default ships for the computer player n its own board.
	 * @param board the board object representing the AI's ship locations.
	 * @param fleet, the ShipTeam object containing the AI's ship objects.
	 */
	public void shipPlacer(ShipsBoard board, ShipTeam fleet){

		ArrayList<Ship> theShips = fleet.getShips();

		int randomX, randomY;
		for (Ship s : theShips){
			boolean goodPlace = false;
			while (goodPlace == false){
				Random randCoords = new Random();
				randomX = randCoords.nextInt(10);
				randomY = randCoords.nextInt(10);
				if (randomX % 2 == 0)
					goodPlace = board.placeShip(randomX, randomY, 1, s);
				else
					goodPlace = board.placeShip(randomX, randomY, 2, s);
			}
		}
	}

    /**
     * When called, computer player will shoot on the board (randomly?)...
     */
    public void turn(HitsBoard enemyBoard){
    	
    	if(hitLastTurn == true) 
    	{
    		System.out.println("\n\n\n\nWEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
    		shootLastShotHit(enemyBoard);
    		
    	}
    	else 
    	{
    		shootNoHit(enemyBoard);
    	}
    	
    	
    }
    
    /**
     * Generates a set of coordinates for the ai to use in it's shooting mechanic
     */
    public void setCoords() 
    {
    	this.coordX = rand.nextInt(10);
    	this.coordY = rand.nextInt(10);
    }
    public void setCoordX(int x) 
    {
    	this.coordX = x;
    }
    public void setCoordY(int y) 
    {
    	this.coordY = y;
    }
    
    /**
     * When called the x coordinate is returned
     */
    public int getCoordX() 
    {
    	return this.coordX;
    }
    
    /**
     * When called the y coordinate is returned
     */
    public int getCoordY() 
    {
    	return this.coordY;
    }
    public void setlastTurnCoords() 
    {
    	AiPlayer.lastTurnX = getCoordX();
    	AiPlayer.lastTurnY = getCoordY();
    	if(AiPlayer.hitLastTurn == true) 
    	{
        	AiPlayer.lastHitX = getCoordX();
        	AiPlayer.lastHitY = getCoordY();
    	}
    }
    public int getlastTurnX() 
    {
    	return AiPlayer.lastTurnX;
    }
    public int getlastTurnY() 
    {
    	return AiPlayer.lastTurnY;
    }
    public int getlastHitX() 
    {
    	return AiPlayer.lastHitX;
    }
    public int getlastHitY() 
    {
    	return AiPlayer.lastHitY;
    }
    
	/**
	 * shootNoHit is one of the two shooting mechanisms of the ai. This is called when the last turn no ship was hit
	 * and based on that it shoots a random spot of the board (making sure it hasn't been shot at before)
	 * @param enemyBoard, uses this board to check if the spot it will shoot at is good
	 */
    public void shootNoHit(HitsBoard enemyBoard) 
    {
    	//Condition is used so that coords will be rechosen until they work.
    	boolean condition = true;
    	while(condition == true) 
    	{
    		setCoords();
    		boolean shot = enemyBoard.checkShot(getCoordX(), getCoordY());
    		
    		if(shot == true) 
    		{
    			System.out.println(getCoordX() + " " + getCoordY());
    			condition = false;
    			
    		}
    	}
    	

    }
    
    
    
    
    
    
    
    
    
	/**
	 * shootLastShotHit is one of the two shooting mechanisms of the ai. This is called when the last turn a ship was hit
	 * and based on that it shoots around the area of that hit spot
	 * @param enemyBoard, uses this board to check if the spot it will shoot at is good
	 * @return, returns true or false
	 */
    public void shootLastShotHit(HitsBoard enemyBoard) 
    {
    	//Condition is used so that coords will be rechosen until they work.
    	boolean condition = true;
		int x = getlastTurnX();
		int y = getlastTurnY();
		boolean switchHori = false;
		boolean switchDirection = false;
		boolean validHitSwitch = false;
		int placeHolderX = getlastHitX();
		int placeHolderY = getlastHitY();
		
    	while(condition == true) 
    	{
    		if(validHitSwitch == false) 
    		{

        		if(y < 9 && switchHori == false && switchDirection == false) 
        		{
        			y++;
        		}
        		else if(y == 9 && switchHori == false && switchDirection == false) 
        		{
        			switchDirection = true;
        			y = placeHolderY;
        		}
        		else if(y > 0 && switchHori == false && switchDirection == true)
        		{

        			y--;
        		}
        		
        		else if(y == 0 && switchHori == false && switchDirection == true) 
        		{
        			switchHori = true;
        		}
        		
        		
        		
        		if(x < 9 && switchHori == true) 
        		{
        			x++;
        		}
        		else if(x == 9 && switchHori == true && switchDirection == false) 
        		{
        			switchDirection = true;
        			x = placeHolderX;
        		}
        		else if(x > 0 && switchHori == true && switchDirection == true)
        		{

        			x--;
        		}
        		
        		else if(y == 0 && switchHori == true && switchDirection == true) 
        		{
        			validHitSwitch = true;
        		}
    		}
    		else 
    		{
    			setCoords();
    			x = getCoordX();
    			y = getCoordY();
    		}
    		
    		boolean shot = enemyBoard.checkShot(x, y);
    		
    		if(shot == true) 
    		{
    			System.out.println(x + " " + y);
    			condition = false;
    			
    		}
    		setCoordX(x);
    		setCoordY(y);
    	}

    	
    }

}