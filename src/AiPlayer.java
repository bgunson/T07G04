import java.util.Random;
import java.util.ArrayList;

public class AiPlayer{
	Random rand = new Random();
	private int coordX;
	private int coordY;
	private boolean hitLastTurn = false;
	private boolean shipDestroyedLastTurn = false;

	/**
	 * shipPlacer will randomly place the default ships for the computer player n its own board.
	 * @param board the board object representing the AI's ship locations.
	 * @param fleet, the ShipTeam object containing the AI's ship objects.
	 */
	public void shipPlacer(Board board, ShipTeam fleet){

		ArrayList<Ship> theShips = fleet.getShipFleet();

		int randomX, randomY;
		for (Ship s : theShips){
			boolean goodPlace = false;
			while (goodPlace == false){
				Random randCoords = new Random();
				randomX = randCoords.nextInt(10);
				randomY = randCoords.nextInt(10);
				if (randomX % 2 == 0)
					goodPlace = board.placeShip(randomX, randomY, s.getShipLength(), 1);
				else
					goodPlace = board.placeShip(randomX, randomY, 1, s.getShipLength());
			}
		}


	}

    /**
     * When called, computer player will shoot on the board (randomly?)...
     */
    public void turn(Board enemyBoard){
    	if(hitLastTurn == false) 
    	{
    		shootNoHit(enemyBoard);
    	}
    	else 
    	{
    		shootLastShotHit(enemyBoard);
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
    
	/**
	 * shootNoHit is one of the two shooting mechanisms of the ai. This is called when the last turn no ship was hit
	 * and based on that it shoots a random spot of the board (making sure it hasn't been shot at before)
	 * @param enemyBoard, uses this board to check if the spot it will shoot at is good
	 */
    public void shootNoHit(Board enemyBoard) 
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
    	//This checks whether or not the ai will have hit anything in the current turn
    	boolean shotHitOrNot = enemyBoard.shotFired(getCoordX(), getCoordY());
   
    	if(shotHitOrNot = true) 
    	{
    		this.hitLastTurn = false;
    	}
    	else 
    	{
    		this.hitLastTurn = false;
    	}
    	
    }
	/**
	 * shootLastShotHit is one of the two shooting mechanisms of the ai. This is called when the last turn a ship was hit
	 * and based on that it shoots around the area of that hit spot
	 * @param enemyBoard, uses this board to check if the spot it will shoot at is good
	 * @return, returns true or false
	 */
    public boolean shootLastShotHit(Board enemyBoard) 
    {
    	
    	
    	return true;
    }

}
