package logic;

import java.util.ArrayList;

/*
Extension of the board object for the players' ship locations.
 */
public class ShipsBoard extends Board{

    /**
     * Constructs ship board via the parent.
     */
    public ShipsBoard(){
        super();
    }
    
    /**
     * @param x - the top left x position of ship
     * @param y - top left y position of ship
     * @param orientation - orientation of ship, 1 = horizontal, 2 = vertical
     * @param ship - ship that is being placed
     * @return true/false depending on if ship placement was successful or not
     */
    public boolean placeShip(int x, int y, int orientation, Ship ship){

        int length = ship.shipLength;
        int height, width;
        if (orientation == 1){ // 1 = horizontal, 2 = vertical
            width = length;
            height = 1;
        }
        else{
            width = 1;
            height = length;			
        }

        // if placing out of grid
        if (( x + width > 10) || (y + height > 10)){ 
     
            // Bad placement.
            return false;
        }
        else{
            // check on if ship already exists in spot
            boolean spaceAvailable = true;
            for(int i = x; i < (x+width); i++){
                for(int j = y; j < (y+height); j++){
                    if (grid[i][j] != " "){
                        spaceAvailable = false;
                        return false;
                    }
                }
            }			
            // places the ship in spot
            if (spaceAvailable){
                ArrayList<String> coordinates = new ArrayList<String>(); // stores what the coordinates of the ship will be

                for(int i = x; i < (x+width); i++){
                    for(int j = y; j < (y+height); j++){
                        grid[i][j] = "G";
                            coordinates.add( Character.toString((char)(i+97))+Integer.toString(j) ); // stores as "letternumber" ex: A1
                    }
                }
                ship.setCoordinates(coordinates); // updates the ships coordinates onces it's been places
                return true; // Good placemnet.
            }
        }
        return false;
    }

    /**
     * shotFired takes an x,y position on the given grid (opponent) and checks if the shot was ahit or miss and
     * changes the value at the given position based on what the outcome is.
     * @param x, the x position of the shot.
     * @param y, the y position of the shot.
     * @return, true if the shot was a hit, false if not.
     */
    public boolean shotFired(int x, int y){
        if (grid[x][y] == "G"){
            return true;
        }
        return false;
    }
    
    
    /**
    * Updates damaged tiles on ships and sunk ships
    * @param shipTeam is the ships that you are checking
    */
    public void updateBoard(ShipTeam shipTeam){
        
        ArrayList<Ship> fleet = shipTeam.getShips();
        
        // Updates damaged ship parts
        for ( Ship ship : fleet ){
            for ( String destroyedTile : ship.getDestroyed() ){
                grid[(int)(destroyedTile.charAt(0) - 97)][Integer.valueOf(destroyedTile.substring(1,2))] = "D";
            }
        }
	
        // Updates sunk ships
        for ( Ship ship : fleet ){
            if (ship.sunk == true){
                for ( String coordinate : ship.getCoordinates() ){
                    grid[(int)(coordinate.charAt(0) - 97)][Integer.valueOf(coordinate.substring(1,2))] = "F";
                }
            }
        }
        
    }



}
